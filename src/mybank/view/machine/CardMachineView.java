/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank.view.machine;

import javafx.event.EventHandler;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import mybank.model.card.Card;
import mybank.view.customer.CreditCardCustomerView;

/**
 *
 * @author camr
 */
public class CardMachineView extends AnchorPane {

  
    public CardMachineView() {
        Rectangle rect = new Rectangle();
        rect.setX(50);
        rect.setY(50);
        rect.setWidth(200);
        rect.setHeight(20);
        rect.setArcHeight(12);
        rect.setArcWidth(12);
        rect.setFill(Color.LIGHTGREY);

        Rectangle dark = new Rectangle();
        dark.setX(rect.getX() + 15);
        dark.setY(rect.getY() + 6);
        dark.setWidth(rect.getWidth() - 30);
        dark.setHeight(8);
        dark.setArcHeight(12);
        dark.setArcWidth(12);
        dark.setFill(Color.GRAY);

        super.getChildren().add(rect);
        super.getChildren().add(dark);

        dark.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {

                //her skal laves noget test på om det er et kreditkort
                if (event.getGestureSource() != this) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                    dark.setFill(Color.LIGHTBLUE);
                }

                event.consume();
            }
        });

        dark.setOnDragExited(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {

                //her skal laves noget test på om det er et kreditkort
                if (event.getGestureSource() != this) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                    dark.setFill(Color.GRAY);
                }

                event.consume();
            }
        });

        dark.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {

                //her skal laves noget test på om det er et kreditkort
                if (event.getGestureSource() != this) {
                    System.err.println("NYT KORT TIL MASKINEN.............");
                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if (db.getContent(CreditCardCustomerView.cardDataFormat) != null) {
                        Card c = (Card) db.getContent(CreditCardCustomerView.cardDataFormat);
                        success = true;
                          System.err.println(c.getCardNumber());
                  
                    }
                    /* let the source know whether the string was successfully 
         * transferred and used */
                    event.setDropCompleted(success);
                }

                event.consume();
            }
        });
    }
}
