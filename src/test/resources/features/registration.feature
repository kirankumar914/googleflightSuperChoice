Feature: new user Registration

  @Register
  Scenario Outline: user wants to register for himself/herself
    Given user is new and wants to register
    When user provides "<title>" "<firstName>" "<surName>" "<phoneNumber>" "<DateOfBirth>" "<licensePeriod>" "<occupation>"
    And provides "<address>" and "<email>" for communication
    And user set the password
    And submits the registration form
    Then validate upon successful registration user lands on login page

    Examples:
      | title | firstName | surName     | phoneNumber | DateOfBirth | licensePeriod | occupation | address                | email         |
      | Mrs   | Testing   | Automation  | 0474123456  | 1989,3,23   | 5             | Actor      | street,sydney,Aus,2000 | abc@gmail.com |
      | Mrs   | Testing1  | Automation2 | 04741231223 | 1995,3,23   | 6             | Actor      | street,sydney,Aus,2000 | abc@gmail.com |

