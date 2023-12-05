package com.betrayal.finance.scripts.parameters;

import com.betrayal.finance.dtos.CreateTransactionDto;
import com.betrayal.finance.scripts.interfaces.DbParameters;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionParameters implements DbParameters<CreateTransactionDto> {
    @Override
    public void pullParameters(PreparedStatement statement, CreateTransactionDto createTransactionDto) throws SQLException {
        statement.setInt(1, createTransactionDto.getBankId());
        statement.setInt(2, createTransactionDto.getCategoryId());
        statement.setDouble(3, createTransactionDto.getMoney());
        statement.setBoolean(4, createTransactionDto.getIsConsumption());
        statement.setDate(5, createTransactionDto.getDate());
        statement.setString(6, createTransactionDto.getComment());
    }

    @Override
    public void pullParameterId(PreparedStatement statement, int index, int id) throws SQLException {
        statement.setInt(index, id);
    }
}
