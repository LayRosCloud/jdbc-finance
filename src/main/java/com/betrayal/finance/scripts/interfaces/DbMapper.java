package com.betrayal.finance.scripts.interfaces;

import com.betrayal.finance.scripts.exceptions.NotFoundException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DbMapper<TEntity> {
    List<TEntity> mapAll(ResultSet set) throws SQLException;
    TEntity mapFirst(ResultSet set) throws SQLException, NotFoundException;
}
