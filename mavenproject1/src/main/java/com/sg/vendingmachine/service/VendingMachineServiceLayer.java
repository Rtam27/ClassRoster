/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author raymondtam
 */
public interface VendingMachineServiceLayer {
public List<Item> getAllItem() throws VendingMachineDaoException;

public Item getItem(String itemId) throws VendingMachineDaoException;
public int[] buyItem(String itemId) throws VendingMachineDaoException, VendingMachineInsufficientFundsException, VendingMachineOutofStockException;
public BigDecimal getBalance() throws VendingMachineDaoException;
public BigDecimal addingPenny() throws VendingMachineDaoException;
public BigDecimal addingNickel() throws VendingMachineDaoException;
public BigDecimal addingDime() throws VendingMachineDaoException;
public BigDecimal addingQuarter() throws VendingMachineDaoException;
public BigDecimal addingDollar() throws VendingMachineDaoException;
public BigDecimal addingFiver() throws VendingMachineDaoException;
public int[] returnChange(BigDecimal change) throws VendingMachineDaoException;    
}
