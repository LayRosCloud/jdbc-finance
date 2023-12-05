package com.betrayal.finance.repositories;

import com.betrayal.finance.dtos.CreateBankDto;
import com.betrayal.finance.dtos.UpdateBankDto;
import com.betrayal.finance.entities.BankEntity;
import com.betrayal.finance.scripts.constants.Queries;
import com.betrayal.finance.scripts.data.DataConnection;
import com.betrayal.finance.scripts.exceptions.NotFoundException;
import com.betrayal.finance.scripts.interfaces.*;
import com.betrayal.finance.scripts.mappers.BankMapper;
import com.betrayal.finance.scripts.parameters.BankParameters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BankRepository implements
        DataReader<BankEntity, Integer>,
        DataCreator<CreateBankDto>,
        DataUpdater<UpdateBankDto>,
        DataDeleter<Integer> {
    private final DbMapper<BankEntity> mapper;
    private final DbParameters<CreateBankDto> parameters;

    private final DataConnection dataConnection;
    public BankRepository(){
        mapper = new BankMapper();
        dataConnection = new DataConnection();
        parameters = new BankParameters();
    }
    @Override
    public List<BankEntity> findAll() throws Exception {
        try(Connection connection = dataConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.Bank.SELECT_ALL)){
            ResultSet set = statement.executeQuery();

            return mapper.mapAll(set);
        }catch (SQLException ex){
            throw ex;
        }
    }

    @Override
    public BankEntity findOne(Integer id) throws NotFoundException, SQLException {
        try(Connection connection = dataConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.Bank.SELECT_ONE)){
            parameters.pullParameterId(statement, 1, id);

            ResultSet set = statement.executeQuery();

            return mapper.mapFirst(set);
        }catch (SQLException | NotFoundException e){
            throw e;
        }
    }

    @Override
    public boolean create(CreateBankDto bankEntity) throws SQLException {
        try(Connection connection = dataConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.Bank.INSERT_INTO)){

            parameters.pullParameters(statement, bankEntity);

            return statement.execute();
        }catch (SQLException e){
            throw e;
        }
    }

    @Override
    public void destroy(Integer id) throws SQLException {
        try(Connection connection = dataConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.Bank.DELETE)){
            parameters.pullParameterId(statement, 1, id);
            statement.execute();
        }catch (SQLException e){
            throw e;
        }
    }
    @Override
    public int update(UpdateBankDto bankEntity) throws SQLException {
        try(Connection connection = dataConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.Bank.UPDATE)){

            parameters.pullParameters(statement, bankEntity);
            parameters.pullParameterId(statement, 3, bankEntity.getId());

            return statement.executeUpdate();
        }catch (SQLException e){
            throw e;
        }
    }
}
