@login
Feature: Login

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter username "Raini\admin" and password "rainier"
    And I click the login button
    Then I should be logged in successfully

