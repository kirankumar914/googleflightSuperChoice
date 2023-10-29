@Login
Feature: user login

  @Login_InvalidLoginDetails
  Scenario Outline: validate the error message when user provides invalid user details
    Given user is on the login page
    When user provides invalid "<loginId>" and "<password>"
    Then validate the error message on the screen

    Examples:
      | scenario description | loginId       | password |
      | invalid loginId      | abc@          | 123      |
      | invalid password     | abc@gmail.com | 12       |

  @Login_validLoginDetails
  Scenario Outline: validate the error message when user provides invalid user details
    Given user is on the login page
    When user provides valid "<loginId>" and "<password>"
    Then validate user is successfully able to signIn

    Examples:
      | scenario description | loginId | password |
      | valid details        |         |          |



