package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
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
public interface VendingMachineDao {
    Item addItem(String itemId, Item item) throws VendingMachineDaoException;
    
    List<Item> getAllItem() throws VendingMachineDaoException;
    
    Item getItem(String itemId) throws VendingMachineDaoException;
    
    Item updateItem(String itemId, Item item)throws VendingMachineDaoException;
    
    Item removeItem(String itemId)throws VendingMachineDaoException;
    
    BigDecimal getBalance() throws VendingMachineDaoException;
    
    void updateBalance(BigDecimal newBalance) throws VendingMachineDaoException;
    
    void setBalanceTest();
    BigDecimal getBalanceTest();
    
    
}
