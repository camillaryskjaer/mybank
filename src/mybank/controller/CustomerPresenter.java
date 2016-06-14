/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import mybank.model.customer.Customer;
import mybank.model.machine.Command;
import mybank.model.machine.InsertCardCommand;
import mybank.model.machine.Machine;
import mybank.model.machine.UserActionMachine;
import mybank.view.customer.CreditCardCustomerView;
import mybank.view.customer.CustomerView;

/**
 *
 * @author camr
 */
public class CustomerPresenter {

    private final Customer model;
    private final CustomerView view;
    private final UserActionMachine actions;

    public CustomerPresenter(Customer model, UserActionMachine actions, CustomerView view) {
        this.view = view;
        this.model = model;
        this.actions = actions;
        attachEvents();
    }

    //håndtering af events sker herind
    private void attachEvents() {
        //loop igennem alle kreditkortene f
        for (Node n : view.getCreditCardCustomerViews()) {
            if (n instanceof CreditCardCustomerView) {
                CreditCardCustomerView cc = (CreditCardCustomerView)n;
                n.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    public void handle(MouseEvent me) {
                    //    Command c = new InsertCardCommand(actions, cc.getModel());
                     //   c.execute();
                    }
                });
            }
        }

    }

    private void doStuff() {
        System.err.println("Men hvem?");
    }

}
