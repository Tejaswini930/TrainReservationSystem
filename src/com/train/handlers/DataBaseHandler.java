
package com.train.handlers;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;



public class DataBaseHandler {

    private List<String> sources = new ArrayList<>();
    private List<String> destinations = new ArrayList<>();
    private Connection connection;
    private static DataBaseHandler object = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    private DataBaseHandler() {

        try {

            Statement stmt = null;
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://localhost:5433/TrainSystem";
            Properties parameters = new Properties();
            parameters.put("user", "postgres");
            parameters.put("password", "test@123");
            connection = DriverManager.getConnection(dbURL, parameters);
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static synchronized Connection getConnection() {
        if (object == null) {
            object = new DataBaseHandler();
        }
        return object.connection;

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        connection.close();

    }




}
