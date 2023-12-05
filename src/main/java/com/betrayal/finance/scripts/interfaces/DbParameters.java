package com.betrayal.finance.scripts.interfaces;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface DbParameters<TEntity> {
    void pullParameters(PreparedStatement statement, TEntity entity) throws SQLException;
    void pullParameterId(PreparedStatement statement, int index, int id) throws SQLException;
}
