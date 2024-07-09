Feature: Payroll table run

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter valid credentials
    And I click the login button
    Then I should be logged in

  Scenario Outline: Successful payroll run
    Given I am on the payrolls page
    When I create a new payroll run for "<Payroll date>" with type "<Payroll run type>" for the pay group "<Pay group>"
    Then I should get the payroll summary table

    Examples:
      | Payroll date        | Payroll run type | Pay group     |
      | January 1-31, 2024  | Normal Payroll   | Rank and File |
      | January 1-31, 2024  | Special Run      | Rank and File |
      | February 1-29, 2024 | Normal Payroll   | Officer       |

  Scenario: Export payroll summary to excel
    Given I am on the payroll list page
    Then I download the payroll summary excel

