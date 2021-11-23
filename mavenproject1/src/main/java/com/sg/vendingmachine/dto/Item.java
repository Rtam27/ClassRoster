/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.vendingmachine.dto;

import java.util.Objects;



/**
 *
 * @author raymondtam
 */
public class Item {
    private String itemId;
    private String itemName;
    private double itemCost;
    private int currentQuantity;
    private int maxQuantity;

    public Item(String itemId) {
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }
    

    public String getItemName() {
        return itemName;
    }

    public double getItemCost() {
        return itemCost;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }


    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.itemId);
        hash = 73 * hash + Objects.hashCode(this.itemName);
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.itemCost) ^ (Double.doubleToLongBits(this.itemCost) >>> 32));
        hash = 73 * hash + this.currentQuantity;
        hash = 73 * hash + this.maxQuantity;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (Double.doubleToLongBits(this.itemCost) != Double.doubleToLongBits(other.itemCost)) {
            return false;
        }
        if (this.currentQuantity != other.currentQuantity) {
            return false;
        }
        if (this.maxQuantity != other.maxQuantity) {
            return false;
        }
        if (!Objects.equals(this.itemId, other.itemId)) {
            return false;
        }
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        return true;
    }
    
    
    
        
    
}
