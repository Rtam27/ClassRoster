/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author raymondtam
 */
public class VendingMachineDaoImplTest {
    VendingMachineDao  testDao;

    public VendingMachineDaoImplTest() {
    }
    

    
    @BeforeEach
    public void setUp() throws IOException {
        String testFile = "testitem.txt";
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        testDao = new VendingMachineDaoImpl(testFile);
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void testAddGetItem() throws VendingMachineDaoException {
     
    String itemId = "0003";
    Item firstItem= new Item(itemId);
    firstItem.setItemName("Test");
    firstItem.setItemCost(3.52);
    firstItem.setCurrentQuantity(3);
    firstItem.setMaxQuantity(4);
    testDao.addItem("0003", firstItem);
    Item retrievedItem = testDao.getItem(itemId);
    
    
        assertEquals(firstItem.getItemId(),
                retrievedItem.getItemId(),
                "Checking item id.");
    assertEquals(firstItem.getItemName(),
                retrievedItem.getItemName(),
                "Checking item name.");
    assertEquals(firstItem.getItemCost(), 
                retrievedItem.getItemCost(),
                "Checking item cost.");
    assertEquals(firstItem.getCurrentQuantity(), 
                retrievedItem.getCurrentQuantity(),
                "Checking item quantity.");
      assertEquals(firstItem.getMaxQuantity(), 
                retrievedItem.getMaxQuantity(),
                "Checking item max quantity.");
    }
    

    @Test
    public void testAddGetAllItems() throws Exception {

    Item firstItem= new Item("0001");
    firstItem.setItemName("Mars");
    firstItem.setItemCost(3.52);
    firstItem.setCurrentQuantity(3);
    firstItem.setMaxQuantity(4);


    Item secondItem = new Item("0002");
    secondItem.setItemName("Rare");
    secondItem.setItemCost(99.99);
    secondItem.setCurrentQuantity(20);
    secondItem.setMaxQuantity(40);


    testDao.addItem(firstItem.getItemId(), firstItem);
    testDao.addItem(secondItem.getItemId(), secondItem);

    List<Item> allItem = testDao.getAllItem();

    assertNotNull(allItem, "The list of students must not null");
    assertEquals(2, allItem.size(),"List of items should have 2 item.");
   
   


    // Then the specifics
    assertTrue(allItem.contains(firstItem),
                "The list of item should include Mars.");
    assertTrue(allItem.contains(secondItem),
            "The list of items should include Rare.");

}


    
}
