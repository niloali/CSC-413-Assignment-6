//Nilofar Ali
//CSC 413 Spring 2024
//Assignment 6
package Assignment6Controller;

import Assignment6Model.BankAccount;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDTO {
    static AccountDAO accountDAO = new AccountDAO();

    // default custructor
    public AccountDTO() {

    }

    public static List<Integer> getCustomerAccounts(int cust_id){
        List<Integer> accounts = new ArrayList<Integer>();
        try{
            accounts=accountDAO.readAll(cust_id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return accounts;
    }
    public static BankAccount accountById(int accountId) {

        BankAccount bankAccount = null;

        try {
            bankAccount = accountDAO.get(accountId);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        if (bankAccount != null)
            System.out.println(bankAccount.toString());

        System.out.println("\nFetched account with ID: " + accountId + " Customer Details:\n" + bankAccount.toString());
        return bankAccount;

    }
}
