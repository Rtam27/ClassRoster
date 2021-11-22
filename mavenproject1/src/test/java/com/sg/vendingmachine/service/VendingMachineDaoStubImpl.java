/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raymondtam
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao{
    public Item onlyItem;
    
    public VendingMachineDaoStubImpl() {
        onlyItem = new Item("0001");
        onlyItem.setItemName("Mars");
        onlyItem.setItemCost(3.20);
        onlyItem.setCurrentQuantity(3);
         onlyItem.setMaxQuantity(30);
    }
    
    
    public VendingMachineDaoStubImpl(Item testItem){
         this.onlyItem = testItem;
     }

    @Override
    public Item addItem(String itemId, Item item) throws VendingMachineDaoException {
            if (itemId.equals(onlyItem.getItemId())) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public List<Item> getAllItem() throws VendingMachineDaoException {
         List<Item> itemList = new ArrayList<>();
        itemList.add(onlyItem);
        return itemList;
    }

    @Override
    public Item getItem(String itemId) throws VendingMachineDaoException {
        if (itemId.equals(onlyItem.getItemId())) {
            return onlyItem;
        } else {
            return null;
    }
    }
    
    @Override
    public Item updateItem(String itemId, Item item) throws VendingMachineDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item removeItem(String itemId) throws VendingMachineDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BigDecimal getBalance() throws VendingMachineDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateBalance(BigDecimal newBalance) throws VendingMachineDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    

}
