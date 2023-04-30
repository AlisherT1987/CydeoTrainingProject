@mobile @db @wip
Feature: Update student information through mobile phone
  Scenario: Find student profile by using Id
    Given Student on "STUDENTS LIST" page
    And type id in "Student ID" search box
    And click "Search" button
    And click edit button on student information row
    And delete existing email and put new email address
    And  after click "Submit" button
    Then sent get request to "/student/{id}" endpoint
    And get email address from API
    And Establish the database connection
    And get email address from DB by using id
    Then compare all data from DB and UI and API and should be match
