package miro.task.helpers.insurance;

import miro.task.models.customer.Customer;
import miro.task.models.vehicle.Vehicle;
import miro.task.models.vehicle.impl.Car;
import miro.task.models.vehicle.impl.CargoVan;
import miro.task.models.vehicle.impl.Motorcycle;

/**
 * Helper class to calculate insurance costs for different types of vehicles.
 */
public class Insurance {

    /**
     * Calculates the daily insurance cost based on the type of vehicle and customer information.
     *
     * @param vehicle  The vehicle for which insurance cost is calculated.
     * @param customer The customer associated with the rental.
     * @return The daily insurance cost.
     */
    public static double calculateDailyInsuranceCost(Vehicle vehicle, Customer customer) {
        double insuranceRate;

        if (vehicle instanceof Car) {
            insuranceRate = 0.0001; // Base insurance rate for cars
            Car car = (Car) vehicle;
            if (car.getSafetyRating() >= 4) {
                insuranceRate *= 0.9; // Apply 10% discount for cars with high safety rating
            }
        } else if (vehicle instanceof Motorcycle) {
            insuranceRate = 0.0002; // Base insurance rate for motorcycles
            if (customer.getAge() < 25) {
                insuranceRate *= 1.2; // Apply 20% surcharge for riders under 25 years old
            }
        } else if (vehicle instanceof CargoVan) {
            insuranceRate = 0.0003; // Base insurance rate for cargo vans
            if (customer.getDrivingExperience() > 5) {
                insuranceRate *= 0.85; // Apply 15% discount for drivers with more than 5 years of experience
            }
        } else {
            return 0.00; // Default case: if vehicle type is unknown
        }

        // Calculate total insurance cost based on the vehicle's value and the insurance rate
        return insuranceRate * vehicle.getValue();
    }

    /**
     * Calculates the total insurance cost based on the daily insurance cost and the actual number of days rented.
     *
     * @param insuranceCostPerDay The daily insurance cost of the vehicle.
     * @param actualDays           The actual number of days the vehicle was rented for.
     * @return The total insurance cost.
     */
    public static double calculateTotalInsuranceCost(double insuranceCostPerDay, int actualDays) {
        return insuranceCostPerDay * actualDays;
    }
}
