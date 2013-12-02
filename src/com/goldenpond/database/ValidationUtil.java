package com.goldenpond.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ValidationUtil {

    public static final String ORACLE = "ORACLE";
    public static final String SQLSERVER = "SQLSERVER";

    private static final String ORACLE_DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
    private static final String SQLSERVER_DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static void validate(String dbType, String host, int port, String dbName, String user, String password) {
        loadDriver(dbType);
        testConnection(dbType, host, port, dbName, user, password);
    }

    private static void loadDriver(String dbType) {
        try {
            if (ORACLE.equals(dbType)) {
                Class.forName(ORACLE_DRIVER_CLASS);
            }
            else if (SQLSERVER.equals(dbType)) {
                Class.forName(SQLSERVER_DRIVER_CLASS);
            }
            else {
                throw new RuntimeException("Not supported database:" + dbType);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("No driver class found for database:" + dbType);
        }
    }

    private static void testConnection(String dbType, String host, int port, String dbName, String user, String password) {
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

    private static String buildUrl(String dbType, String host, int port, String dbName) {
        if (ORACLE.equals(dbType)) {
            return "jdbc:oracle:thin:@" + host + ":" + port + ":" + dbName;
        }
        if (SQLSERVER.equals(dbType)) {
            return "jdbc:sqlserver://"+ host + "\\" + dbName + ":" + port;
        }
        throw new RuntimeException("Not supported database:" + dbType);
    }

    public static void main(String[] args) {
        System.out.println("validation begin");
        try {
            ValidationUtil.validate("ORACLE", "sh-dums01", 1521, "WIND11D2", "YLI_X22", "YLI_X22");
            ValidationUtil.validate("SQLSERVER", "sh-srv-mssql", 1433, "wind", "srv003", "srv003");
            System.out.println("validation passed");
        }
        catch (Exception e) {
            System.out.println("validation failed due to:" + e.getMessage());
        }
    }

}
