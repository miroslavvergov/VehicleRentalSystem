package miro.task.helpers.invoice;

import miro.task.models.vehicle.Vehicle;
import miro.task.models.vehicle.impl.Car;
import miro.task.models.vehicle.impl.CargoVan;
import miro.task.models.vehicle.impl.Motorcycle;
import miro.task.utils.formatters.DecimalFormatter;
import miro.task.utils.formatters.DateFormatter;

/**
 * InvoicePrinter class is responsible for printing the invoice details to the console.
 */
public class InvoicePrinter {

    private final Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    /**
     * Prints the invoice details to the console.
     */
    public void printInvoice() {
        System.out.println("XXXXXXXXXX");
        System.out.println("Date: " + DateFormatter.format(invoice.getReservationStartDate()));
        System.out.println("Customer Name: " + invoice.getCustomerName());
        System.out.println("Rented Vehicle: " + invoice.getRentedVehicle().getBrand() + " " + invoice.getRentedVehicle().getModel());
        System.out.println();
        //
        System.out.println("Reservation start date: " + DateFormatter.format(invoice.getReservationStartDate()));
        System.out.println("Reservation end date: " + DateFormatter.format(invoice.getReservationEndDate()));
        System.out.println("Reserved rental days: " + invoice.getReservedRentalDays() + " days");
        System.out.println();
        //
        System.out.println("Actual return date: " + DateFormatter.format(invoice.getActualReturnDate()));
        System.out.println("Actual rental days: " + invoice.getActualRentalDays() + " days");
        System.out.println();
        //
        System.out.println("Rental cost per day: $" + DecimalFormatter.format(invoice.getRentalCostPerDay()));
        if (invoice.isReturnedEarlier() || invoice.getVehicleType() != Car.class) {

            double initialInsurancePerDay = getInitialInsurancePerDay(invoice.getRentedVehicle());

            System.out.println("Initial insurance per day: $" + DecimalFormatter.format(initialInsurancePerDay));
            if (invoice.getVehicleType() != Motorcycle.class) {
                double insuranceDiscountPerDay = initialInsurancePerDay - invoice.getInsuranceCostPerDay();
                System.out.println("Insurance discount per day: $" + DecimalFormatter.format(insuranceDiscountPerDay));
            } else {
                double insuranceDiscountPerDay = invoice.getInsuranceCostPerDay() - initialInsurancePerDay;
                System.out.println("Insurance addition per day: $" + DecimalFormatter.format(insuranceDiscountPerDay));
            }
        }
        System.out.println("Insurance per day: $" + DecimalFormatter.format(invoice.getInsuranceCostPerDay()));
        System.out.println();
        //
        if (invoice.isReturnedEarlier()) {
            System.out.println("Early return discount for rent: $" + DecimalFormatter.format(invoice.getEarlyReturnDiscountRental()));
            System.out.println("Early return discount for insurance: $" + DecimalFormatter.format(invoice.getEarlyReturnDiscountInsurance()));
        }
        System.out.println();
        //
        System.out.println("Total rent: $" + DecimalFormatter.format(invoice.getTotalRentalCost()));
        System.out.println("Total insurance: $" + DecimalFormatter.format(invoice.getTotalInsuranceCost()));
        System.out.println("Total: $" + DecimalFormatter.format(invoice.getTotalCost()));
        System.out.println("XXXXXXXXXX");
    }

    /**
     * Calculates the initial insurance cost per day based on the vehicle type.
     *
     * @param vehicle The rented vehicle.
     * @return The initial insurance cost per day.
     */
    private double getInitialInsurancePerDay(Vehicle vehicle) {
        double initialInsurancePerDay = 0.0;
        if (vehicle instanceof CargoVan) {
            initialInsurancePerDay = vehicle.getValue() * 0.0003;
        } else if (vehicle instanceof Motorcycle) {
            initialInsurancePerDay = vehicle.getValue() * 0.0002;
        } else if (vehicle instanceof Car) {
            initialInsurancePerDay = vehicle.getValue() * 0.0001;
        }
        return initialInsurancePerDay;
    }
}
