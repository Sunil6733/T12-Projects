Feature: Flight Booking Reservation

  Scenario: Complete flight booking
    Given User is on the flight booking page
    When User enters from location "India"
    And User enters to location "Australia"
    And User sets departure date to "07-04-2026"
    And User selects 2 passengers
    And User selects "Students" as passenger category
    And User clicks search flight button
    Then User should see success message
    And User closes the browser
