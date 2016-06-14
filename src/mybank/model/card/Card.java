/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank.model.card ;

import java.io.Serializable;

/**
 *
 * @author camr
 */
public interface Card extends Serializable{
 
    public static enum CardType {Debit}
    
    public String getPin();

    public String getCardNumber();

    public String getOwner();
    
      public CardType getCardType();
}
