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
public class WaitingForPinState extends ATMMachineState {

    private int pinTry = 0; //må max være 2 da en bruger så har tastet forkert 3 gange

    public WaitingForPinState(Machine m) {
        super(m);
    }

    /**
     * her skal vi holde styr på flere ting 1. Er pinkoden den samme som er
     * tilknyttet kortet? Hvis ja så skal der laves et tilstandsskifte til
     * "dostuff" ellers skal vi blive i samme tilstand og tælle antallet af pin
     * forsøg een op Hvis brugeren har tastet forkert mere end 3 gange, skiftes
     * der tilstand til CardDeclinedState
     */
    @Override
    public void enterPin(String pin, Card c) {
        if (pin.equals(c.getPin())) {
            //alt er godt og der skiftes tilstand
            pinTry = 0; //nulstiller
            getMachine().setState(getMachine().getWaitingForActionState());

        } else {
            pinTry++;
            if (pinTry == 2) {
                //ups der skal laves et tilstandsskifte til CardDeclinedState
                pinTry = 0; //nulstiller
                getMachine().setState(getMachine().getCardDeclinedState());

            }
        }
    }

}
