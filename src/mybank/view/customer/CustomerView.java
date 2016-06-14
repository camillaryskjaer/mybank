/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank.view.customer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import mybank.account.Account;
import mybank.model.card.Card;
import mybank.model.customer.Customer;

/**
 *
 * @author camr
 */
public class CustomerView extends HBox {

    private final Customer model;
    private static List<Image> imgGirls = null;
    private static List<Image> imgBoys = null;
    private final VBox creditcards = new VBox();

    public CustomerView(Customer model) {
        this.setSpacing(10);
        this.model = model;
        Image image = findRandomImage(model);
        Label name = new Label(model.getFullName(), new ImageView(image));
        name.setContentDisplay(ContentDisplay.TOP);
        getChildren().add((name));

        for (Account a : model.getAccounts()) {
            creditcards.getChildren().add((new CreditCardCustomerView(a.getCard())));
           
        }
        //liste af creditkort her
        getChildren().add((creditcards));

    }

    public ObservableList<Node> getCreditCardCustomerViews() {
        return creditcards.getChildren();
    }

    /**
     * Denne metode skal finde et tilfældigt billede afhængig om det er en dreng
     * eller pige. Bemærk der indlæses kun i listen een gang, da de er statiske
     */
    private Image findRandomImage(Customer c) {

        if (c.getGender().equals(Customer.Sex.Female)) {
            //find ud af om der allerede ligger nogle billeder i listen
            if (imgGirls == null) {
                imgGirls = new ArrayList<>();
                File directory = new File(getClass().getResource("girls").getFile());
                for (File file : directory.listFiles()) {
                    // could also use a FileNameFilter
                    if (file.getName().toLowerCase().endsWith(".png")) {
                        imgGirls.add(new Image(getClass().getResourceAsStream("girls/" + file.getName())));

                    }
                }
            }
            //Find et random billede
            return imgGirls.get(new Random().nextInt(imgGirls.size()));

        } else //find ud af om der allerede ligger nogle billeder i listen
         if (imgBoys == null) {
                imgBoys = new ArrayList<>();
                File directory = new File(getClass().getResource("boys").getFile());
                for (File file : directory.listFiles()) {
                    // could also use a FileNameFilter
                    if (file.getName().toLowerCase().endsWith(".png")) {
                        imgBoys.add(new Image(getClass().getResourceAsStream("boys/" + file.getName())));

                    }
                }
            }
        return imgBoys.get(new Random().nextInt(imgBoys.size()));

    }

}
