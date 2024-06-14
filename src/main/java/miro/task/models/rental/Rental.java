package miro.task.models.rental;

import miro.task.helpers.insurance.Insurance;
import miro.task.helpers.invoice.Invoice;
import miro.task.helpers.rental.RentalCost;
import miro.task.models.customer.Customer;
import miro.task.models.vehicle.Vehicle;
import miro.task.models.vehicle.impl.Car;
import miro.task.models.vehicle.impl.CargoVan;
import miro.task.models.vehicle.impl.Motorcycle;
import miro.task.utils.processors.DateProcessor;

import java.util.Date;

/**
 * Class responsible for processing rental transactions and generating invoices.
 */
public class Rental {

    /**
     * Processes the rental transaction and generates an invoice based on customer, vehicle, and rental information.
     *
     * @param customer   The customer renting the vehicle.
     * @param vehicle    The vehicle being rented.
     * @param rentalInfo Information about the rental period and dates.
     * @return An Invoice object containing the details of the rental transaction.
     */
    public static Invoice processRental(Customer customer, Vehicle vehicle, RentalInfo rentalInfo) {
        // Get the current date to mark the start of the rental period.
        Date rentalDate = DateProcessor.getCurrentDate();

        // Determine the type of the vehicle being rented.
        Class vehicleType = vehicle.getClass();

        // Flag to check if the vehicle is not a car.
        boolean isNotCar = vehicleType != Car.class;

        // Flag to indicate if the vehicle was returned earlier than expected.
        boolean returnedEarlier = false;

        // Get the number of reserved and actual rental days.
        int reservedDays = rentalInfo.reservedRentalDays();
        int actualDays = rentalInfo.actualRentalDays();

        // Calculate the daily rental and insurance costs based on the vehicle type and rental period.
        double rentalCostPerDay = RentalCost.calculateDailyRentalCost(vehicle, reservedDays);
        double insuranceCostPerDay = Insurance.calculateDailyInsuranceCost(vehicle, customer);

        // Calculate the total rental and insurance costs based on the actual rental days.
        double totalRentalCost = RentalCost.calculateTotalRentalCost(rentalCostPerDay, actualDays);
        double totalInsuranceCost = Insurance.calculateTotalInsuranceCost(insuranceCostPerDay, actualDays);

        // Variables to store the early return discounts for rental and insurance costs.
        double earlyReturnDiscountRental = 0;
        double earlyReturnDiscountInsurance = 0;

        // If the vehicle is returned earlier than the reserved period, calculate the discounts and adjust costs.
        if (actualDays < reservedDays) {
            returnedEarlier = true;
            int remainingDays = reservedDays - actualDays;

            // Adjust the total rental cost by charging half the price for the remaining days.
            totalRentalCost = (rentalCostPerDay * actualDays) + (remainingDays * (rentalCostPerDay * 0.5));
            // Total insurance cost only for the actual rental days.
            totalInsuranceCost = insuranceCostPerDay * actualDays;

            // Calculate the early return discounts for rental and insurance costs.
            earlyReturnDiscountRental = rentalCostPerDay * remainingDays * 0.5;
            earlyReturnDiscountInsurance = insuranceCostPerDay * remainingDays;
        }

        // Return a new Invoice object with all the calculated details.
        return new Invoice(
                customer.getName(),
                vehicle,
                rentalDate,
                DateProcessor.addDaysToDate(rentalDate, reservedDays),
                reservedDays,
                DateProcessor.addDaysToDate(rentalDate, actualDays),
                actualDays,
                rentalCostPerDay,
                insuranceCostPerDay,
                totalRentalCost,
                totalInsuranceCost,
                earlyReturnDiscountRental,
                earlyReturnDiscountInsurance,
                returnedEarlier,
                vehicleType
        );
    }
}
