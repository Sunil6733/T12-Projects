Feature: Flight Booking Reservation

  Scenario: Complete flight booking with coupon and location selection
    Given User navigates to flight booking application
    When User finds and clicks the coupon button inside iframe on the right side and gets its value
    And User selects Place 4 value from the From field in Welcome Aboard section
    Then User clicks the Search Flight button
    And User verifies the flight search results are displayed
