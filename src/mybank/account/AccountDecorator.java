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
public abstract class AccountDecorator implements Account {

    protected Account decoratedAccount;

    public AccountDecorator(Account a) {
        decoratedAccount = a;
    }

    @Override
    public AccountType getAccountType() {
        return decoratedAccount.getAccountType();
    }

    @Override
    public double getBalance() {
        return decoratedAccount.getBalance();
    }

    @Override
    public String getAccountNumber() {
        return decoratedAccount.getAccountNumber();
    }
    
    @Override
    public Card getCard() {
        return decoratedAccount.getCard();
    }
}
