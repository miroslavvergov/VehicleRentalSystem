package miro.task.invoice;

import lombok.Getter;
import miro.task.model.vehicle.Vehicle;
import miro.task.model.vehicle.impl.Car;
import miro.task.model.vehicle.impl.CargoVan;
import miro.task.model.vehicle.impl.Motorcycle;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class Invoice {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#0.00");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private static final double INITIAL_INSURANCE_RATE_CARGO_VAN = 0.0003;
    private static final double INITIAL_INSURANCE_RATE_MOTORCYCLE = 0.0002;
    private static final double INITIAL_INSURANCE_RATE_CAR = 0.0001;

    private String customerName;
    private Vehicle rentedVehicle;
    private Date reservationStartDate;
    private Date reservationEndDate;
    private int reservedRentalDays;
    private Date actualReturnDate;
    private int actualRentalDays;
    private double rentalCostPerDay;
    private double insuranceCostPerDay;
    private double totalRentalCost;
    private double totalInsuranceCost;
    private double earlyReturnDiscountRental;
    private double earlyReturnDiscountInsurance;
    private double totalCost;
    private boolean returnedEarlier;

    public Invoice(String customerName, Vehicle rentedVehicle, Date reservationStartDate, Date reservationEndDate, int reservedRentalDays,
                   Date actualReturnDate, int actualRentalDays, double rentalCostPerDay, double insuranceCostPerDay,
                   double totalRentalCost, double totalInsuranceCost, double earlyReturnDiscountRental, double earlyReturnDiscountInsurance, boolean returnedEarlier) {
        this.customerName = customerName;
        this.rentedVehicle = rentedVehicle;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.reservedRentalDays = reservedRentalDays;
        this.actualReturnDate = actualReturnDate;
        this.actualRentalDays = actualRentalDays;
        this.rentalCostPerDay = rentalCostPerDay;
        this.insuranceCostPerDay = insuranceCostPerDay;
        this.totalRentalCost = totalRentalCost;
        this.totalInsuranceCost = totalInsuranceCost;
        this.earlyReturnDiscountRental = earlyReturnDiscountRental;
        this.earlyReturnDiscountInsurance = earlyReturnDiscountInsurance;
        this.totalCost = totalRentalCost + totalInsuranceCost;
        this.returnedEarlier = returnedEarlier;
    }

    /**
     * Prints the invoice details to the console.
     */
    public void printInvoice() {
        System.out.println("XXXXXXXXXX");
        System.out.println("Date: " + DATE_FORMAT.format(new Date()));
        System.out.println("Customer Name: " + customerName);
        System.out.println("Rented Vehicle: " + rentedVehicle.getBrand() + " " + rentedVehicle.getModel());
        System.out.println();
        //
        System.out.println("Reservation start date: " + DATE_FORMAT.format(reservationStartDate));
        System.out.println("Reservation end date: " + DATE_FORMAT.format(reservationEndDate));
        System.out.println("Reserved rental days: " + reservedRentalDays + " days");
        System.out.println();
        //
        System.out.println("Actual return date: " + DATE_FORMAT.format(actualReturnDate));
        System.out.println("Actual rental days: " + actualRentalDays + " days");
        System.out.println();
        //
        System.out.println("Rental cost per day: $" + DECIMAL_FORMAT.format(rentalCostPerDay));
        if (returnedEarlier) {

            double initialInsurancePerDay = getInitialInsurancePerDay();

            System.out.println("Initial insurance per day: $" + DECIMAL_FORMAT.format(initialInsurancePerDay));
            double insuranceDiscountPerDay = initialInsurancePerDay - insuranceCostPerDay;
            System.out.println("Insurance discount per day: $" + DECIMAL_FORMAT.format(insuranceDiscountPerDay));
        }
        System.out.println("Insurance per day: $" + DECIMAL_FORMAT.format(insuranceCostPerDay));
        System.out.println();
        //
        if (returnedEarlier) {
            System.out.println("Early return discount for rent: $" + DECIMAL_FORMAT.format(earlyReturnDiscountRental));
            System.out.println("Early return discount for insurance: $" + DECIMAL_FORMAT.format(earlyReturnDiscountInsurance));
        }
        System.out.println();
        //
        System.out.println("Total rent: $" + DECIMAL_FORMAT.format(totalRentalCost));
        System.out.println("Total insurance: $" + DECIMAL_FORMAT.format(totalInsuranceCost));
        System.out.println("Total: $" + DECIMAL_FORMAT.format(totalCost));
        System.out.println("XXXXXXXXXX");
    }

    private double getInitialInsurancePerDay() {
        double initialInsurancePerDay = 0.0;
        if (rentedVehicle instanceof CargoVan) {
            initialInsurancePerDay = rentedVehicle.getValue() * INITIAL_INSURANCE_RATE_CARGO_VAN;
        } else if (rentedVehicle instanceof Motorcycle) {
            initialInsurancePerDay = rentedVehicle.getValue() * INITIAL_INSURANCE_RATE_MOTORCYCLE;
        } else if (rentedVehicle instanceof Car) {
            initialInsurancePerDay = rentedVehicle.getValue() * INITIAL_INSURANCE_RATE_CAR;
        }
        return initialInsurancePerDay;
    }

}