package com.betrayal.finance.scripts.interfaces;

import java.sql.SQLException;

public interface DataUpdater<TEntity> {
    int update(TEntity entity) throws SQLException;
}
