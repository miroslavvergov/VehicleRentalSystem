package miro.task.models.customer;

import lombok.Getter;

/**
 * Represents a customer who rents vehicles.
 * Contains basic information about the customer such as name, age, and driving experience.
 */

//Retrieves the fields of the customer.
@Getter
public class Customer {

    private String name;            // The name of the customer

    private int age;                // The age of the customer

    private int drivingExperience;  // Number of years the customer has been driving

    /**
     * Constructor to initialize a Customer object with name, age, and driving experience.
     *
     * @param name              The name of the customer
     * @param age               The age of the customer
     * @param drivingExperience Number of years the customer has been driving
     */
    public Customer(String name, int age, int drivingExperience) {
        this.name = name;
        this.age = age;
        this.drivingExperience = drivingExperience;
    }


}
