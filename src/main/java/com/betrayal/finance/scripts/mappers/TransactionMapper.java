package com.betrayal.finance.scripts.mappers;

import com.betrayal.finance.entities.TransactionEntity;
import com.betrayal.finance.scripts.constants.Fields;
import com.betrayal.finance.scripts.exceptions.NotFoundException;
import com.betrayal.finance.scripts.interfaces.DbMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class TransactionMapper implements DbMapper<TransactionEntity> {
    @Override
    public List<TransactionEntity> mapAll(ResultSet set) throws SQLException {
        List<TransactionEntity> transactions = new ArrayList<>();

        while(set.next()){
            transactions.add(extract(set));
        }

        return transactions;
    }

    @Override
    public TransactionEntity mapFirst(ResultSet set) throws SQLException, NotFoundException {
        if(set.next()){
            return extract(set);
        }

        throw new NotFoundException();
    }
    private TransactionEntity extract(ResultSet set) throws SQLException{
        final Integer id = set.getInt(Fields.ID);
        final Integer bankId = set.getInt(Fields.Transaction.BANK_ID);
        final Integer categoryId = set.getInt(Fields.Transaction.CATEGORY_ID);
        final Double money = set.getDouble(Fields.Transaction.MONEY);
        final Boolean isConsumption = set.getBoolean(Fields.Transaction.IS_CONSUMPTION);
        final Date date = set.getDate(Fields.Transaction.DATE);
        final String comment = set.getString(Fields.Transaction.COMMENT);


        return new TransactionEntity(id, bankId, categoryId, money, isConsumption, date, comment);
    }
}
