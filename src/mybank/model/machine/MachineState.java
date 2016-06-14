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
public interface MachineState {
    
    public void insertCard(Card c);
    public void enterPin(String pin, Card c);
}
