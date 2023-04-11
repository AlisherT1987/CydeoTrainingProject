Feature: Add new Student and verify from DB and API
  @ui
  Scenario:Add new Student on UI
    Given user on login page
    And login with valid credentials
    Then user on Dashboard page
    And click "Add Student" under "Students" module on left side of page
Then fill out all student information on "Add Student" page
  | Firstname     | Alisher              |
  | Lastname      | King                 |
  | Email         | AK@gmail.com         |
  | Joining Date  | 04/06/2023           |
  | Subject       | JAVA                 |
  | Gender        | Male                 |
  | Mobile number | 7771234568           |
  | Birth Date    | 03/19/1987           |
  | Batch         | 1                    |
  | Major         | IT                   |
  | Company Name  | Rainbow LLC          |
  | Start Date    | 03/08/2022           |
  | Street        | 777 Hard Road,apt 00 |
  | State         | Hawaii               |
  | Title         | Clean                |
  | City          | Honolulu             |
  | ZipCode       | 96815                |
  Then click "Submit" button
   @db
    Scenario: verify new Student information  from DB
    Given Establish the database connection
      When Execute query to get all information using "Alex"
      Then Verify DB information matching with UI part

      Scenario: verify new Student information from API
        Given I sent get request to "/student/{id}" endpoint
        Then information about new student from api and UI should match




