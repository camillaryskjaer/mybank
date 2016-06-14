/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank.account;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @author camr
 */
public class RestrictedAccount extends AccountDecorator {

    private LocalDate restrictionDate;

    public RestrictedAccount(Account a, LocalDate restrictedUntil) {
        super(a);
        System.err.println(restrictedUntil.toString());
        restrictionDate = restrictedUntil;
    }

    @Override
    public double getAvailableFunds() {
        //hvor mange penge der er tilrådighed handler om hvornår kontoen er lås til
        if (LocalDate.now().isAfter(restrictionDate)) {
            //Så kan der hæves
            return decoratedAccount.getAvailableFunds();
        } else {
            return 0;
        }

    }

}
