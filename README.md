Vehicle Rental System
Overview
The Vehicle Rental System is a command-line application that allows users to rent vehicles, calculate rental costs, and generate invoices based on user input. This README provides an overview of how the project works and its structure.

Features
Customer Management: Collects customer details such as name, age, and driving experience.
Vehicle Selection: Allows selection of different types of vehicles including cars, motorcycles, and cargo vans.
Rental Information: Collects rental details such as reservation start date, end date, and actual return date.
Invoice Generation: Calculates rental and insurance costs, applies discounts for early returns, and generates a detailed invoice.
Command-Line Interface (CLI): Provides a user-friendly interface for interacting with the system via text input.
Project Structure
The project is organized into several packages:

models: Contains classes representing entities such as Customer, Vehicle, and RentalInfo.
helpers: Includes utility classes for invoice calculation (Invoice) and rental cost estimation (RentalCost, Insurance).
factories: Provides a factory design pattern implementation (DataCollectorFactory) for creating data collectors dynamically.
utils: Contains helper classes (DateProcessor) for date validation and manipulation.
exceptions: Defines custom exceptions (InvalidActualReturnDateException, InvalidReservationEndDateException, InvalidReservationStartDateException, SameDateReturnException) for handling specific error conditions.
collectors: Contains data collector interfaces (DataCollector) and their implementations (CustomerDataCollector, VehicleDataCollector, RentalInfoDataCollector) for gathering user input.
Usage
Setup: Clone the repository and ensure you have Java and a compatible IDE installed.

Run: Open the project in your IDE and execute the Main class. Follow the instructions in the console to interact with the application.

Input: Enter customer details, choose a vehicle type, and provide rental dates. The application validates inputs and guides the user through any errors or necessary corrections.

Output: Once all information is entered correctly, the system generates an invoice detailing rental costs, insurance costs, discounts, and total costs.

Dependencies
Lombok: Used for reducing boilerplate code in model classes (getters, setters, constructors).
JUnit: Included for unit testing purposes, ensuring robustness of critical functionalities.
Contributing
Contributions are welcome! Please fork the repository, create a new branch, make your changes, and submit a pull request. Ensure to follow existing coding standards and add relevant tests for new features or bug fixes.

License
