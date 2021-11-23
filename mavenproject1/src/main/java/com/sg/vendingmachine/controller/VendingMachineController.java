package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dao.VendingMachineDaoImpl;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachine.service.VendingMachineOutofStockException;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author raymondtam
 */
public class VendingMachineController {

    private VendingMachineView view;
//    private VendingMachineDao dao = new VendingMachineDaoImpl();
    private VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

    private void getAllItems() throws VendingMachineDaoException {
        List<Item> itemList = service.getAllItem();
        view.getAllItem(itemList);

    }

//    private void AddItem() throws VendingMachineDaoException{
//        Item newItem = view.addViewItem();
//        String ID = newItem.getItemId();
//        dao.addItem(ID,newItem);
//        view.SuccessfulCreation();
//        
//        
//    }
    private void ViewSingleItem() throws VendingMachineDaoException {
        String itemId = view.getItemId();
        Item getItem = service.getItem(itemId);
        view.getSingleItem(getItem);

    }

    private void buyingItem() throws VendingMachineDaoException, VendingMachineInsufficientFundsException, VendingMachineOutofStockException {
        view.askingForMoney();
        MoneyAdded();
    }

    public void getCurrentBalance() throws VendingMachineDaoException {
        BigDecimal balance = service.getBalance();
        view.showCurrentBalance(balance);
    }

    public void buyingScreen() throws VendingMachineDaoException, VendingMachineInsufficientFundsException, VendingMachineOutofStockException {
        boolean hasErrors = false;
        do {

            try {
                String itemId = view.displayBuyingSelectionInput();
                int[] totalChange = service.buyItem(itemId);
                Item itemBought = service.getItem(itemId);
                view.displayBoughtItem(itemBought);
                view.displayChange(totalChange);
                break;
            } catch (VendingMachineInsufficientFundsException |VendingMachineDaoException| VendingMachineOutofStockException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
                        view.askingForMoney();
        MoneyAdded();
            }
        } while (hasErrors);
    }

    public void MoneyAdded() throws VendingMachineDaoException, VendingMachineInsufficientFundsException, VendingMachineOutofStockException {
        boolean adding = true;
        while (adding) {
            getCurrentBalance();
            int addingSelection = view.addCoinsOption();
            
            switch (addingSelection) {
                case 1:
                    service.addingPenny();
                    System.out.println("Penny Added");
                    break;
                case 2:
                    service.addingNickel();
                    System.out.println("Nickel Added");
                    break;
                case 3:
                    service.addingDime();
                    System.out.println("Dime Added");
                    break;
                case 4:
                    service.addingQuarter();
                    System.out.println("Quarter Added");
                    break;
                case 5:
                    service.addingDollar();
                    System.out.println("Dollar Added");
                    break;
                case 6:
                    service.addingFiver();
                    System.out.println("5 Dollar Added");
                    break;
                case 7:
                    System.out.println("Go to Selection");
                    buyingScreen();
                    adding = false;
                    break;
                case 8:
                    System.out.println("Exit");
                    adding = false;
                    break;

            }
        }
    }

    public void run() throws VendingMachineDaoException, VendingMachineInsufficientFundsException, VendingMachineOutofStockException {

        boolean running = true;
        getAllItems();
        while (running) {
            int menuSelection = view.printMenuAndGetSelection();
            try {
                switch (menuSelection) {
                    case 1:

                        getAllItems();

                        break;
                    case 2:
//                AddItem();
                        System.out.println("Will be added soon!");

                        break;
                    case 3:
                        ViewSingleItem();

                        break;
                    case 4:
                        buyingItem();
                        running = false;
                        break;
                    case 5:

                        System.out.println("5");

                        break;
                    case 6:
                        System.out.println("Exiting");
                        running = false;
                        break;

                }
            } catch (VendingMachineDaoException e) {
                view.displayErrorMessage(e.getMessage());
            }

        }
    }
}
