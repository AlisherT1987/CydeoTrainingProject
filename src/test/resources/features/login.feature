Feature: Login Functionality
  @ui
  Scenario: User login page
    When user on login page
    And login with valid credentials
    Then user on Dashboard page