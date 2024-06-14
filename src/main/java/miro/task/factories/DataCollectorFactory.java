package miro.task.factories;

import miro.task.utils.collectors.DataCollector;
import miro.task.utils.collectors.impl.CustomerDataCollector;
import miro.task.utils.collectors.impl.RentalInfoDataCollector;
import miro.task.utils.collectors.impl.VehicleDataCollector;

import java.util.Scanner;

/**
 * Factory class to create instances of data collectors.
 */
public class DataCollectorFactory {

    private final Scanner scanner;

    public DataCollectorFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Creates and returns a DataCollector instance for the specified type.
     *
     * @param dataType a string specifying the type of data collector needed
     * @param <T>      the type of data collector to create
     * @return a DataCollector instance for the specified type
     * @throws IllegalArgumentException if an invalid data type is provided
     */
    public <T extends DataCollector<?>> T createDataCollector(String dataType) {
        switch (dataType.toLowerCase()) {
            case "customer":
                return (T) new CustomerDataCollector(scanner);
            case "vehicle":
                return (T) new VehicleDataCollector(scanner);
            case "rental":
                return (T) new RentalInfoDataCollector(scanner);
            default:
                throw new IllegalArgumentException("Invalid data type: " + dataType);
        }
    }
}
