/*
 Dette er den abstrakte klasse, som alle state objekter arver fra. Den giver mulighed for ikke at implementere alle metoder i subklassen, hvor de ikke er nødvendige

 */
package mybank.model.machine;

import mybank.model.card.Card;

/**
 *
 * @author camr
 */
public class ATMMachineState implements MachineState {

    private Machine m;

    public ATMMachineState(Machine m) {
        this.m = m;
    }

    @Override
    public void insertCard(Card c) {
        System.err.println("Du kan ikke indsætte et kort i maskinen tilstand: " + m.getCurrentState().getClass().getSimpleName());
    }

    /**
     * @return the machine
     */
    protected Machine getMachine() {
        return m;
    }

    @Override
    public void enterPin(String pin, Card c) {
      System.err.println("Du kan ikke taste en pin på nuværende tidspunkt tilstand: " + m.getCurrentState().getClass().getSimpleName());
     }

}
