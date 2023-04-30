Feature: Update student information through mobile phone
  Scenario: Find student profile by using Id
    Given Student on "STUDENTS LIST" page
    And type id in "Student ID" search box
    And click "search" button
    And click "edit" button on student information row
    And delete existing email and put new on
    And click "submit" button
    And get student response from API by using ID
    And extract new email address and compare with ui
    And Establish the database connection
    And get email address from DB by using ID
    Then compare email address from DB and UI
