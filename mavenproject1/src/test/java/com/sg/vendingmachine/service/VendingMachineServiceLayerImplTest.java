/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raymondtam
 */
public class VendingMachineServiceLayerImplTest {
    
     private VendingMachineServiceLayer service;
     public VendingMachineDao dao;
     public  VendingMachineAuditDao auditDao;
    
     
     public enum Money {
        PENNY,
        NICKEL,
        DIME,
        QUARTER,
        DOLLAR,
        FIVEDOLLAR
        
        }
    
     
    public BigDecimal addingMoney(VendingMachineServiceLayerImpl.Money coin, BigDecimal currenMoney){
        
         BigDecimal bigPenny = new BigDecimal(.01);
         BigDecimal bigNickel = new BigDecimal(.05);   
         BigDecimal bigDime = new BigDecimal(.10);
         BigDecimal bigQuarter = new BigDecimal(.25);
         BigDecimal bigDollar = new BigDecimal(1.00);
         BigDecimal bigFiver = new BigDecimal(5.00);
         
         switch(coin){
             case PENNY:
                 return currenMoney.add(bigPenny);
             case NICKEL:
                 return currenMoney.add(bigNickel);
             case DIME:
                 return currenMoney.add(bigDime);
             case QUARTER:
                 return currenMoney.add(bigQuarter);
             case DOLLAR:
                 return currenMoney.add(bigDollar);
             case FIVEDOLLAR:
                 return currenMoney.add(bigFiver);
             default:
                  throw new UnsupportedOperationException();
              
         }
        
     }

    public VendingMachineServiceLayerImplTest() {
        this.dao = new VendingMachineDaoStubImpl();
        this.auditDao = new VendingMachineAuditDaoStubImpl();
         service = new VendingMachineServiceLayerImpl(dao, auditDao);

    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
     
        

      
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testBuyingItem() throws VendingMachineDaoException, VendingMachineInsufficientFundsException, VendingMachineOutofStockException {
        dao.setBalanceTest();
//        BigDecimal test = dao.getBalanceTest();
        Item testItem = dao.getItem("0022");
        int testQuantity = testItem.getCurrentQuantity();

        int[] testArr = {0,4,0,0,0,0};
        
        assertNotNull(service.buyItem("0022"));
        assertArrayEquals(service.buyItem("0022"), testArr);
        
        //calling buyItem twice will reduce this from 3 ---> 1
        assertEquals(testItem.getCurrentQuantity(),1);       
        
    }
    
    @Test
    
    public void testBuyingInsufficientErrors() throws VendingMachineDaoException, VendingMachineInsufficientFundsException, VendingMachineOutofStockException{
        dao.getBalance();
        Item testItem = dao.getItem("0022");
        try{
            service.buyItem("0022");
            fail("expected InsufficientFunds was not thrown.");
        }
        catch(VendingMachineDaoException|VendingMachineOutofStockException e){
             fail("Incorrect exception was thrown.");
        }
        catch(VendingMachineInsufficientFundsException e){
            return;
        }
        
    }
        @Test
        public void testBuyingNoStockErrors() throws VendingMachineDaoException, VendingMachineInsufficientFundsException, VendingMachineOutofStockException{
        dao.getBalance();
        Item testItem = dao.getItem("0022");
        testItem.setCurrentQuantity(0);
        try{
            service.buyItem("0022");
            fail("expected InsufficientFunds was not thrown.");
        }
        catch(VendingMachineDaoException|VendingMachineInsufficientFundsException e){
             fail("Incorrect exception was thrown.");
        }
        catch(VendingMachineOutofStockException e){
            return;
        }
        
    }
    
}
