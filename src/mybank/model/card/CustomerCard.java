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
public abstract class CustomerCard implements Card {

    private String cardNumber;
    private String owner;
    private CardType type;

    protected CustomerCard(CardType type, String owner) {
        String prefix = generatePrefix();
        cardNumber = generateCardNumber(prefix);
        this.owner = owner;
        this.type=type;
    }

    @Override
    public String getPin() {
        return "0000";
    }

    protected abstract String generatePrefix();

    private final String generateCardNumber(String prefix) {
        return prefix + String.format("%012d", System.identityHashCode(this));

    }

    @Override
    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public String getOwner() {
        return owner;
    }

    @Override
    public CardType getCardType() {
        return type;
    }
}
