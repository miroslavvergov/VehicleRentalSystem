package miro.task.helpers.invoice;

import lombok.Getter;
import miro.task.models.vehicle.Vehicle;
import miro.task.utils.formatters.DecimalFormatter;
import miro.task.utils.formatters.DateFormatter;

import java.util.Date;

/**
 * Invoice class encapsulates details of a rental invoice.
 * It is responsible for holding the data related to the invoice and calculating the total cost.
 */
@Getter
public class Invoice {

    private final String customerName;
    private final Vehicle rentedVehicle;
    private final Date reservationStartDate;
    private final Date reservationEndDate;
    private final int reservedRentalDays;
    private final Date actualReturnDate;
    private final int actualRentalDays;
    private final double rentalCostPerDay;
    private final double insuranceCostPerDay;
    private final double totalRentalCost;
    private final double totalInsuranceCost;
    private final double earlyReturnDiscountRental;
    private final double earlyReturnDiscountInsurance;
    private final double totalCost;
    private final boolean returnedEarlier;
    private final Class<?> vehicleType;

    /**
     * Constructor to initialize invoice details.
     */
    public Invoice(String customerName, Vehicle rentedVehicle, Date reservationStartDate, Date reservationEndDate, int reservedRentalDays,
                   Date actualReturnDate, int actualRentalDays, double rentalCostPerDay, double insuranceCostPerDay,
                   double totalRentalCost, double totalInsuranceCost, double earlyReturnDiscountRental, double earlyReturnDiscountInsurance, boolean returnedEarlier, Class<?> vehicleType) {
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
        this.vehicleType = vehicleType;
    }
}
