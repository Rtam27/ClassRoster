/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
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
public class VendingMachineDaoImplTest {
        VendingMachineDao  testDao;
    public VendingMachineDaoImplTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        String testFile = "testitem.txt";
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        testDao = new VendingMachineDaoImpl(testFile);
    }
    
    @After
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
                retrievedItem.getItemId());
    
    assertEquals(firstItem.getItemName(),
                retrievedItem.getItemName());
    
    assertEquals(firstItem.getCurrentQuantity(),
                retrievedItem.getCurrentQuantity());
    
    assertEquals(firstItem.getMaxQuantity(),
                retrievedItem.getMaxQuantity());

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
    
    
    System.out.println(allItem);

    assertNotNull(allItem);
    assertEquals(2, allItem.size());
   
    
  


    // Then the specifics
    assertTrue(allItem.contains(firstItem)
               );
    assertTrue(allItem.contains(secondItem)
            );


    
}
    
@Test
  public void testupdateItems() throws Exception {
  Item firstItem= new Item("0011");
    firstItem.setItemName("Snickers");
    firstItem.setItemCost(3.52);
    firstItem.setCurrentQuantity(3);
    firstItem.setMaxQuantity(4);
    
    testDao.addItem(firstItem.getItemId(), firstItem);
    
    Item secondItem= new Item("0011");
    secondItem.setItemName("Food");
    firstItem.setItemCost(4.00);
    firstItem.setCurrentQuantity(10);
    firstItem.setMaxQuantity(20);
    
    testDao.updateItem("0011",secondItem);
    Item retrievedItem = testDao.getItem("0011");
    
    assertEquals(secondItem.getItemId(),
                retrievedItem.getItemId());
    
    assertEquals(secondItem.getItemName(),
                retrievedItem.getItemName());
    
    assertEquals(secondItem.getCurrentQuantity(),
                retrievedItem.getCurrentQuantity());
    
    assertEquals(secondItem.getMaxQuantity(),
                retrievedItem.getMaxQuantity());
  }
  

}
