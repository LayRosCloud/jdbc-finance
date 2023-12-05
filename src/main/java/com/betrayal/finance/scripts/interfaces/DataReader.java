package com.betrayal.finance.scripts.interfaces;

import com.betrayal.finance.scripts.exceptions.NotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface DataReader<TEntity, VKey>{
    List<TEntity> findAll() throws Exception;
    TEntity findOne(VKey key) throws NotFoundException, SQLException;
}
