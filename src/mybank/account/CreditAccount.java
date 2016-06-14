/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank.account;

/**
 *
 * @author camr
 */
public class CreditAccount extends AccountDecorator{

    private double credit =0;
    public CreditAccount(Account a, double credit) {
        super(a);
        this.credit = credit;
    }



  
    @Override
    public double getAvailableFunds() {
           return decoratedAccount.getAvailableFunds()+credit;
    }

  

    
}
