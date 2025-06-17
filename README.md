# UAS Automation Testing Project

## Description
This project implements automation testing using Selenium WebDriver and Cucumber to test features of the **Nutribox** application. It includes tests for login, token submission, and weight data management.

## Project Structure
- **`src/main/java`**: Contains source code for page classes and core testing logic.
- **`src/test/java`**: Contains step definitions and the test runner for executing tests.
- **`src/test/resources`**: Contains feature files written in Gherkin syntax.

## Features Tested
1. **Login**: Tests for valid and invalid login credentials.
2. **Token Submission**: Tests for valid and invalid token inputs.
3. **Weight Management**: Tests for adding, editing, and deleting weight data.

## Test Results
The test results are available in the following file:
- **`/src/main/resources/result.pdf`**

This file contains a detailed report of all executed test scenarios.

## Dependencies
- **Java 11 or later**
- **Maven**
- **Selenium WebDriver**
- **Cucumber**
- **JUnit**

### Gherkin Syntax
- Test scenarios are defined in `.feature` files located in `src/test/resources/features`.
- These files use Gherkin keywords like `Given`, `When`, `Then`, etc., to describe test cases.

### Step Definitions
- Step definitions are implemented in the `uas.stepDef` package under `src/test/java`.
- Each step maps to a Gherkin step and interacts with page classes to perform actions and assertions.

### Runner Class
- The `Runner` class in `src/test/java/uas/runner/Runner.java` is used to execute all feature files.
- It specifies the location of feature files and step definitions.

### Page Object Model (POM)
- The project follows the POM design pattern to separate test logic from page-specific logic.
- Page classes (e.g., `LoginPage`, `TokenPage`, `WeightPage`) encapsulate locators and methods for interacting with specific pages.

## Features Overview

### Login
- **Valid Login**: Verifies successful login with correct credentials.
- **Invalid Login**: Ensures error messages are displayed for incorrect credentials.

### Token Submission
- **Valid Token**: Verifies successful token submission and navigation to the home page.
- **Invalid Token**: Ensures error messages are displayed for invalid tokens.

### Weight Management
- **Add Weight**: Tests adding valid and invalid weight data.
- **Edit Weight**: Tests editing weight data with valid and invalid inputs.
- **Delete Weight**: Tests deleting weight data and verifying the deletion.

## License
This project is for educational and testing purposes only.