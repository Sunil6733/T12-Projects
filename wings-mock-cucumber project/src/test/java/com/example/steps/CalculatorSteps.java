package com.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;

/**
 * Step Definitions for Character Counter BDD Tests
 * 
 * TODO: Implement the following methods:
 * 1. setUsers() - Parse DataTable and count character lengths
 * 2. countCharacters() - Store the name being counted
 * 3. verifyPeopleWithLength() - Assert correct count for multiple people
 * 4. verifyPersonWithLength() - Assert correct count for single person
 */
public class CalculatorSteps {
    
    // TODO: Declare instance variables for:
    // - List to store user data from DataTable
    // - Map to store character length counts
    // - String to store the current name being processed
    

    /**
     * Step: Given a set of specific users
     * 
     * TODO: Implement this method to:
     * 1. Extract user data from DataTable
     * 2. Initialize the character length count map
     * 3. Count how many users have each character length
     * 
     * Example data:
     * | name     | noOfcharsInName |
     * | lalit    | 5               |
     * | anshu    | 5               |
     * | himanshu | 8               |
     */
    @Given("a set of specific users")
    public void setUsers(DataTable dataTable) {
        // TODO: Implement this method
        // 1. Get all rows as maps: List<Map<String, String>> users = dataTable.asMaps(String.class, String.class);
        // 2. Create a HashMap to count character lengths: Map<Integer, Integer>
        // 3. Loop through users and count occurrences of each character length
        // 4. Store results for use in Then steps
    }

    /**
     * Step: When we count the number of characters in {string}
     * 
     * TODO: Implement this method to:
     * Store the name being counted (for potential future use)
     */
    @When("we count the number of characters in {string}")
    public void countCharacters(String name) {
        // TODO: Implement this method
        // Store the name parameter for potential use in assertions
    }

    /**
     * Step: Then we will find {string} people's with length {string}
     * 
     * TODO: Implement this method to:
     * 1. Get the expected count as integer
     * 2. Get the character length as integer
     * 3. Retrieve the actual count from your character length map
     * 4. Assert that actual equals expected
     * 
     * Example: "2" people's with length "5" -> Assert 2 users have 5 characters
     */
    @Then("we will find {string} people's with length {string}")
    public void verifyPeopleWithLength(String expectedCount, String length) {
        // TODO: Implement this method
        // 1. Parse expectedCount and length to integers
        // 2. Get actual count from character length counts map (use getOrDefault for safety)
        // 3. Use assertEquals to verify: assertEquals(expectedCount, actualCount)
    }

    /**
     * Step: Then we will find only {string} person with length {string}
     * 
     * TODO: Implement this method (similar to verifyPeopleWithLength)
     * This step is used for singular "person" in the assertion
     */
    @Then("we will find only {string} person with length {string}")
    public void verifyPersonWithLength(String expectedCount, String length) {
        // TODO: Implement this method
        // Same logic as verifyPeopleWithLength but used for singular context
    }
}

