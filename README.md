# Vehicle Rental System

## Overview

The Vehicle Rental System is a command-line application designed to manage vehicle rentals, calculate costs, and generate invoices based on user input.

## Features

- **Customer Management**: Collects customer details such as name, age, and driving experience.
- **Vehicle Selection**: Offers various vehicle types including cars, motorcycles, and cargo vans.
- **Rental Information**: Gathers rental details like reservation dates and actual return date.
- **Invoice Generation**: Computes rental and insurance costs, applies early return discounts, and produces detailed invoices.
- **Command-Line Interface (CLI)**: Provides an intuitive text-based interface for user interaction.

# Vehicle Rental System

## Project Structure

The project is organized into several main directories and subdirectories:

- **/src**: Contains all source code files for the application.
  - **Main.java**: Entry point of the application.
  - **/exceptions**: Custom exception classes for handling specific errors.
    - Exception classes such as InvalidActualReturnDateException, InvalidReservationEndDateException, InvalidReservationStartDateException, and SameDateReturnException.
  - **/factories**: Factory classes for creating data collectors.
    - **DataCollectorFactory.java**: Factory to instantiate DataCollector instances based on input.
  - **/helpers**: Utility classes to assist with calculations and logic.
    - **/invoice**: Helper class for generating invoices.
      - **Invoice.java**: Constructs and prints invoices based on rental details.
    - **/insurance**: Helper class for calculating insurance costs.
      - **Insurance.java**: Computes daily insurance costs based on vehicle and customer details.
    - **/rental**: Helper class for calculating rental costs.
      - **RentalCost.java**: Computes daily rental costs based on vehicle type and rental duration.
  - **/models**: Contains all data models used in the application.
    - **/customer**: Classes representing customer details.
      - **Customer.java**: Stores information about a customer including name, age, and driving experience.
    - **/rental**: Classes related to rental information.
      - **RentalInfo.java**: Record for storing reservation and return dates, and rental durations.
    - **/vehicle**: Classes representing different types of vehicles.
      - **Vehicle.java**: Base class for all vehicle types.
      - **/impl**: Implementations of specific vehicle types.
        - **Car.java**: Represents a car with additional properties like safety rating.
        - **CargoVan.java**: Represents a cargo van with specific insurance rates based on driver experience.
        - **Motorcycle.java**: Represents a motorcycle with specific insurance rates based on rider age.
  - **/utils**: Utility classes and processors used throughout the application.
    - **/collectors**: Interfaces and implementations for collecting user input.
      - **DataCollector.java**: Interface for collecting various types of data.
      - **/impl**: Implementations of data collectors for customers, vehicles, and rental information.
        - **CustomerDataCollector.java**: Collects customer details like name, age, and driving experience.
        - **RentalInfoDataCollector.java**: Collects rental details such as reservation dates and actual return date.
        - **VehicleDataCollector.java**: Collects vehicle details such as type and specifications.
      - **DateFormatter.java**: Utility class for date formatting.
      - **DecimalFormatter.java**: Utility class for formatting decimal numbers.
    - **/processors**: Utility classes for data processing.
      - **DateProcessor.java**: Utility class for date validation and manipulation.
     
        
## Usage

1. **Setup**: Clone the repository and ensure Java and an IDE are installed.

2. **Run**: Open the project in your IDE and execute `Main.java`. Follow console prompts to interact with the application.

3. **Input**: Enter customer details, select a vehicle type, and input rental dates. The system validates inputs and guides through any errors.

4. **Output**: Upon correct input, the system generates a detailed invoice showing rental costs, insurance fees, discounts, and total expenses.

## Dependencies

- **Lombok**: Streamlines boilerplate code in model classes.

## Contributing

Contributions are encouraged! Fork the repository, create a branch, make changes, and submit a pull request adhering to coding standards and including relevant tests.

## License

This project is licensed under the name of Miroslav Vergov 
