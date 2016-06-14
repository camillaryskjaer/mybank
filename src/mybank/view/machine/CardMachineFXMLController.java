/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank.view.machine;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.shape.Rectangle;
import mybank.model.card.Card;
import mybank.model.machine.InsertCardCommand;
import mybank.model.machine.Machine;
import mybank.view.customer.CreditCardCustomerView;

/**
 * FXML Controller class
 *
 * @author camr
 */
public class CardMachineFXMLController implements Initializable {

    @FXML //  fx:id="myButton"
    private Rectangle slip; // Value injected by FXMLLoader

    private Machine model;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        slip.setOnDragOver(new EventHandler<DragEvent>() {

            public void handle(DragEvent event) {
                slip.setId("drag");
                event.acceptTransferModes(TransferMode.ANY);
                event.consume();
            }
        });

        slip.setOnDragExited(new EventHandler<DragEvent>() {

            public void handle(DragEvent event) {
                slip.setId("inner");
                event.consume();
            }
        });
        slip.setOnDragDropped(new EventHandler<DragEvent>() {

            public void handle(DragEvent event) {
                slip.setId("inner");
                //her skal laves noget test på om det er et kreditkort
                if (event.getGestureSource() != this) {

                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if (db.getContent(CreditCardCustomerView.cardDataFormat) != null) {
                        Card c = (Card) db.getContent(CreditCardCustomerView.cardDataFormat);
                       
                        //her skal vi så kalde command 
                        InsertCardCommand cmd = new InsertCardCommand(model, c);
                        cmd.execute();
                         success = true;
                    }

                    event.setDropCompleted(success);
                }

                event.consume();
            }
        });
    }

    public void setModel(Machine m) {
        model = m;
    }

}
