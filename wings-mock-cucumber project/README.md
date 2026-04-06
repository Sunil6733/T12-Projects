# Cucumber Simple Demo Project

A sample Java Cucumber project that demonstrates a simple Behaviour-Driven Development (BDD) scenario.

## What this demo means

This repository is a lightweight demo to show how Cucumber works with Java and Maven. It is not a production application. The purpose is to:

- show how feature files map to Java step definitions
- validate a small data-driven scenario in BDD style
- generate test reports automatically after execution
- let you customize the step implementation in `CalculatorSteps.java`

The demo specifically tests a character-counting scenario using a Cucumber data table.

## Features

This project includes automated tests for:

- **Character Counter** - Count characters in names from a data table
- verify how many users share the same name length
- support natural-language scenario steps in Cucumber

## Project Structure

```
cucumber-simple-demo/
├── src/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           ├── RunCucumberTest.java
│       │           └── steps/
│       │               └── CalculatorSteps.java
│       └── resources/
│           └── features/
│               └── calculator.feature
├── pom.xml
├── .gitignore
└── README.md
```

## Local prerequisites

Before running this project locally, install:

- Java JDK 17 or later
- Apache Maven 3.8+ or later
- A terminal or command prompt
- Ensure `java` and `mvn` are available on your PATH

## Setup and run prompt

Open a terminal, navigate to the project directory, and execute the commands below.

### Windows PowerShell

```powershell
cd "c:\T12 automation\Projects\cucumber-simple-demo"
java -version
mvn -version
mvn clean test
```

### macOS / Linux

```bash
cd "/path/to/T12 automation/Projects/cucumber-simple-demo"
java -version
mvn -version
mvn clean test
```

## Dependencies

The project uses Maven to manage dependencies. The main dependencies are:

- `io.cucumber:cucumber-java` - Cucumber Java bindings
- `io.cucumber:cucumber-junit` - Cucumber JUnit integration
- `junit:junit` - JUnit 4 test framework

These dependencies are declared in the `pom.xml` file and are downloaded automatically by Maven.

## Running Tests

From the project root, run:

```bash
mvn clean test
```

This will:

- compile the test sources
- run the Cucumber feature(s)
- generate reports in the `target/` directory

## Reports

After test execution, the generated reports are available in:

- `target/cucumber-reports.html`
- `target/cucumber.json`

Open the HTML report in a browser to review test results.

## Notes

- If you want to modify the behavior, edit `CalculatorSteps.java`.
- If you want to change the feature, edit `src/test/resources/features/calculator.feature`.
- The current demo only contains one scenario for character counting.
