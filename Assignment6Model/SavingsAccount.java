//Nilofar Ali
//CSC 413 Spring 2024
//Assignment 6
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6Model;

/**
 *
 * @author kmehta
 */
public class SavingsAccount extends BankAccount {
    
    public SavingsAccount() {
        super();
        balance = 2000;
        this.setType("Savings");
    }
    
    public SavingsAccount(int accountNum) {
        super();
        this.accountNum = accountNum;
        this.setType("Savings");
    } 
    
    public int compareTo(BankAccount ba) {
        
        if(ba.getCreateDate().compareTo(this.getCreateDate()) > 1)
            return -1;
        else if(ba.getCreateDate().compareTo(this.getCreateDate()) < 1)
            return 1;
        else return 0;

    }   

     
}
