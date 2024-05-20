/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Controller;

/**
 *
 * @author karunmehta
 */
public class AccountDataConnection extends DataConnection {
 
    // SQL queries to be used to persist account business objects as needed by the DAO
    private static final String INSERT_SQL = "INSERT INTO bankaccount (cust_num, balance, create_date, acct_type) VALUES (?, ?, ?, ?)";
    private static final String SELECT_SQL_BYID = "SELECT" +
            " CONCAT(bc.first_name, ' ', bc.last_name) AS customer_name," +
            " ba.acct_num," +
            " ba.balance," +
            " ba.create_date," +
            " ba.last_update_date," +
            " ba.acct_type," +
            " ba.od_limit," +
            " ba.int_rate" +
            " FROM" +
            " bankaccount AS ba" +
            " INNER JOIN bankcustomer AS bc ON ba.cust_id = bc.id" +
            " WHERE ba.acct_num = ?";
    private static final String UPDATE_SQL = "UPDATE bankaccount SET cust_num = ?, balance = ?, create_date = ?, acct_type = ? WHERE acct_num = ?";
    private static final String DELETE_SQL = "DELETE FROM bankaccount WHERE acct_num = ?"; 
    private static final String CUSTOMER_ACCOUNTS_SQL = "SELECT * FROM bankaccount WHERE cust_id = ?";
    public static String getInsert() {
        
        return INSERT_SQL;
    }
    
    public static String getUpdate() {
        
        return UPDATE_SQL;
    }
    
    public static String getSelect() {
        
        return SELECT_SQL_BYID;
    }
    
    public static String getDelete() {
        
        return DELETE_SQL;
    }
    public static String getCustomerAccounts() {
        return CUSTOMER_ACCOUNTS_SQL;
    }
}
