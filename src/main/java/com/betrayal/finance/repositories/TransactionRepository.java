package com.betrayal.finance.repositories;

import com.betrayal.finance.dtos.CreateTransactionDto;
import com.betrayal.finance.dtos.UpdateTransactionDto;
import com.betrayal.finance.entities.TransactionEntity;
import com.betrayal.finance.scripts.constants.Queries;
import com.betrayal.finance.scripts.data.DataConnection;
import com.betrayal.finance.scripts.exceptions.NotFoundException;
import com.betrayal.finance.scripts.interfaces.*;
import com.betrayal.finance.scripts.mappers.TransactionMapper;
import com.betrayal.finance.scripts.parameters.TransactionParameters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TransactionRepository implements
        DataReader<TransactionEntity, Integer>,
        DataCreator<CreateTransactionDto>,
        DataUpdater<UpdateTransactionDto>,
        DataDeleter<Integer> {

    private final DbMapper<TransactionEntity> mapper;
    private final DbParameters<CreateTransactionDto> parameters;

    private final DataConnection dataConnection;
    public TransactionRepository(){
        mapper = new TransactionMapper();
        dataConnection = new DataConnection();
        parameters = new TransactionParameters();
    }

    @Override
    public boolean create(CreateTransactionDto createTransactionDto) throws SQLException {
        try(Connection connection = dataConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.Transaction.INSERT_INTO)){

            parameters.pullParameters(statement, createTransactionDto);

            return statement.execute();
        }catch (SQLException e){
            throw e;
        }
    }

    @Override
    public void destroy(Integer id) throws SQLException {
        try(Connection connection = dataConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.Transaction.DELETE)){
            parameters.pullParameterId(statement, 1, id);
            statement.execute();
        }catch (SQLException e){
            throw e;
        }
    }

    @Override
    public List<TransactionEntity> findAll() throws Exception {
        try(Connection connection = dataConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.Transaction.SELECT_ALL)){
            ResultSet set = statement.executeQuery();

            return mapper.mapAll(set);
        }catch (SQLException ex){
            throw ex;
        }
    }

    @Override
    public TransactionEntity findOne(Integer id) throws NotFoundException, SQLException {
        try(Connection connection = dataConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.Transaction.SELECT_ONE)){
            parameters.pullParameterId(statement, 1, id);

            ResultSet set = statement.executeQuery();

            return mapper.mapFirst(set);
        }catch (SQLException | NotFoundException e){
            throw e;
        }
    }

    @Override
    public int update(UpdateTransactionDto updateTransactionDto) throws SQLException {
        try(Connection connection = dataConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.Transaction.UPDATE)){

            parameters.pullParameters(statement, updateTransactionDto);
            parameters.pullParameterId(statement, 7, updateTransactionDto.getId());

            return statement.executeUpdate();
        }catch (SQLException e){
            throw e;
        }
    }
}
