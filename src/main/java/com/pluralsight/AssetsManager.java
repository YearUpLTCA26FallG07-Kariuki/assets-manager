package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AssetsManager {

    public static void main(String[] args) {

        // creates a list where we can keep all our assets together
        ArrayList<Asset> assets = new ArrayList<>();

        // adds two houses to our asset list
        assets.add(new House(
                "family home",
                "2020-05-15",
                new BigDecimal("350000.00"),
                "123 Oak Street, New Jersey",
                1,
                2000,
                5000
        ));

        assets.add(new House(
                "vacation home",
                "2022-08-10",
                new BigDecimal("250000.00"),
                "45 Beach Avenue, Florida",
                2,
                1500,
                4000
        ));

        // adds two vehicles to our asset list
        assets.add(new Vehicle(
                "personal vehicle",
                "2021-03-20",
                new BigDecimal("28000.00"),
                "Honda Civic",
                2020,
                115000
        ));

        assets.add(new Vehicle(
                "family vehicle",
                "2023-06-12",
                new BigDecimal("42000.00"),
                "Ford Explorer",
                2022,
                65000
        ));

        // goes through every asset and displays its information
        for (Asset asset : assets) {

            System.out.println("--------------------------------");
            System.out.println("description: " + asset.getDescription());
            System.out.println("date acquired: " + asset.getDateAcquired());
            System.out.println("original cost: $" + asset.getOriginalCost());
            System.out.println("current value: $" + asset.getValue());

            // checks whether this asset is a house
            if (asset instanceof House) {

                House house = (House) asset;

                System.out.println("house address: " + house.getAddress());

                // checks whether this asset is a vehicle
            } else if (asset instanceof Vehicle) {

                Vehicle vehicle = (Vehicle) asset;

                System.out.println("vehicle: " + vehicle.getYear()
                        + " " + vehicle.getMakeModel());
            }
        }

        System.out.println("--------------------------------");
        System.out.println("that's everything in your asset list!");
    }
}