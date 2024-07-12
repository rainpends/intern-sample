Feature: Adjustments

  Background: Successful login
    Given I am on the login page
    When I enter valid credentials
    And I click the login button
    Then I should be logged in

  Scenario: Payroll run with One Time Adjustment
    Given I am on the payrolls page
    When I create a new payroll run
    And I save the payroll run
    And I click the adjustments link for an employee
    And I add a new record
    And I save the adjustment
    And I save and process the payroll
    Then I should get the payroll summary table
    And I should logout

  Scenario: Payroll run with Recurring Adjustment
    When I navigate to the employees page
    And I click the adjustments link of an employee
    And I add and save an adjustment
    And I create a new payroll run with the adjustment
    Then I should get the summary table