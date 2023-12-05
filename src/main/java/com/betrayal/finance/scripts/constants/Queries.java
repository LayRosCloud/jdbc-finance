package com.betrayal.finance.scripts.constants;

public class Queries {
    public static class Bank {
        public static final String TABLE_NAME = "`banks`";
        public static final String SELECT_ALL
                = String.format("SELECT * FROM %s;", TABLE_NAME);
        public static final String SELECT_ONE
                = String.format("SELECT * FROM %s WHERE %s = ?;", TABLE_NAME, Fields.ID);
        public static final String INSERT_INTO
                = String.format("INSERT INTO %s(%s, %s) VALUES (?, ?);", TABLE_NAME, Fields.Bank.NAME, Fields.Bank.AMOUNT_OF_MONEY);
        public static final String UPDATE
                = String.format("UPDATE %s SET %s = ?, %s = ? WHERE %s = ?", TABLE_NAME, Fields.Bank.NAME, Fields.Bank.AMOUNT_OF_MONEY, Fields.ID);
        public static final String DELETE
                = String.format("DELETE FROM %s WHERE %s = ?", TABLE_NAME, Fields.ID);
    }
    public static class Transaction{
        public static final String TABLE_NAME = "`transactions`";
        public static final String SELECT_ALL
                = String.format("SELECT * FROM %s;", TABLE_NAME);
        public static final String SELECT_ONE
                = String.format("SELECT * FROM %s WHERE %s = ?;", TABLE_NAME, Fields.ID);
        public static final String INSERT_INTO
                = String.format("INSERT INTO %s(%s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?);",
                TABLE_NAME,
                Fields.Transaction.BANK_ID,
                Fields.Transaction.CATEGORY_ID,
                Fields.Transaction.MONEY,
                Fields.Transaction.IS_CONSUMPTION,
                Fields.Transaction.DATE,
                Fields.Transaction.COMMENT);
        public static final String UPDATE
                = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?",
                TABLE_NAME,
                Fields.Transaction.BANK_ID,
                Fields.Transaction.CATEGORY_ID,
                Fields.Transaction.MONEY,
                Fields.Transaction.IS_CONSUMPTION,
                Fields.Transaction.DATE,
                Fields.Transaction.COMMENT,
                Fields.ID);
        public static final String DELETE
                = String.format("DELETE FROM %s WHERE %s = ?", TABLE_NAME, Fields.ID);
    }
    public static class Category{
        public static final String TABLE_NAME = "`categories`";
        public static final String SELECT_ALL
                = String.format("SELECT * FROM %s;", TABLE_NAME);
        public static final String SELECT_ONE
                = String.format("SELECT * FROM %s WHERE %s = ?;", TABLE_NAME, Fields.ID);
        public static final String INSERT_INTO
                = String.format("INSERT INTO %s(%s) VALUES (?);", TABLE_NAME, Fields.Category.NAME);
        public static final String UPDATE
                = String.format("UPDATE %s SET %s = ? WHERE %s = ?", TABLE_NAME, Fields.Category.NAME, Fields.ID);
        public static final String DELETE
                = String.format("DELETE FROM %s WHERE %s = ?", TABLE_NAME, Fields.ID);
    }
}
