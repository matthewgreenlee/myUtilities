package com.goldenpond.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ValidationUtil {

    private static final String ORACLE_DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
    private static final String SQLSERVER_DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static void validate(DB dbType, String host, int port, String dbName, String user, String password) {
        loadDriver(dbType);
        testConnection(dbType, host, port, dbName, user, password);
    }

    private static void loadDriver(DB type) {
        try {
            if (type.equals(DB.ORACLE)) {
                Class.forName(ORACLE_DRIVER_CLASS);
            }
            else if (type.equals(DB.SQLSERVER)) {
                Class.forName(SQLSERVER_DRIVER_CLASS);
            }
            else {
                throw new RuntimeException("Not supported database:" + type);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("No driver class found for database:" + type);
        }
    }

    private static void testConnection(DB dbType, String host, int port, String dbName, String user, String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(buildUrl(dbType, host, port, dbName), user, password);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    
                }
            }
        }
    }

    private static String buildUrl(DB dbType, String host, int port, String dbName) {
        if (dbType.equals(DB.ORACLE)) {
            return "jdbc:oracle:thin:@" + host + ":" + port + ":" + dbName;
        }
        if (dbType.equals(DB.SQLSERVER)) {
            return "jdbc:sqlserver://"+ host + "\\" + dbName + ":" + port;
        }
        throw new RuntimeException("Not supported database:" + dbType);
    }

    public static void main(String[] args) {
        System.out.println("validation begin");
        try {
            ValidationUtil.validate(DB.ORACLE, "sh-dums01", 1521, "WIND11D2", "YLI_X22", "YLI_X22");
            ValidationUtil.validate(DB.SQLSERVER, "sh-srv-mssql", 1433, "wind", "srv003", "srv003");
            System.out.println("validation passed");
        }
        catch (Exception e) {
            System.out.println("validation failed due to:" + e.getMessage());
        }
    }

    enum DB {
        ORACLE,
        SQLSERVER,
        MYSQL
    }
}
