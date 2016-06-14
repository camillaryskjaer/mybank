/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank.view.customer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;
import javafx.stage.Popup;
import mybank.model.card.Card;

/**
 *
 * @author camr
 */
public class CreditCardCustomerView extends VBox {

    private Card model;
    final Popup popup = new Popup();
    //Det er det format der skal bruges for at added to clipboard
    public static final DataFormat cardDataFormat = new DataFormat("mybank.model.card.Card");

    public CreditCardCustomerView(Card model) {
        this.model = model;
     
        Image image = new Image(getClass().getResourceAsStream(model.getCardType()+".png"));
       
        Pane card = new Pane();
        card.getChildren().add(new ImageView(image));

        card.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Dragboard db = card.startDragAndDrop(TransferMode.COPY_OR_MOVE);

                final ClipboardContent cc = new ClipboardContent();
                cc.put(cardDataFormat, model);
                db.setContent(cc);

                WritableImage wi = new WritableImage(250, 162);
                
                SnapshotParameters parameters = new SnapshotParameters();

                parameters.setFill(Color.TRANSPARENT);
                popup.getContent().get(0).snapshot(parameters, wi);
                popup.hide();
                db.setDragView(wi, event.getX(), event.getY());
       
                event.consume();
            }
        });

        card.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                //Her skal et større kort vises
                LargeCreditCardView v = new LargeCreditCardView(model.getCardNumber(),model.getOwner(), model.getCardType());
                popup.getContent().addAll(v);
                popup.show(getParent(), me.getScreenX() + 10, me.getScreenY() + 10);
            }
        });

        card.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                //Her skal et større kort vises
                System.out.println("Mouse entered");
                popup.hide();
            }
        });
        getChildren().add(card);
    }

    /**
     * @return the model
     */
    public Card getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(Card model) {
        this.model = model;
    }
}
