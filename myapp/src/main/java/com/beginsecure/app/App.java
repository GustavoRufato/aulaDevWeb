package com.beginsecure.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App 
{
        public static void main(String[] args) {
            String jdbcUrl = "jdbc:mysql://localhost:3306/UniDevWeb";
            String username = "gustavo";
            String password = "D3ad.spades";
    
            System.out.println("Executando MySQLExample...");
            System.out.println(username);
            System.out.println(password);
    
            try {
                Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
    
                Statement statement = connection.createStatement();
    
                String query = "SELECT * FROM preguica";
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("nome");
                    System.out.println("ID: " + id + ", Nome: " + name);
                }
    
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
