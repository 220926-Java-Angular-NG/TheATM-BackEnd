package com.revature.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    private static Connection conn;
    private static Properties properties;

    private ConnectionManager()
    {

    }

    public static Connection getConnection() throws SQLException {
        if(properties == null)
        {
            properties = loadProperties();
        }
        if(conn == null || conn.isClosed())
        {
            conn = DriverManager.getConnection(properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password")
            );
        }
        return conn;
    }

    private static Properties loadProperties()
    {
        Properties properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/jdbc.properties");
            properties.load(fileInputStream);


        }catch(IOException fileNotFoundException)
        {
            System.out.println(fileNotFoundException.getMessage());
        }
        return properties;
    }



}
