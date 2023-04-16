@wip
Feature: Add new Student and verify from DB and API
  @ui
  Scenario:Add new Student on UI
    Given user on login page
    And login with valid credentials
    Then user on Dashboard page
    And click "Add Student" under "Students" module on left side of page
Then fill out all student information on "ADD STUDENT" page
  | Firstname         | Anna                 |
  | Lastname          | Queen                |
  | Email             | AK@gmail.com         |
  | Joining Date      | 04/06/2023           |
  | Subject           | JAVA                 |
  | Mobile number     | 7771234568           |
  | Gender            | Female               |
  | Birth Date        | 03/19/1987           |
  | Major             | IT                   |
  | Batch             | 15                   |
  | Company Name      | Rainbow LLC          |
  | Title             | Clean                |
  | Start Date        | 03/08/2022           |
  | City              | Honolulu             |
  | Street            | 777 Hard Road,apt 00 |
  | ZipCode           | 96815                |
  | State             | Hawaii               |
  | Permanent Address | Honolulu, Hawaii     |

  Then click "Submit" button and verify Username of new student on profile page
   @db
    Scenario: verify new Student information  from DB
    Given Establish the database connection
      When Execute query to get all information using "Firstname"
      Then Verify DB information matching with UI part

      Scenario: verify new Student information from API
        Given I sent get request to "/student/{id}" endpoint
        Then information about new student from api and UI should match




