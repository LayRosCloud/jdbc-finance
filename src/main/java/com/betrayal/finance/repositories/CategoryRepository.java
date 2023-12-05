package com.betrayal.finance.repositories;

import com.betrayal.finance.dtos.CreateCategoryDto;
import com.betrayal.finance.dtos.UpdateCategoryDto;
import com.betrayal.finance.entities.CategoryEntity;
import com.betrayal.finance.scripts.constants.Queries;
import com.betrayal.finance.scripts.data.DataConnection;
import com.betrayal.finance.scripts.exceptions.NotFoundException;
import com.betrayal.finance.scripts.interfaces.*;
import com.betrayal.finance.scripts.mappers.CategoryMapper;
import com.betrayal.finance.scripts.parameters.CategoryParameters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoryRepository implements
        DataReader<CategoryEntity, Integer>,
        DataCreator<CreateCategoryDto>,
        DataUpdater<UpdateCategoryDto>,
        DataDeleter<Integer> {

    private final DbMapper<CategoryEntity> mapper;
    private final DbParameters<CreateCategoryDto> parameters;
    private final DataConnection dataConnection;

    public CategoryRepository(){
        mapper = new CategoryMapper();
        dataConnection = new DataConnection();
        parameters = new CategoryParameters();
    }

    @Override
    public List<CategoryEntity> findAll() throws Exception {
        try(Connection connection = dataConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.Category.SELECT_ALL)){
            ResultSet set = statement.executeQuery();

            return mapper.mapAll(set);
        }catch (SQLException ex){
            throw ex;
        }
    }

    @Override
    public CategoryEntity findOne(Integer id) throws NotFoundException, SQLException {
        try(Connection connection = dataConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.Category.SELECT_ONE)){
            parameters.pullParameterId(statement, 1, id);

            ResultSet set = statement.executeQuery();

            return mapper.mapFirst(set);
        }catch (SQLException | NotFoundException e){
            throw e;
        }
    }

    @Override
    public boolean create(CreateCategoryDto createCategoryDto) throws SQLException {
        try(Connection connection = dataConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.Category.INSERT_INTO)){

            parameters.pullParameters(statement, createCategoryDto);

            return statement.execute();
        }catch (SQLException e){
            throw e;
        }
    }

    @Override
    public void destroy(Integer id) throws SQLException {
        try(Connection connection = dataConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.Category.DELETE)){
            parameters.pullParameterId(statement, 1, id);
            statement.execute();
        }catch (SQLException e){
            throw e;
        }
    }

    @Override
    public int update(UpdateCategoryDto updateCategoryDto) throws SQLException {
        try(Connection connection = dataConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.Category.UPDATE)){

            parameters.pullParameters(statement, updateCategoryDto);
            parameters.pullParameterId(statement, 2, updateCategoryDto.getId());

            return statement.executeUpdate();
        }catch (SQLException e){
            throw e;
        }
    }
}
