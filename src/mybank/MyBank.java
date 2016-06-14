/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank;

import mybank.datalayer.CustomerDAOImp;
import mybank.model.card.Card;
import mybank.model.card.DebitCard;
import mybank.model.machine.Machine;

/**
 *
 * @author camr
 */
public class MyBank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Machine m = new Machine();
    //    Card c = new DebitCard();
      //  m.insertCard(c);
       new CustomerDAOImp();
    }
    
}
