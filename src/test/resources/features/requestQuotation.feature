Feature: request a quotation

  Background: User is Logged In
    Given user is on the login page
    When user provides valid login details

  @RequestAPremium
  Scenario: user provides the required details and calculates the premium
    Given user is on the request quotation page
    When user provides the required details to calculate the premium
    |incidents|Registration|Annual mileage|Estimated value|Parking Location|Start of policy|
    |123      |abc123      |12000         |75000          |Locked Garage   |2023,11,20     |
    Then validate the application generated a premium

  @saveQuote
  Scenario: user provides the required details and calculates the premium
    Given user is on the request quotation page
    When user provides the required details to calculate the premium
      |incidents|Registration|Annual mileage|Estimated value|Parking Location|Start of policy|
      |123      |abc123      |12000         |75000          |Locked Garage   |2023,11,20     |
    Then validate the application generated a premium
    When user save quotation
    Then validate identification number is generated

  @logOut
  Scenario: user logs out from the login session
    Given user is on the request quotation page
    Then logs out from the session
