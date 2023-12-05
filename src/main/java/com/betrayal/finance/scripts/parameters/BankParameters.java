package com.betrayal.finance.scripts.parameters;

import com.betrayal.finance.dtos.CreateBankDto;
import com.betrayal.finance.scripts.interfaces.DbParameters;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankParameters implements DbParameters<CreateBankDto> {

    @Override
    public void pullParameters(PreparedStatement statement, CreateBankDto entity) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setDouble(2, entity.getAmountOfMoney());
    }

    @Override
    public void pullParameterId(PreparedStatement statement, int index, int id) throws SQLException {
        statement.setInt(index, id);
    }
}
