package com.pluralsight;

import java.math.BigDecimal;

public class House extends Asset {

    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    // sets up the house and connects it to the basic asset information
    public House(String description, String dateAcquired, BigDecimal originalCost,
                 String address, int condition, int squareFoot, int lotSize) {

        super(description, dateAcquired, originalCost);

        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    // gets the house address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // gets the condition rating of the house
    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    // gets the total square footage of the house
    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    // gets the size of the lot
    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    // calculates the current value of the house based on its condition
    @Override
    public BigDecimal getValue() {

        BigDecimal pricePerSquareFoot;

        if (condition == 1) {
            pricePerSquareFoot = new BigDecimal("180.00");
        } else if (condition == 2) {
            pricePerSquareFoot = new BigDecimal("130.00");
        } else if (condition == 3) {
            pricePerSquareFoot = new BigDecimal("90.00");
        } else if (condition == 4) {
            pricePerSquareFoot = new BigDecimal("80.00");
        } else {
            throw new IllegalArgumentException("condition must be between 1 and 4");
        }

        // calculates the value of the house itself
        BigDecimal houseValue = pricePerSquareFoot.multiply(
                BigDecimal.valueOf(squareFoot)
        );

        // adds the extra value of the lot
        BigDecimal lotValue = new BigDecimal("0.25").multiply(
                BigDecimal.valueOf(lotSize)
        );

        return houseValue.add(lotValue);
    }
}
