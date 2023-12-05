package com.betrayal.finance.scripts.mappers;

import com.betrayal.finance.entities.CategoryEntity;
import com.betrayal.finance.entities.TransactionEntity;
import com.betrayal.finance.scripts.constants.Fields;
import com.betrayal.finance.scripts.exceptions.NotFoundException;
import com.betrayal.finance.scripts.interfaces.DbMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryMapper implements DbMapper<CategoryEntity> {
    @Override
    public List<CategoryEntity> mapAll(ResultSet set) throws SQLException {
        List<CategoryEntity> categories = new ArrayList<>();

        while(set.next()){
            categories.add(extract(set));
        }

        return categories;
    }

    @Override
    public CategoryEntity mapFirst(ResultSet set) throws SQLException, NotFoundException {
        if(set.next()){
            return extract(set);
        }

        throw new NotFoundException();
    }
    private CategoryEntity extract(ResultSet set) throws SQLException{
        final Integer id = set.getInt(Fields.ID);
        final String name = set.getString(Fields.Category.NAME);

        return new CategoryEntity(id, name);
    }
}
