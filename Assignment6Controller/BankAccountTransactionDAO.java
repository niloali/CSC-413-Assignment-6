//Nilofar Ali
//CSC 413 Spring 2024
//Assignment 6
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Controller;

import Assignment6Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karunmehta
 */

public class BankAccountTransactionDAO implements DAOInterface<BankAccountTransaction> {

    static Connection connection = null;
    PreparedStatement pStatement;
    ResultSet result;
    
    BankAccountTransactionDAO() {

            connection = DataConnection.getDBConnection();      

    }
       
    
    // Method to disconnect from the database
    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // Method to insert a user into the database
    @Override
    public int create(BankAccountTransaction at) throws SQLException {
        
        int res = -1;
        pStatement = connection.prepareStatement(TransactionDataConnection.getInsert());
        pStatement.setTimestamp(1, at.getCreateDate());
        pStatement.setString(2, at.getType());
        pStatement.setDouble(3, at.getAmount());
        pStatement.setString(4, at.getDescription());
        pStatement.setInt(5, at.id());
      
        res = pStatement.executeUpdate();
        disconnect();
        
        return res;
    }

    // Method to retrieve a uscustomeraddress from the database by ID
    @Override
    public BankAccountTransaction get(int acctID) throws SQLException {

        pStatement = connection.prepareStatement(AccountDataConnection.getSelect());
        pStatement.setInt(1,acctID);
        result = pStatement.executeQuery();
        
        BankAccountTransaction at = null;
        if (result.next()) {
            at = new BankAccountTransaction();
            at.setCreateDate(result.getTimestamp("create_date"));
            at.setType(result.getString("tran_type"));
            at.setAmount(result.getDouble("amount"));
            at.setDescription(result.getString("summary"));
            at.setID(result.getInt("acct_id"));
        }

        return at;
    }

    // Updating transaction not allowed
    @Override
    public int update(BankAccountTransaction t) throws SQLException {
        
        System.out.println("Once created, cannot update transaction for an account");
        
        return -1;
    }

    // Deleting transaction not allowed
    @Override
    public int delete(BankAccountTransaction t) throws SQLException {
        
        System.out.println("Once created, cannot delete transaction for an account");
        
        return -1;
    }

    public List<BankAccountTransaction> searchByAccountId(String accountId) throws SQLException {
        List<BankAccountTransaction> transactions = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement(TransactionDataConnection.getSelect());
        preparedStatement.setString(1, accountId);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            BankAccountTransaction trans = new BankAccountTransaction();
            trans.setAmount(Double.parseDouble(resultSet.getString("amount")));
            trans.setDescription(resultSet.getString("summary"));
            trans.setType(resultSet.getString("tran_type"));
            trans.setCreateDate(resultSet.getTimestamp("create_date"));
            trans.setID(Integer.parseInt(resultSet.getString("acct_id")));

            transactions.add(trans);
        }

        return transactions;
    }
    
}

