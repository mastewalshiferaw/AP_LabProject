package com.student.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    public static Connection getConnection() {
        Connection connection = null;
        Properties props = new Properties();

        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            
            if (input == null) {
                System.out.println("Sorry, unable to find db.properties");
                return null;
            }

            // Load the properties file
            props.load(input);

            // Load the PostgreSQL Driver
            Class.forName("org.postgresql.Driver");

            // Establish the connection using values from the file
            connection = DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password")
            );

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
        return connection;
    }
}