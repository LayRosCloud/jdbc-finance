package com.betrayal.finance.scripts.interfaces;

import java.sql.SQLException;

public interface DataDeleter <TKey>{
    void destroy(TKey key) throws SQLException;
}
