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
public interface Account {
   
    public enum AccountType {Savings, Student,Overdraft,Basic, Youth, ChildSavings, GiftSavings}
    /**@return  Kontonummer*/
    public String getAccountNumber();
    
    /**@return Penge indestående*/
    public double getBalance();
    
      /**@return Penge indestående + evt. kredit - restriktoner f.eks. hvis det er en børneopsparing*/
    public double getAvailableFunds();
    
    public AccountType getAccountType();
    
    public Card getCard();
    
}
