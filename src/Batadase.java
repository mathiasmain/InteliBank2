import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

public class Batadase {
    public Connection   conn;
    public String       username;
    public String       password;
    public String       url;
    // Constructor
    public Batadase() {
        try {
            File f = new File("C:\\Users\\Matheus\\Desktop\\elephant.txt");
            Scanner s = new Scanner(f);
            int i = 0;
            while (s.hasNextLine())
            {
                if (i==0) {
                    this.url = s.nextLine();
                }
                else if (i==1)
                {
                    this.username = s.nextLine();
                }
                else if (i==2)
                {
                    this.password = s.nextLine();
                }
                i++;
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("Generic error wile reading BD info:\n" + e.getMessage());
        }



        String sql = "CREATE DATABASE IF NOT EXISTS IB_DB;";
        String sql2 = "CREATE TABLE IF NOT EXISTS IB_DB.Persons(" +
                "id_account INT NOT NULL AUTO_INCREMENT," +
                "user_type VARCHAR(20) NOT NULL," +
                "first_name VARCHAR(20) NOT NULL," +
                "last_name  VARCHAR(40) NOT NULL," +
                "birth_date DATE NOT NULL," +
                "email VARCHAR(100) NOT NULL," +
                "password VARCHAR(20) NOT NULL," +
                "account_number INT NOT NULL," +
                "Balance DOUBLE NOT NULL," +
                "start_date DATE NOT NULL," +
                "status VARCHAR(20) NOT NULL," +
                "PRIMARY KEY(id_account));";

        String sql3 = "CREATE TABLE IF NOT EXISTS IB_DB.Transactions(" +
                "id_transaction INT NOT NULL AUTO_INCREMENT," +
                "transaction_type VARCHAR(20) NOT NULL," +
                "amount DOUBLE NOT NULL," +
                "date TIMESTAMP NOT NULL," +
                "id_indv1 INT NOT NULL," +
                "account_number INT NOT NULL," +
                "PRIMARY KEY(id_transaction));";

        String sql4 = "CREATE TABLE IF NOT EXISTS IB_DB.Loans(" +
                "id_transaction INT NOT NULL AUTO_INCREMENT," +
                "transaction_type VARCHAR(20) NOT NULL," +
                "amount DOUBLE NOT NULL," +
                "date TIMESTAMP NOT NULL," +
                "id_indv1 INT NOT NULL," +
                "interest_rate INT NOT NULL,"+
                "Schedule_date TIMESTAMP NOT NULL,"+
                "isResolved BOOLEAN NOT NULL,"+
                "PRIMARY KEY(id_transaction));";

        OpenConn();
        try {
            conn.prepareStatement(sql).execute();
        } catch (SQLException e) {
            System.out.println("Erro ao criar a DB.");
        } finally {
            CloseConn();
        }

        OpenConn();
        try {
            conn.prepareStatement(sql2).execute();
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela de usuários.\n\n" + e);
        } finally {
            CloseConn();
        }

        OpenConn();
        try {
            conn.prepareStatement(sql3).execute();
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela de transações.\n\n" + e);
        } finally {
            CloseConn();
        }

        OpenConn();
        try {
            conn.prepareStatement(sql4).execute();
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela de transações.\n\n" + e);
        } finally {
            CloseConn();
        }
    }
    // Métodos.
    public void OpenConn() {

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar na base de dados:\n\n" + e);
            conn = null;
        }
    }

    public void CloseConn() {
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (SQLException e) {
            System.out.println("Erro em desconectar do banco");
        }
    }
}
