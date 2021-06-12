package model;

import com.sun.rowset.CachedRowSetImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DBConnect {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "root";
    public static final String UUID ="1";
    public static final String USERNAME="username";
    public static final String PASSWORD="password";
    public static final String URLSITE="siteURL";
    public static final String NAMESITE="siteName";
    public static final String COMMENT ="comment";
    public static final String CATEGORY ="category";
    public static final String DATE ="date";

    public static Connection dbConnection() {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void updateDb(String sqlStmt) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        try {
            dbConnection=dbConnection();
            statement = dbConnection.createStatement();
            statement.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public static ObservableList<Note> getDataFromDb(String query) throws SQLException {
        ObservableList<Note> users = FXCollections.observableArrayList();
        Connection dbConnection = null;
        Statement statement = null;
        try {
            dbConnection = dbConnection();
            Statement statement1 = dbConnection.createStatement();
            ResultSet rs = statement1.executeQuery(query);
            while (rs.next()) {
                Note user = new Note("1","1","1","1","1","1","1");
                user.setUsername(rs.getString(USERNAME));
                user.setPassword(rs.getString(PASSWORD));
                user.setSiteURL(rs.getString(URLSITE));
                user.setSiteName(rs.getString(NAMESITE));
                user.setComment(rs.getString(COMMENT));
                user.setCategory(rs.getString(CATEGORY));
                user.setDate(rs.getString(DATE));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    public static void createDb() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = dbConnection();
            stmt = conn.createStatement();
            String sql = "CREATE DATABASE manager";
            stmt.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void createTable() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = dbConnection();
            stmt = conn.createStatement();
            String sql = "CREATE TABLE manager.manager " +
                    "(username VARCHAR(45) NULL," +
                    "password VARCHAR(45) NULL," +
                    "siteURL VARCHAR(45) NULL," +
                    "siteName VARCHAR(45) NULL," +
                    "comment VARCHAR(45) NULL," +
                    "category VARCHAR(45) NULL," +
                    "date VARCHAR(45) NULL);";
            stmt.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}