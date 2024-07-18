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

  @payrollrun @attendance
  Scenario: Payroll run with Attendance Input
    Given I am on the payrolls page
    When I create a new payroll run for "January 1-31, 2024" with type "Normal Payroll" for the pay group "all"
    And I enter the following values on the attendance table
      | ID   |         Name      | Days Absent | Undertime | Ord-OT | Ord-ND | Ord-ND-OT | RegNDExcess | RD    | RD-OT | RD-ND | RD-ND-OT | SunNDExcess | SH    | SH-OT | SH-ND | SH-ND-OT | SHNDExcess | LH    | LH-OT | LH-ND | LH-ND-OT | LHNDExcess | SH-RD | SH-RD-OT | SH-RD-ND | SH-RD-ND-OT | SHRNDExcess | LH-RD | LH-RD-OT | LH-RD-ND | LH-RD-ND-OT | LHRNDExcess | DH    | DH-OT | DH-ND | DH-ND-OT | DHNDExcess | DH-RD | DH-RD-OT | DH-RD-ND | DH-RD-ND-OT |
      | 111  | John Rainier      | 1           | 150       | 10:00  | 40:00  | 05:00     | 01:30       | 16:00 | 02:00 | 01:30 | 00:45    | 00:30       | 08:00 | 01:00 | 02:00 | 00:30    | 00:15      | 08:00 | 02:00 | 01:00 | 00:30    | 00:15      | 08:00 | 02:00    | 01:30    | 00:45       | 00:30       | 08:00 | 03:00    | 02:00    | 01:00       | 00:45       | 08:00 | 01:00 | 01:30 | 00:45    | 00:30      | 08:00 | 02:00    | 01:00    | 00:30       |
      | 222  | Rainier Joseph    | 0           | 75        | 15:00  | 35:00  | 03:00     | 00:45       | 08:00 | 01:30 | 04:00 | 01:00    | 00:30       | 08:00 | 00:30 | 04:00 | 01:00    | 00:15      | 08:00 | 01:00 | 04:00 | 00:30    | 00:15      | 08:00 | 01:30    | 02:00    | 00:45       | 00:30       | 08:00 | 02:00    | 04:00    | 01:00       | 00:30       | 08:00 | 01:30 | 02:00 | 00:45    | 00:30      | 08:00 | 01:00    | 01:30    | 00:45       |
    Then I should get the payroll summary table

