Feature: count number of char

  Scenario: count char of name
    Given a set of specific users
      | name     | noOfcharsInName |
      | lalit    | 5               |
      | anshu    | 5               |
      | himanshu | 8               |
    When we count the number of characters in "lalit"
    Then we will find "2" people's with length "5"
    Then we will find only "1" person with length "8"
