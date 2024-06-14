package miro.task.helpers.rental;

import miro.task.models.vehicle.Vehicle;
import miro.task.models.vehicle.impl.Car;
import miro.task.models.vehicle.impl.CargoVan;
import miro.task.models.vehicle.impl.Motorcycle;

/**
 * Utility class to calculate rental costs for different types of vehicles.
 */
public class RentalCost {

    /**
     * Calculates the daily rental cost based on the type of vehicle and rental period.
     *
     * @param vehicle    The vehicle for which rental cost is calculated.
     * @param rentalDays Number of days the vehicle is rented for.
     * @return The daily rental cost.
     */
    public static double calculateDailyRentalCost(Vehicle vehicle, int rentalDays) {
        if (vehicle instanceof Car) {
            if (rentalDays > 7) {
                return 15.00; // Reduced rate for rentals longer than 7 days
            } else {
                return 20.00; // Standard rate for rentals of 7 days or less
            }
        } else if (vehicle instanceof Motorcycle) {
            if (rentalDays > 7) {
                return 10.00; // Reduced rate for rentals longer than 7 days
            } else {
                return 15.00; // Standard rate for rentals of 7 days or less
            }
        } else if (vehicle instanceof CargoVan) {
            if (rentalDays > 7) {
                return 40.00; // Reduced rate for rentals longer than 7 days
            } else {
                return 50.00; // Standard rate for rentals of 7 days or less
            }
        }
        return 0.00; // Default case: if vehicle type is unknown
    }

    /**
     * Calculates the total rental cost based on the daily rental cost and the actual number of days rented.
     *
     * @param rentalCostPerDay The daily rental cost of the vehicle.
     * @param actualDays       The actual number of days the vehicle was rented for.
     * @return The total rental cost.
     */
    public static double calculateTotalRentalCost(double rentalCostPerDay, int actualDays) {
        return rentalCostPerDay * actualDays;
    }
}
