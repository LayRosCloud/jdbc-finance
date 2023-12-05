package com.betrayal.finance.scripts.constants;

public class Fields {
    public static final String ID = "id";

    public static class Bank{
        public static final String NAME = "name";
        public static final String AMOUNT_OF_MONEY = "amount_of_money";
    }

    public static class Transaction{
        public static final String BANK_ID = "bank_id";
        public static final String CATEGORY_ID = "category_id";
        public static final String MONEY = "money";
        public static final String IS_CONSUMPTION = "is_consumption";
        public static final String DATE = "date";
        public static final String COMMENT = "comment";
    }

    public static class Category{
        public static final String NAME = "name";
    }
}
