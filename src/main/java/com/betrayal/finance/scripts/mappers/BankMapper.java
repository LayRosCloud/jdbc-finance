package com.betrayal.finance.scripts.mappers;

import com.betrayal.finance.entities.BankEntity;
import com.betrayal.finance.scripts.constants.Fields;
import com.betrayal.finance.scripts.exceptions.NotFoundException;
import com.betrayal.finance.scripts.interfaces.DbMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankMapper implements DbMapper<BankEntity> {
    @Override
    public List<BankEntity> mapAll(ResultSet set) throws SQLException {
        List<BankEntity> bankEntities = new ArrayList<>();

        while(set.next()){
            bankEntities.add(extract(set));
        }

        return bankEntities;
    }

    @Override
    public BankEntity mapFirst(ResultSet set) throws SQLException, NotFoundException {
        if(set.next()){
            return extract(set);
        }

        throw new NotFoundException();
    }

    private BankEntity extract(ResultSet set) throws SQLException{
        final Integer id = set.getInt(Fields.ID);
        final String name = set.getString(Fields.Bank.NAME);
        final Double amountOfMoney = set.getDouble(Fields.Bank.AMOUNT_OF_MONEY);

        return new BankEntity(id, name, amountOfMoney);
    }
}
