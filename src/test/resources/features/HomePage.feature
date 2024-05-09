@HomePage
Feature: flight search

  Scenario Outline: validate user can search one way flights with the given details

    Given user is on the home page
    When the user provides "<typeOfTrip>" "<numberOfPassengers>" "<class>" "<origin>" "<destination>" "<dateOfJourney>" "<dateOfReturn>"
    And clicks on explore button
    Then validate the user is landed on search result page
    Then validate search result has shown up flights related to the entered origin and destination "<origin>" "<destination>" "<dateOfJourney>" "<typeOfTrip>"

    Examples:
      | typeOfTrip | numberOfPassengers | class   | origin | destination | dateOfJourney |dateOfReturn|
      | One way    | 1,0,0,0            | Economy | Sydney | Perth       | Tue,Jun 18    |            |


  Scenario Outline: validate user can search one round trip flights with the given details

    Given user is on the home page
    When the user provides "<typeOfTrip>" "<numberOfPassengers>" "<class>" "<origin>" "<destination>" "<dateOfJourney>" "<dateOfReturn>"
    And clicks on explore button
    Then validate the user is landed on departure search result page
    Then validate search result has shown up flights related to the entered origin and destination "<origin>" "<destination>" "<dateOfJourney>" "<typeOfTrip>"
    Then validate search result has shown up flights related to the entered destination and origin "<destination>" "<origin>" "<dateOfReturn>" "<typeOfTrip>"

    Examples:
      | typeOfTrip | numberOfPassengers | class   | origin    | destination | dateOfJourney | dateOfReturn |
      | Round trip | 2,1,1,0            | Economy | Melbourne | Adelaide    | Tue,Jun 18    | Sun, Jun 23  |
