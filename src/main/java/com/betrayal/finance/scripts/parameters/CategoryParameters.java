package com.betrayal.finance.scripts.parameters;

import com.betrayal.finance.dtos.CreateBankDto;
import com.betrayal.finance.dtos.CreateCategoryDto;
import com.betrayal.finance.scripts.interfaces.DbParameters;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryParameters implements DbParameters<CreateCategoryDto> {
    @Override
    public void pullParameters(PreparedStatement statement, CreateCategoryDto createCategoryDto) throws SQLException {
        statement.setString(1, createCategoryDto.getName());
    }

    @Override
    public void pullParameterId(PreparedStatement statement, int index, int id) throws SQLException {
        statement.setInt(index, id);
    }
}
