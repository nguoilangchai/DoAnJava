package com.nguoilangchai.doanjava.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database 
{
    public static Connection openConnection() throws Exception
    {     
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
        String connectionUrl = "jdbc:sqlserver://localhost;database=DoAn;";
        String username = "sa";
        String password = "trieu123";
        Connection con = DriverManager.getConnection(connectionUrl, username, password);
            
        return con;
    }          
}