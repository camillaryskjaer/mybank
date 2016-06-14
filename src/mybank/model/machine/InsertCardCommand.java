/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank.model.machine;

import mybank.model.card.Card;

/**
 *
 * @author camr
 */
public class InsertCardCommand implements Command {

    private Machine m;
    private Card c;

    public InsertCardCommand(Machine m, Card c) {
        this.m = m;
        this.c = c;
    }

    @Override
    public void execute() {
        m.insertCard(c);
     
    }

}
