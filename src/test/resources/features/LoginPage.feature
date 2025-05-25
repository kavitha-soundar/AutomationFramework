Feature: Orange HRM login page validation

  Background: Launching the application
  Given The user launches the application

  Scenario: Successful verification of the login functionality
    Given The user enters the username as "<username>"
    And The user enters the password as "<password>"
    When The user clicks the login button
    Then Verify the dashboard page is displayed

    Example:
      | username | password |
      | Admin    | admin123 |

