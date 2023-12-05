package com.betrayal.finance.scripts.interfaces;

public interface CRUD<TEntity, VKey>
        extends DataCreator<TEntity>, DataReader<TEntity, VKey>, DataUpdater<TEntity>, DataDeleter<VKey>{ }
