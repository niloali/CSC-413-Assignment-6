//Nilofar Ali
//CSC 413 Spring 2024
//Assignment 6
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author karunmehta
 */
public class BankAccountTransaction implements TransactionInterface {
    
    // Create instance variables
    private int id;
    private Timestamp createDate;
    private double amount;
    private String description;
    private String status;
    private BankAccount sourceAccount;
    private BankAccount destinationAccount;
    private String type;
    
        //1-arg constructor
    public BankAccountTransaction() {
        Date dt = new Date();
        createDate = new Timestamp(dt.getTime());
    }
    
    BankAccountTransaction(BankAccount anAccount) {
        
        Date dt = new Date();
        
        createDate = new Timestamp(dt.getTime());
        sourceAccount = anAccount;
        
    }   
    
    BankAccountTransaction(BankAccount source, BankAccount target) {
        sourceAccount = source;
        destinationAccount = target;
        
    }   
    
    // Setters and getters for the FriscoCommunityBankAccount object
    
    public Timestamp getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(Timestamp ld) {
        createDate = ld;
    }
    
    public void setID(int anId) {
        id = anId;
    }    
    
    public int id() {
        return id;
    }  

    public void setAmount(double aBalance) {
        amount = aBalance;
    }
    
    public double getAmount() {
        
        return amount;

    }

    public String getType() {
        return type;
    }  
    
    public void setType(String tp) {
        type = tp;
    }

    public BankAccount getSourceAccount() {
        return sourceAccount;
    }      

    public BankAccount getTargetAccount() {
        return destinationAccount;
    } 

    public void setDescription(String desc) {
        description = desc;
    }    

    public String getDescription() {
        return description;
    }  
    
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("%-10s: %s%n    ", "Account #", this.id()));
        str.append(String.format("%-10s: %s%n    ", "Transaction Date", this.createDate.toString()));
        str.append(String.format("%-10s: %.2f%n    ", "Transaction Amount", this.getAmount()));

        if (this.getSourceAccount() != null)
            str.append(String.format("%-10s: %s%n    ", "Source Account", this.getSourceAccount().toString()));
        else if (this.getTargetAccount() != null)
            str.append(String.format("%-10s: %s%n", "Target Account", this.getTargetAccount().toString()));

        return str.toString();
    }


    public void execute() {
        this.execute();
    }  
    
}


