//Nilofar Ali
//CSC 413 Spring 2024
//Assignment 6
/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package Assignment6Controller;

/**
 *
 * @author karunmehta
 */
public class CustomerAddressDataConnection extends DataConnection {


    // SQL queries to be used to persist customer business objects as needed by the DAO

    private static final String UPDATE_SQL = "UPDATE customeraddress SET streetnum = ?, streetname = ?, city = ?, state = ?, zip = ? WHERE cusd = ?";


    public CustomerAddressDataConnection() {
    }

    public static String getUpdate() {
        return UPDATE_SQL;
    }
}
