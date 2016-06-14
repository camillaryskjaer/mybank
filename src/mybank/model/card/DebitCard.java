/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank.model.card;

/**
 *
 * @author camr
 */
public class DebitCard extends CustomerCard {

    public DebitCard(String owner) {
        super(CardType.Debit, owner);
    }

    @Override
    protected String generatePrefix() {
        return "2400";
    }

}
