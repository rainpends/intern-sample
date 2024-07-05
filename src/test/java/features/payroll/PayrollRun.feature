Feature: Payroll run

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter valid credentials
    And I click the login button
    Then I should be logged in

  Scenario: Successful payroll run
    Given I am on the payrolls page
    When I create a new payroll run
    And I set the payroll run setup
    And I click the save and next button
    And I save and process the payroll
    Then I should get the payroll summary table

