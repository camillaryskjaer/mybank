/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank.account;

import mybank.model.card.Card;

/**
 *
 * @author camr
 */
public class CustomerAccount implements Account{

    private String accountNumber;
    private double balance=0;
    private AccountType accounttype;
    private Card card;
    
    public CustomerAccount(AccountType accounttype){
       accountNumber= generateAccountNumber();
       this.accounttype = accounttype;
    }
    
    /**
     @param intitialDeposit Kan bruges til at sætte penge ind med de samme*/
     public CustomerAccount(Card card,AccountType accounttype,Double intitialDeposit){
       this(accounttype); //Kalder superklassen
       balance = intitialDeposit;
       this.card = card;
    }

     
    
    /**@return Et autogenereret kontonummer*/
    private String generateAccountNumber(){
     //Alle objekter har et unikt identifikationssnummer og det er det der er brug som kontonummer
       return "3520"+String.format("%010d", System.identityHashCode(this));
    }
    

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public double getBalance() {
       return balance;
    }

    @Override
    public double getAvailableFunds() {
        return balance;
    }

    @Override
    public AccountType getAccountType() {
        return accounttype;
    }

    /**
     * @return the card
     */
    public Card getCard() {
        return card;
    }

    /**
     * @param card the card to set
     */
     void setCard(Card card) {
         //TODO her skal smides en exception, hvis det er det forkerte kort
        this.card = card;
    }
    
}
