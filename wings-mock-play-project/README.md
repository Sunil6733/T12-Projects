# ✈️ Flight Booking Automation - Hands-On Project

> Complete Selenium + Cucumber automation project for flight booking application testing with TestNG priority-driven test execution.

---

**Status**: ✅ Complete & Production Ready  
**Version**: 1.1.0  
**Test Framework**: Selenium 4.41 + Cucumber 7.14 + TestNG 7.7 (Priority-Based)  
**Total Tests**: 10 (1 BDD Scenario + 9 Prioritized Validations)  
**Build**: Maven 3.8+

---

## 📋 Project Overview

**Name**: wings-mock-play-project  
**Purpose**: Learn and practice test automation with Selenium WebDriver + Cucumber BDD + TestNG  
**Application**: Flight Booking at localhost:8000  
**Framework**: Selenium 4.41 + Cucumber 7.14 + TestNG 7.7 + Maven  
**Language**: Java 17

---

## 🎯 Test Scenario: 3 Required Steps

### Step 1️⃣: Coupon Button Interaction

**Requirement**: Find and click the coupon button inside an iframe on the right side of the page and get its value

**Location**: Iframe on the right side of the application  
**Action**: Click button and capture value

### Step 2️⃣: Location Selection

**Requirement**: In the "Welcome Aboard" section, select the Place 4 value from the "From" field

**Location**: Welcome Aboard section  
**Field**: "From" dropdown  
**Value**: Place 4

### Step 3️⃣: Flight Search

**Requirement**: Click the "Search Flight" button and verify results

**Button**: Search Flight  
**Verification**: Results displayed

---

## 🏗️ Project Structure

```
wings-mock-play-project/
│
├── 📄 pom.xml                           (Maven configuration)
├── 📄 README.md                         (This file)
│
├── src/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           ├── RunPlayTest.java             ✓ Cucumber Test Runner
│       │           ├── SeleniumTests.java           ✓ Selenium Base Class
│       │           ├── TestListeners.java           ✓ Test Lifecycle Listeners
│       │           ├── ValidateTests.java           ✓ UI Validation Tests (9 tests)
│       │           │
│       │           └── steps/
│       │               ├── PlaySteps.java           ✓ Cucumber Step Definitions (BDD)
│       │               └── StepDefinitions.java     ✓ Additional Step Definitions
│       │
│       └── resources/
│           └── features/
│               └── play.feature                     ✓ Gherkin Feature File
│
└── target/
    ├── cucumber-report.html             (HTML test report)
    ├── cucumber-report.json             (JSON test report)
    ├── cucumber-report.xml              (XML test report)
    ├── surefire-reports/                (JUnit reports)
    └── test-classes/
```

---

## ⚙️ Prerequisites

### System Requirements

- ✅ Java 17 or higher
- ✅ Maven 3.8+
- ✅ Chrome browser
- ✅ Node.js (for running flight booking server)

### Verify Installation

```bash
java -version
mvn -version
npm -v
```

---

## 🚀 Quick Start

### Step 1: Start Flight Booking Server

**Terminal 1**:

```bash
cd "c:\T12 automation\Projects\wings-mock-nigthwatch project"
npm install
npm start
```

**Expected Output**:

```
Server running on http://localhost:8000
```

**Verify**: Open http://localhost:8000 in browser

### Step 2: Run Tests

**Terminal 2**:

```bash
cd "c:\T12 automation\Projects\wings-mock-play-project"
mvn clean test
```

**Expected Output**:

```
[INFO] BUILD SUCCESS
Scenario: Complete flight booking with coupon and location selection - PASSED
```

### Step 3: View Reports

```bash
# Open HTML report
start target\cucumber-report.html
```

---

## 📁 Test Files Overview

### 1. **RunPlayTest.java** - Cucumber Test Runner ✓

- **Purpose**: Executes Cucumber BDD scenarios
- **Location**: `src/test/java/com/example/RunPlayTest.java`
- **Configuration**:
  - Feature file: `play.feature`
  - Step definitions glue: `com.example.steps`
  - Report plugins: HTML, JSON, XML

### 2. **PlaySteps.java** - BDD Step Definitions ✓

- **Purpose**: Implements Cucumber step definitions for BDD scenarios
- **Location**: `src/test/java/com/example/steps/PlaySteps.java`
- **Implements**:
  - @Given: Navigate to flight booking app
  - @When: Coupon button interaction (iframe)
  - @And: Location selection (Place 4)
  - @Then: Search flight button click
  - @And: Results verification

### 3. **StepDefinitions.java** - Additional Step Definitions ✓

- **Purpose**: Parameterized Cucumber steps for data-driven testing
- **Location**: `src/test/java/com/example/steps/StepDefinitions.java`
- **Features**:
  - Flight page validation
  - From/To location entry
  - Departure date setting
  - Passenger count manipulation
  - Category selection (Students, Doctor, etc.)
  - Search flight execution
  - Success message verification
  - Browser cleanup

### 4. **SeleniumTests.java** - Selenium Base Class ✓

- **Purpose**: Reusable Selenium WebDriver utilities
- **Location**: `src/test/java/com/example/SeleniumTests.java`
- **Methods**:
  - WebDriver setup and teardown
  - Application navigation
  - Element finding (XPath)
  - Frame switching
  - Text input operations
  - Element clicking
  - Text extraction

### 5. **TestListeners.java** - Test Lifecycle Listeners ✓

- **Purpose**: Handles test execution events and logging
- **Location**: `src/test/java/com/example/TestListeners.java`
- **Features**:
  - Test start notifications
  - Test failure tracking
  - Test completion logging
  - Execution lifecycle management

### 6. **ValidateTests.java** - TestNG UI Validation Tests ✓

- **Purpose**: TestNG-based validation tests with priority-driven execution
- **Location**: `src/test/java/com/example/ValidateTests.java`
- **Framework**: TestNG 7.7.0 with `@Test(priority = N)` annotations
- **Execution Order** (by priority):
  1. `validateFromFieldExists()` (Priority 1) - Verify From field
  2. `validateToFieldExists()` (Priority 2) - Verify To field
  3. `validateSearchButtonExists()` (Priority 3) - Verify Search button
  4. `validatePassengersCounterExists()` (Priority 4) - Verify passenger counter
  5. `validateDepartureDateExists()` (Priority 5) - Verify date field
  6. `validateCurrencyDropdownExists()` (Priority 6) - Verify currency dropdown
  7. `validateCouponIframeExists()` (Priority 7) - Verify coupon iframe
  8. `validateFormSubmissionWithValidData()` (Priority 8) - Verify form submission
  9. `validatePassengersCounterIncrement()` (Priority 9) - Verify counter increment

**Key Features**:

- Tests execute in defined priority order (1-9)
- Hierarchical test execution (basic validations before complex interactions)
- Better test organization and control
- Clear test execution flow in reports

### 7. **play.feature** - Gherkin Feature File ✓

- **Purpose**: BDD scenario in readable Gherkin format
- **Location**: `src/test/resources/features/play.feature`
- **Scenario**: Complete flight booking with coupon and location selection
- **Step Count**: 5 steps (Given, When, And, Then, And)

---

## 🧪 Running Tests

### Command Options

**Full Clean Build and Test** (All tests):

```bash
mvn clean test
```

**Validation Tests Only** (9 UI validation tests with priority execution):

```bash
mvn clean test -Dtest=ValidateTests
```

✅ Test Execution Summary

### Test Types in This Project

| Test Type          | File               | Count  | Framework               | Purpose                            |
| ------------------ | ------------------ | ------ | ----------------------- | ---------------------------------- |
| **BDD Scenarios**  | RunPlayTest.java   | 1      | Cucumber                | Business-readable test scenarios   |
| **UI Validations** | ValidateTests.java | 9      | TestNG (Priority-Based) | Element presence and functionality |
| **Total Tests**    | -                  | **10** | -                       | -                                  |

### Test Categories

#### 🎯 BDD Tests (Cucumber)

- **File**: `RunPlayTest.java` + `PlaySteps.java`
- **Count**: 1 scenario, 5 steps
- **Framework**: Cucumber 7.14 + JUnit
- **Purpose**: End-to-end flight booking workflow
- **Execution Time**: ~8-10 seconds

#### 🔍 Validation Tests (TestNG with Priority)

- **File**: `ValidateTests.java`
- **Count**: 9 test methods
- **Framework**: TestNG 7.7.0 with `@Test(priority = N)`
- **Purpose**: Verify all UI elements exist and function in controlled execution order
- **Execution Pattern**: Priority-based (1-9) for organized test flow
- **Execution Time**: ~16-20 seconds (sequential priority-based execution)
- **Coverage**:
  - **Priority 1-3**: Form fields validation (From, To, Search button)
  - **Priority 4-7**: UI element validation (Counter, Date, Currency, iframe)
  - **Priority 8-9**: Complex interactions (Form submission, Counter increment)

#### 📋 Additional Test Support

- **File**: `StepDefinitions.java`, `SeleniumTests.java`, `TestListeners.java`
- **Purpose**: Reusable utilities, listeners, and helper methods
- **Features**: Driver management, element operations, event handling

---

## 🎯 TestNG Priority-Based Test Execution

### What is Priority-Based Testing?

Priority annotations control the order in which tests execute. This ensures tests run in a logical sequence:

- **Basic Tests First**: Verify foundational elements before complex interactions
- **Hierarchical Workflow**: Build from simple UI validation to complex form operations
- **CI/CD Friendly**: Reproducible execution order across all environments

### Priority Levels in ValidateTests.java

```
Priority 1 → validateFromFieldExists()          (Basic: From input field)
Priority 2 → validateToFieldExists()            (Basic: To input field)
Priority 3 → validateSearchButtonExists()       (Basic: Search button)
Priority 4 → validatePassengersCounterExists()  (Intermediate: Counter)
Priority 5 → validateDepartureDateExists()      (Intermediate: Date field)
Priority 6 → validateCurrencyDropdownExists()   (Intermediate: Dropdown)
Priority 7 → validateCouponIframeExists()       (Intermediate: iframe)
Priority 8 → validateFormSubmissionWithValidData() (Complex: Form workflow)
Priority 9 → validatePassengersCounterIncrement() (Complex: Counter logic)
```

### Code Pattern Example

```java
@Test(priority = 1)
public void validateFromFieldExists() {
    // Test code
}

@Test(priority = 2)
public void validateToFieldExists() {
    // Test code
}
```

### Advantages

✅ **Organized Execution**: Tests run in defined order  
✅ **Dependency Management**: Basic tests before dependent tests  
✅ **Better Reports**: Clear test flow in HTML/XML reports  
✅ **Scalability**: Easy to manage complex test suites  
✅ **CI/CD Integration**: Consistent ordering across pipelines

---

## 📊 Test Reports Generated

### Report Types

| Report               | Location                      | Format           | Purpose                   |
| -------------------- | ----------------------------- | ---------------- | ------------------------- |
| **HTML Report**      | `target/cucumber-report.html` | Visual           | View in browser           |
| **JSON Report**      | `target/cucumber-report.json` | Machine-readable | CI/CD integration         |
| **XML Report**       | `target/cucumber-report.xml`  | JUnit XML        | Jenkins/tools integration |
| **Surefire Reports** | `target/surefire-reports/`    | XML/TXT          | Maven test reports        |

---

## 🔍 Expected Test Results

### Current Status: ✅ BUILD SUCCESS

| Metric         | Result         |
| -------------- | -------------- |
| Tests Run      | 10             |
| Failures       | 0              |
| Errors         | 0              |
| Skipped        | 0              |
| Total Duration | ~28-35 seconds |
| Build Status   | **SUCCESS** ✅ |

### Test Output Example

````

[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] BUILD SUCCESS

```Tests

**Location**: `target/` directory

**Files**:

- `cucumber-report.html` - Visual HTML report
- `cucumber-report.json` - Machine-readable JSON report
- `cucumber-report.xml` - JUnit XML format

### Report Contents

- Scenario status (Passed/Failed)
- Step-by-step execution flow
- Test duration
- Error messages (if any)
- Detailed logs

---

## 🔍 Expected Test Behavior

### Execution Flow

1. **Setup Phase** (0-1 sec)
   - Maven launches
   - ChromeDriver auto-downloaded (first run only)
   - Cucumber initializes

2. **Browser Launch** (1-2 sec)
   - Chrome browser opens
   - Navigates to http://localhost:8000
   - Page loads

3. **Test Steps** (2-8 sec)
   - ✓ Iframe detected
   - ✓ Coupon button found and clicked
   - ✓ "Place 4" entered in From field
   - ✓ Search Flight button clicked
   - ✓ Results logged

4. **Cleanup Phase** (8-10 sec)
   - Browser closes
   - Reports generated
   - Test completed

---

## ✅ Success Criteria

All of the following must be true for successful test run:

- ✅ Maven build succeeds
- ✅ All 5 steps pass (Given + When + And + Then + And)
- ✅ No "NoSuchElementException" errors
- ✅ No "Connection Refused" errors
- ✅ HTML report generated in target/
- ✅ JSON report generated in target/
- ✅ Test completes in 8-10 seconds
- ✅ No exceptions in console

---

## 🐛 Troubleshooting

### Issue: "Connection Refused" Error

```

ERROR: net::ERR_CONNECTION_REFUSED

```

**Solution**:

- Ensure Flight Booking server is running: http://localhost:8000
- Start server with: `npm start` in nightwatch project

### Issue: Element Not Found

```

ERROR: NoSuchElementException

```

**Solution**:

- Verify iframe is rendering
- Check browser console for JavaScript errors
- Increase wait timeout (currently 10 seconds)

### Issue: ChromeDriver Not Found

```

ERROR: Could not find chromedriver

```

**Solution**:

- WebDriverManager auto-downloads on first run (5-10 min)
- Wait for download to complete
- Retry: `mvn clean test`

### Issue: Maven Build Fails

```

ERROR: BUILD FAILURE

````

**Solution**:

- Clear Maven cache: `mvn clean`
- Check internet connection (downloading dependencies)
- Verify Java 17+ installed: `java -version`

---

## 🧑‍💻 Code Highlights

### iframe Switching

```java
WebElement iframe = wait.until(
    ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe"))
);
driver.switchTo().frame(iframe);
```

### Clicking Button and Getting Value

```java
WebElement couponButton = wait.until(
    ExpectedConditions.elementToBeClickable(...)
);
couponValue = couponButton.getText();
couponButton.click();
```

### Explicit Waits

```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
```

### Returning to Main Content

```java
driver.switchTo().defaultContent();
```

---

## 📋 Test Data

| Field           | Value                    |
| --------------- | ------------------------ |
| Application URL | http://localhost:8000    |
| From Location   | Place 4                  |
| Departure Date  | 06/10/2024 (auto-filled) |
| Passengers      | 1 (default)              |
| Currency        | INR (default)            |

---

## 📚 Technology Stack

| Component        | Version | Purpose                 |
| ---------------- | ------- | ----------------------- |
| Java             | 17      | Programming language    |
| Selenium         | 4.41.0  | Browser automation      |
| Cucumber         | 7.14.0  | BDD framework           |
| Maven            | 3.8+    | Build tool              |
| WebDriverManager | 5.8.0   | ChromeDriver management |
| JUnit            | 4.13.2  | Test framework          |
| Chrome           | Latest  | Browser                 |

---

## 📖 Project Files Locations

**Main Project Directory**:

```
c:\T12 automation\Projects\wings-mock-play-project\
```

**Feature File**:

```
src/test/resources/features/play.feature
```

**Step Implementations**:

```
src/test/java/com/example/steps/PlaySteps.java
```

**Test Runner**:

```
src/test/java/com/example/RunPlayTest.java
```

**Configuration**:

```
pom.xml
```

---

## 🎓 Learning Outcomes

After completing this project, you will understand:

- ✅ Selenium WebDriver basics
- ✅ Cucumber BDD framework
- ✅ iframe handling in web automation
- ✅ Explicit waits for element detection
- ✅ Maven project structure
- ✅ Test report generation
- ✅ Troubleshooting automation issues
- ✅ Best practices in test automation

---

## 🚀 Next Steps

### After First Successful Run

1. Review HTML report in `target/cucumber-report.html`
2. Understand each step in the feature file
3. Modify test data to practice changes
4. Add additional scenarios

### Enhancement Ideas

- [ ] Add more flight booking scenarios
- [ ] Implement Page Object Model (POM)
- [ ] Add data-driven tests
- [ ] Setup CI/CD pipeline
- [ ] Add performance benchmarks
- [ ] Implement parallel execution

---

## 📞 Common Commands

```bash
# Navigate to project
cd "c:\T12 automation\Projects\wings-mock-play-project"

# Build only (no tests)
mvn clean install

# Run tests only
mvn test

# Run specific test
mvn test -Dtest=RunPlayTest

# Clear build
mvn clean

# Full build with tests
mvn clean test

# Skip tests
mvn clean install -DskipTests

# Generate only reports
mvn clean test surefire-report:report

# Verbose output
mvn test -X

# Show dependencies
mvn dependency:tree
```

---

## 📞 Support

### Issues with Setup?

1. Verify all prerequisites installed
2. Check system PATH variables
3. Ensure ports available (8000 for server)

### Tests Failing?

1. Start flight booking server first
2. Check browser console (F12) for errors
3. Review consolelogs in test output
4. Check HTML report for details

### Need Help?

1. Read error messages carefully
2. Review ValidateTests.java for element selectors
3. Review PlaySteps.java for test implementation
4. Check browser developer tools (F12)
5. Visit http://localhost:8000 to verify app is running

---

## 📝 Test Execution Flow Diagram

```
mvn clean test
      ↓
   ↙─────────────────────────────────────────────↘
  ↓                                                ↓
RunPlayTest (Cucumber)                      ValidateTests (JUnit)
1 Scenario                                  9 Test Methods
5 Steps                                     UI Element Validation
~8-10 seconds                               ~20-25 seconds
  ↓                                                ↓
  └─────────────────────────────────────────────┘
              ↓
        Generate Reports
    (HTML, JSON, XML, Surefire)
              ↓
        BUILD SUCCESS ✅
```

---

## 📚 All Test Files Summary

| File                 | Type             | Tests      | Purpose                      |
| -------------------- | ---------------- | ---------- | ---------------------------- |
| RunPlayTest.java     | Cucumber         | 1 scenario | BDD test runner              |
| PlaySteps.java       | Cucumber Steps   | 5 steps    | BDD step implementations     |
| StepDefinitions.java | Additional Steps | -          | Data-driven step definitions |
| ValidateTests.java   | JUnit            | 9 methods  | UI element validation        |
| SeleniumTests.java   | Base Class       | -          | Reusable WebDriver utilities |
| TestListeners.java   | Listeners        | -          | Test lifecycle management    |
| play.feature         | Gherkin          | 1 scenario | BDD feature file             |

**Total Test Coverage**: 10 Tests + 1 Feature Scenario = Complete automation suite

---

## 📄 License

This project is provided as-is for learning purposes.

---

## 🎯 Quick Reference

| Need         | Command                             |
| ------------ | ----------------------------------- |
| Start Server | `npm start` (in nightwatch folder)  |
| Run Tests    | `mvn clean test`                    |
| View Report  | `start target\cucumber-report.html` |
| Stop Tests   | Ctrl+C in terminal                  |
| Clean Build  | `mvn clean`                         |

---

**Status**: ✅ Complete & Production Ready  
**Version**: 1.0.0-RELEASE  
**Last Updated**: April 7, 2026  
**Framework**: Selenium 4.41 + Cucumber 7.14 + JUnit 4 + Maven 3.8  
**Java Version**: 17+  
**Test Suite**: 10 Tests + 1 Gherkin Scenario  
**Total Duration**: ~28-35 seconds full suite
