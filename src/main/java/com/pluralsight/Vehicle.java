package com.pluralsight;

import java.math.BigDecimal;
import java.time.Year;

public class Vehicle extends Asset {

    private String makeModel;
    private int year;
    private int odometer;

    // sets up the vehicle and connects it to the basic asset information
    public Vehicle(String description, String dateAcquired, BigDecimal originalCost,
                   String makeModel, int year, int odometer) {

        super(description, dateAcquired, originalCost);

        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    // gets the vehicle make and model
    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    // gets the vehicle year
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // gets the current mileage
    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    // this calculates the current value of the vehicle after depreciation
    @Override
    public BigDecimal getValue() {

        int vehicleAge = Year.now().getValue() - year;

        BigDecimal value = getOriginalCost();

        // reduces the value based on how old the vehicle is
        if (vehicleAge >= 0 && vehicleAge <= 3) {
            value = value.multiply(
                    BigDecimal.ONE.subtract(new BigDecimal("0.03")
                            .multiply(BigDecimal.valueOf(vehicleAge)))
            );

        } else if (vehicleAge >= 4 && vehicleAge <= 6) {
            value = value.multiply(
                    BigDecimal.ONE.subtract(new BigDecimal("0.06")
                            .multiply(BigDecimal.valueOf(vehicleAge)))
            );

        } else if (vehicleAge >= 7 && vehicleAge <= 10) {
            value = value.multiply(
                    BigDecimal.ONE.subtract(new BigDecimal("0.08")
                            .multiply(BigDecimal.valueOf(vehicleAge)))
            );

        } else if (vehicleAge > 10) {
            value = value.subtract(new BigDecimal("1000.00"));
        }

        // checks whether the vehicle has high mileage
        String vehicleMake = makeModel.toLowerCase();

        if (odometer > 100000
                && !vehicleMake.contains("honda")
                && !vehicleMake.contains("toyota")) {

            value = value.multiply(new BigDecimal("0.75"));
        }

        // prevents the vehicle value from becoming negative
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            value = BigDecimal.ZERO;
        }

        return value;
    }
}