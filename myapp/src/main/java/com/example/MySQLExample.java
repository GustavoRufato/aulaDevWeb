package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLExample {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/UniDevWeb";
        String username = "root";
        String password = "root";

        System.out.println("Executando MySQLExample...");
        System.out.println(username);
        System.out.println(password);

        try {
            // Estabelecendo a conexão com o banco de dados
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Criando uma declaração para executar SQL
            Statement statement = connection.createStatement();

            // Executando uma consulta SELECT simples
            String query = "SELECT * FROM preguica";
            ResultSet resultSet = statement.executeQuery(query);

            // Iterando pelos resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Nome: " + name);
            }

            // Fechando a conexão
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
