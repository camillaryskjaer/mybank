/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank.view;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import mybank.controller.CustomerPresenter;
import mybank.datalayer.CustomerDAOImp;
import mybank.model.customer.Customer;
import mybank.model.machine.Machine;
import mybank.view.customer.CustomerView;
import mybank.view.machine.CardMachineFXMLController;
import mybank.view.machine.CardMachineView;

/**
 *
 * @author camr
 */
public class MyBankApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        /* Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
         */
        
        VBox vbox = new VBox();
        
        
        //Fy fy
        Machine m = new Machine();
        
        StackPane root = new StackPane();
        
        FXMLLoader listLoader = new FXMLLoader(getClass().getResource("machine/CardMachineFXML.fxml"));
          
        vbox.getChildren().add(listLoader.load());
        CardMachineFXMLController cardmachineController = listLoader.getController();
        cardmachineController.setModel(m);
        
        
        
         FXMLLoader pinpadLoader = new FXMLLoader(getClass().getResource("pinpad/PinpadFXML.fxml"));
          
        vbox.getChildren().add(pinpadLoader.load());
      
        //denne HBox bruges til at repræsentere "hver" linie
        //1. Linie sætter titlen på banken
        HBox customerBox = new HBox();
        customerBox.setSpacing(40);
     
        

        CustomerDAOImp cccc = new CustomerDAOImp();
        for (Customer cu : cccc.getCustomers()) {
            CustomerView cc = new CustomerView(cu);
            CustomerPresenter cp = new CustomerPresenter(cu, m, cc);
            customerBox.getChildren().add((cc));
        }

          vbox.getChildren().add(customerBox);
        root.getChildren().add(vbox);
        Scene scene = new Scene(root);
        
        
        primaryStage.setTitle("Hæveautomaten");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
