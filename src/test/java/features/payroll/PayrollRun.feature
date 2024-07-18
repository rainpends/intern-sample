@payroll
Feature: Payroll

  @payrollrun @basic
  Scenario: Basic payroll run
    Given I am on the payrolls page
    When I create a new payroll run for "September 1-15, 2024" with type "Normal Payroll" for the pay group "all"
    Then I should get the payroll summary table

  @payrollrun @parametrized
  Scenario Outline: Parametrized payroll run
    Given I am on the payrolls page
    When I create a new payroll run for "<Payroll date>" with type "<Payroll run type>" for the pay group "<Pay group>"
    Then I should get the payroll summary table

    Examples:
      | Payroll date        | Payroll run type | Pay group     |
      | January 1-31, 2024  | Normal Payroll   | Rank and File |
      | January 1-31, 2024  | Special Run      | Rank and File |
      | February 1-29, 2024 | Normal Payroll   | Officer       |

  @exportExcel
  Scenario: Export payroll summary to excel
    Given I am on the payroll list page
    Then I download the payroll summary excel

  @payrollrun @oneTimeAdjustment
  Scenario: Payroll run with One Time Adjustment
    Given I am on the payrolls page
    When I create a new payroll run for "January 1-31, 2024" with type "Normal Payroll" for the pay group "all"
    And I add a one time adjustment for employee "123" of type "Basic Adjustment" named "Basic Adj1" with code "BA1", amount "133.29", and remark "test remark"
    Then I should get the payroll summary table

  @payrollrun @recurringAdjustment
  Scenario: Payroll run with Recurring Adjustment
    Given I am on the payrolls page
    When I go to the employees page
    And I add a recurring adjustment for employee "123" of type "Basic Adjustment" named "Basic Adj2" with code "BA2", amount "133.29", remark "test remark", and date "January 1, 2024"
    And I create a payroll run for "February 1-29, 2024" with type "Normal Payroll" for the pay group "all"
    And I see the recurring adjustment for employee "123"
    Then I should get the payroll summary table

