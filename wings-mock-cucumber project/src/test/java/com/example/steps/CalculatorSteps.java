package com.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CalculatorSteps {
    private Map<Integer, Integer> characterLengthMap = new HashMap<>();

    @Given("a set of specific users")
    public void a_set_of_specific_users(DataTable dataTable) {
        for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            String name = row.get("name");
            if (name != null && !name.isEmpty()) {
                int length = name.length();
                int count = characterLengthMap.getOrDefault(length, 0);
                characterLengthMap.put(length, count + 1);
            }
        }
    }

    @When("we count the number of characters in {string}")
    public void we_count_the_number_of_characters_in(String name) {
        // No action needed here because the Given step already counted the names.
    }

    @Then("we will find {string} people's with length {string}")
    public void we_will_find_people_with_length(String expectedCount, String length) {
        int expected = Integer.parseInt(expectedCount);
        int actual = characterLengthMap.getOrDefault(Integer.parseInt(length), 0);
        assertEquals(expected, actual);
    }

    @Then("we will find only {string} person with length {string}")
    public void we_will_find_only_person_with_length(String expectedCount, String length) {
        int expected = Integer.parseInt(expectedCount);
        int actual = characterLengthMap.getOrDefault(Integer.parseInt(length), 0);
        assertEquals(expected, actual);
    }
}