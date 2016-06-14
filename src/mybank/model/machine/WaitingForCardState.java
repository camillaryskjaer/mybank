
package mybank.model.machine;

import mybank.model.card.Card;

/*
 *I denne tilstand står maskinen og venter på at der indsættes et kort i maskinen
 */
public class WaitingForCardState extends ATMMachineState{
    
    public WaitingForCardState(Machine m) {
        super(m);
    }
    
     
    @Override
    public void insertCard(Card c) {
      System.err.println("Card added");
      //skift tilstand til waitingForPin
      getMachine().setState(getMachine().getWaitingForPinState());
    }
}
