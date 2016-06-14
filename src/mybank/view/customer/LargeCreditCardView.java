/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank.view.customer;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import mybank.model.card.Card;

/**
 *
 * @author camr
 */
public class LargeCreditCardView extends AnchorPane {

    public LargeCreditCardView(String cardnumber, String owner, Card.CardType type) {
        //her skal vi vide hvilken korttype der er tale om
        

        Image image = new Image(getClass().getResourceAsStream(type+ "large.png"));
        Label creditCardnumberLabel = new Label(cardnumber.replaceAll("(.{4})(?!$)", "$1 "));
        ImageView ii = new ImageView(image);
        creditCardnumberLabel.setFont(new Font("KreditFront-Regular", 22));
        creditCardnumberLabel.setTranslateY(90);
        creditCardnumberLabel.setTranslateX(20);
            
        super.getChildren().add(ii);
        super.getChildren().add(creditCardnumberLabel);
        Label ownerLabel = new Label(owner);
        ownerLabel.setFont(new Font("KreditFront-Regular", 15));
        ownerLabel.setTranslateY(120);
        ownerLabel.setTranslateX(20);
        super.getChildren().add(ownerLabel);

        
        
      
    }
}
