package com.betrayal.finance.scripts.data;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {
    //@Value("${spring.datasource.url}")
    private String url = "jdbc:mysql://127.0.0.1:3306/finance";

    //@Value("${spring.datasource.username}")
    private String userName = "finance_user";

    //@Value("${spring.datasource.password}")
    private String password = "uniquePassword";

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, userName, password);
        return connection;
    }
}
