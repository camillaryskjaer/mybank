package mybank.model.machine;

import mybank.model.card.Card;

/*
 * Dette er selve hæveautomaten, det er den der kan være i mange forskellige tilstande
og derfor implementeres maskinen også med et state pattern
 */
public class Machine implements UserActionMachine{

    //current state holder styr på den aktuelle tilstand i maskinen
    private MachineState currentState = null;
    private final MachineState waitingForCardState, waitingForPinState, waitingForActionState, cardDeclinedState; // can only be initialized once

    public Machine() {
        waitingForCardState = new WaitingForCardState(this);
        waitingForPinState = new WaitingForPinState(this);
        waitingForActionState = new WaitingForActionState(this);
        cardDeclinedState = new CardDeclinedState(this);

        //TODO der hældes penge i maskinen
        System.err.println("Machine is ready");
        currentState = waitingForCardState;
    }

    public void insertCard(Card c) {
            System.err.println("kort nr " + c.getCardNumber());
   
        currentState.insertCard(c);
    }

    /**
     * @return the waitingForCardState
     */
    protected MachineState getWaitingForCardState() {
        return waitingForCardState;
    }

    /**
     * @return the waitingForPinState
     */
    protected MachineState getWaitingForPinState() {
        return waitingForPinState;
    }

    void setState(MachineState state) {
        currentState = state;
    }

    MachineState getCurrentState() {
        return currentState;
    }

    /**
     * @return the waitingForActionState
     */
     MachineState getWaitingForActionState() {
        return waitingForActionState;
    }

    /**
     * @return the cardDeclinedState
     */
     MachineState getCardDeclinedState() {
        return cardDeclinedState;
    }

   

}
