package miro.task.utils.collectors.impl;

import miro.task.models.customer.Customer;
import miro.task.utils.collectors.DataCollector;

import java.util.Scanner;

/**
 * Class responsible for collecting user data from the console.
 * Implements the DataCollector interface for the Customer type.
 */
public class CustomerDataCollector implements DataCollector<Customer> {

    // Scanner object for reading input from the console
    private final Scanner scanner;

    /**
     * Constructor for initializing the scanner object.
     *
     * @param scanner Scanner object for console input.
     */
    public CustomerDataCollector(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Collects customer details from the console.
     *
     * @return A Customer object containing the collected data.
     */
    @Override
    public Customer collect() {
        System.out.println("Please enter customer details:");

        // Collect customer name
        System.out.print("Name: ");
        String name = scanner.nextLine();

        // Collect customer age with validation
        int age = collectAge();

        // Collect customer driving experience with validation
        int experience = collectExperience();

        // Return a new Customer object with the collected details
        return new Customer(name, age, experience);
    }

    /**
     * Continuously prompts the user to input a valid age until a valid number is entered.
     *
     * @return The valid age entered by the user.
     */
    private int collectAge() {
        while (true) {
            try {
                System.out.print("Age: ");
                String ageStr = scanner.nextLine();
                int age = Integer.parseInt(ageStr);

                // Check if age is positive
                if (age <= 0) {
                    System.out.println("Age must be a positive number.");
                    continue; // If age is not positive, continue prompting
                }

                // Return the valid age
                return age;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for age. Please enter a number.");
                // Catch block handles non-numeric input and prompts again
            }
        }
    }

    /**
     * Continuously prompts the user to input valid driving experience in years until a valid number is entered.
     *
     * @return The valid driving experience in years entered by the user.
     */
    private int collectExperience() {
        while (true) {
            try {
                System.out.print("Driving Experience (in years): ");
                String experienceStr = scanner.nextLine();
                int experience = Integer.parseInt(experienceStr);

                // Check if experience is non-negative
                if (experience < 0) {
                    System.out.println("Driving experience cannot be negative.");
                    continue; // If experience is negative, continue prompting
                }

                // Return the valid driving experience
                return experience;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for driving experience. Please enter a number.");
                // Catch block handles non-numeric input and prompts again
            }
        }
    }
}
