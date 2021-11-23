/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.vendingmachineNew;

import com.sg.vendingmachine.controller.VendingMachineController;
import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineAuditDaoImpl;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dao.VendingMachineDaoImpl;
import com.sg.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachine.service.VendingMachineOutofStockException;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.service.VendingMachineServiceLayerImpl;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author raymondtam
 */
public class App {

//    public static void main(String[] args) throws VendingMachineDaoException, VendingMachineInsufficientFundsException, VendingMachineOutofStockException {
//        UserIO io = new UserIOConsoleImpl();
//        VendingMachineView view = new VendingMachineView(io);
//        VendingMachineDao dao = new VendingMachineDaoImpl();
//        VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoImpl();
//         VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(dao, myAuditDao);
//        VendingMachineController controller = new VendingMachineController(myService, view);
//        controller.run();
//    }
    
       public static void main(String[] args) throws VendingMachineDaoException,  VendingMachineInsufficientFundsException, VendingMachineOutofStockException {

        ApplicationContext appContext
                = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

         VendingMachineController controller = appContext.getBean("controller", VendingMachineController.class);
        controller.run();
    }

}
