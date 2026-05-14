# Wings Mock Selenium Demo Project

A sample Java Selenium project that demonstrates automated web testing for a currency converter application.

## What this demo means

This repository is a lightweight demo to show how Selenium works with Java and Maven. It is not a production application. The purpose is to:

- show how to automate web UI testing with Selenium WebDriver
- validate form validation scenarios in a web application
- generate test reports automatically after execution
- let you customize the test implementation in `ValidateTest.java`

The demo specifically tests a currency converter web app with validation for date and amount fields.

## Features

This project includes automated tests for:

- **UI Elements Visibility** - Verify that currency input fields and date picker are displayed
- **Date Validation** - Check error message when date is not selected
- **Amount Validation** - Check error message for invalid amounts (zero or negative)

## Project Structure

```
wings-mock-selenium/
├── src/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── qaexample/
│       │           ├── SeleniumTest.java
│       │           ├── ValidateTest.java
│       │           └── TestListeners.java
│       └── resources/
│           └── webapp/
│               └── index.html
├── pom.xml
├── .gitignore
└── README.md
```

## Local prerequisites

Before running this project locally, install:

- Java JDK 17 or later
- Apache Maven 3.8+ or later
- A terminal or command prompt

Ensure `java` and `mvn` are available on your PATH.

## Setup and run prompt

Open a terminal, navigate to the project directory, and execute the commands below.

### Windows PowerShell

```powershell
cd "c:\T12 automation\Projects\wings-mock-selenium"
java -version
mvn -version
mvn clean test
```

### macOS / Linux

```bash
cd "/path/to/T12 automation/Projects/wings-mock-selenium"
java -version
mvn -version
mvn clean test
```

## Dependencies

The project uses Maven to manage dependencies. The main dependencies are:

- `org.seleniumhq.selenium:selenium-java:4.41.0` - Selenium WebDriver for browser automation
- `io.github.bonigarcia:webdrivermanager:5.8.0` - Automatic WebDriver management
- `junit:junit:4.13.2` - JUnit 4 test framework

These dependencies are declared in the `pom.xml` file and are downloaded automatically by Maven.

## Running Tests

From the project root, run:

```bash
mvn clean test
```

This will:

- compile the test sources
- run the Selenium test(s)
- generate reports in the `target/` directory

## Reports

After test execution, the generated reports are available in:

- `target/surefire-reports/TEST-com.qaexample.ValidateTest.xml`
- `target/surefire-reports/com.qaexample.ValidateTest.txt`

Open the XML report to review test results.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
