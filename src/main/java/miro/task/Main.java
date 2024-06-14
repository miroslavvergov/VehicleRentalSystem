package miro.task;

import miro.task.factories.DataCollectorFactory;
import miro.task.helpers.invoice.Invoice;
import miro.task.helpers.invoice.InvoicePrinter;
import miro.task.models.customer.Customer;
import miro.task.models.rental.Rental;
import miro.task.models.rental.RentalInfo;
import miro.task.models.vehicle.Vehicle;
import miro.task.utils.collectors.DataCollector;

import java.util.Scanner;

/**
 * Main class to run the Vehicle Rental System application.
 * Provides a command-line interface (CLI) to interact with the system.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Run the default operations
        defaultRun(scanner);

        // Close the scanner to avoid resource leaks
        scanner.close();
    }

    /**
     * Default run method to collect data and process rental information.
     *
     * @param scanner The scanner for reading user input.
     */
    public static void defaultRun(Scanner scanner) {
        // Initialize the DataCollectorFactory with a scanner
        DataCollectorFactory dataCollectorFactory = new DataCollectorFactory(scanner);

        // Collect customer information
        DataCollector<Customer> userDataCollector = dataCollectorFactory.createDataCollector("customer");
        Customer customer = userDataCollector.collect();

        // Collect vehicle information based on customer input
        DataCollector<Vehicle> vehicleDataCollector = dataCollectorFactory.createDataCollector("vehicle");
        Vehicle vehicle = vehicleDataCollector.collect();

        // Collect rental information (dates and rental periods)
        DataCollector<RentalInfo> rentalInfoDataCollector = dataCollectorFactory.createDataCollector("rental");
        RentalInfo rentalInfo = rentalInfoDataCollector.collect();

        // Generate the invoice using the Rental class and provided information
        Invoice invoice = Rental.processRental(customer, vehicle, rentalInfo);

        // Print the generated invoice to the console using InvoicePrinter
        InvoicePrinter invoicePrinter = new InvoicePrinter(invoice);
        invoicePrinter.printInvoice();
    }
}
