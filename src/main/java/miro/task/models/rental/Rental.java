package miro.task.rental;

import miro.task.helpers.invoice.Invoice;
import miro.task.model.customer.Customer;
import miro.task.model.vehicle.Vehicle;
import miro.task.model.vehicle.impl.Car;
import miro.task.model.vehicle.impl.CargoVan;
import miro.task.model.vehicle.impl.Motorcycle;
import miro.task.utils.processors.DateProcessor;

import java.util.Date;


public class Rental {


    public static Invoice processRental(Customer customer, Vehicle vehicle, int reservedDays, int actualDays) {
        Date rentalDate = DateProcessor.getCurrentDate();
        boolean returnedEarlier = false;

        double rentalCostPerDay = calculateDailyRentalCost(vehicle, reservedDays);
        double insuranceCostPerDay = calculateDailyInsuranceCost(vehicle, customer);

        double totalRentalCost = rentalCostPerDay * actualDays;
        double totalInsuranceCost = insuranceCostPerDay * actualDays;

        double earlyReturnDiscountRental = 0;
        double earlyReturnDiscountInsurance = 0;

        if (actualDays < reservedDays) {
            returnedEarlier = true;
            int remainingDays = reservedDays - actualDays;
            totalRentalCost = (rentalCostPerDay * actualDays) + (remainingDays * (rentalCostPerDay * 0.5));
            totalInsuranceCost = insuranceCostPerDay * actualDays;

            earlyReturnDiscountRental = rentalCostPerDay * remainingDays * 0.5;
            earlyReturnDiscountInsurance = insuranceCostPerDay * remainingDays;
        }

        return new Invoice(customer.getName(), vehicle, rentalDate, DateProcessor.addDaysToDate(rentalDate, reservedDays), reservedDays, DateProcessor.addDaysToDate(rentalDate, actualDays), actualDays, rentalCostPerDay, insuranceCostPerDay, totalRentalCost, totalInsuranceCost, earlyReturnDiscountRental, earlyReturnDiscountInsurance, returnedEarlier);
    }

    private static double calculateDailyRentalCost(Vehicle vehicle, int rentalDays) {
        if (vehicle instanceof Car) {
            if (rentalDays > 7) {
                return 15.00;
            } else {
                return 20.00;
            }
        } else if (vehicle instanceof Motorcycle) {
            if (rentalDays > 7) {
                return 10.00;
            } else {
                return 15.00;
            }
        } else if (vehicle instanceof CargoVan) {
            if (rentalDays > 7) {
                return 40.00;
            } else {
                return 50.00;
            }
        }
        return 0.00; // Default case
    }

    private static double calculateDailyInsuranceCost(Vehicle vehicle, Customer customer) {
        double insuranceRate;
        if (vehicle instanceof Car) {
            insuranceRate = 0.0001;
            Car car = (Car) vehicle;
            if (car.getSafetyRating() >= 4) {
                insuranceRate *= 0.9;
            }
        } else if (vehicle instanceof Motorcycle) {
            insuranceRate = 0.0002;
            if (customer.getAge() < 25) {
                insuranceRate *= 1.2;
            }
        } else if (vehicle instanceof CargoVan) {
            insuranceRate = 0.0003;
            if (customer.getDrivingExperience() > 5) {
                insuranceRate *= 0.85;
            }
        } else {
            return 0.00; // Default case
        }
        return insuranceRate * vehicle.getValue();
    }
}
