package com.betrayal.finance.scripts.interfaces;

import java.sql.SQLException;

public interface DataCreator<TEntity> {
    boolean create(TEntity entity) throws SQLException;
}
