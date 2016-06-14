/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank.model.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mybank.account.Account;

/**
 *
 * @author camr
 */
public class Customer {

    private String firstName;
    private String lastName;
    private List<Account> accounts = new ArrayList();

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the accounts
     */
    public List<Account> getAccounts() {
        return accounts;
    }

    public enum Sex {
        Female, Male
    };

    private String birth; //Dansk cprnummer
    private Sex sex;

    public Customer(String firstName, String lastName, String birth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;

        int lastDigit = Integer.parseInt(birth.substring(birth.length() - 1));

        if (lastDigit % 2 == 0) {
            sex = Sex.Female;
        } else {
            sex = Sex.Male;
        }
    }

    public Sex getGender() {
        int lastDigit = Integer.parseInt(birth.substring(birth.length() - 1));

        if (lastDigit % 2 == 0) {
            return Sex.Female;
        }
        return Sex.Male;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
    
    public void addAccount(Account a){
         getAccounts().add(a);
           System.err.println(getAccounts().size()+"**");
     
    }

}
