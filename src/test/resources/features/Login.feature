@regression
Feature: Login Functionality

  User Story :
  As a user, I should be able to login.

  Background: the user is on the login page

  @PERF-871
  Scenario: Login as a driver
    Given the user is on the login page
    When the user enters the "driver" information
    Then the user should land on the "Quick Launchpad" page

  @PERF-923
  Scenario: Login as a Sales Manager
    Given the user is on the login page
    When the user enters the "sales Manager" information
    Then the user should land on the "Dashboard" page

  @PERF-925
  Scenario: Login as a Store Manager
    Given the user is on the login page
    When the user enters the "store Manager" information
    Then the user should land on the "Dashboard" page

  @PERF-927
  Scenario: Login without providing credentials
    Given the user is on the login page
    When the user enters the "driver" information
    And copy the url, logout and paste the url in new browser
    Then the user is on the login page

  @PERF-930 @PERF-931 @PERF-932
  Scenario Outline: Login with invalid credentials
    Given the user is on the login page
    When the user enters the "<validlogin>" login and "<invalidpassword>"
    And the user enters the "<invalidlogin>" login and "<validpassword>"
    And the user enters the "<invalidlogin>" login and "<invalidpassword>"
    Then a warning message "<warningMessage>" is displayed
    Examples:
      | validlogin | invalidpassword | invalidlogin | validpassword | warningMessage                 |
      | User1      | 123456          | us123        | UserUser123   | Invalid user name or password. |

  @PERF-933
  Scenario: Login with blank credentials
    Given the user is on the login page
    When the user enters the "" login and "" password
    Then an alert warning "Please fill out this field." is displayed

  @PERF-935
  Scenario: Verify the Password field input as bullet signs
    Given the user is on the login page
    When the user enters the "user1" and "UserUser123"information
    Then the user should see password in bullet signs only while typing

  @PERF-937
  Scenario: Forget password Functionality
    Given the user is on the login page
    When the user click on the "Forgot your password?" link
    Then he should land on the "Forgot Password" page

  @PERF-938
  Scenario: Password Change request
    Given the user is on the login page
    And the user click on the "Forgot your password?" link
    And the user enters the valid username as "User1"
    When click on "REQUEST" link
    Then the user should see an email is sent to change the password

  @PERF-940
  Scenario: Saving the Credentials on computer
    Given the user is on the login page
    When the user see the "Remember me on this computer" checkbox
    Then the user can see and click the checkbox

  @PERF-953
  Scenario: User Press the Enter Keys on Keyboad
    Given the user is on the login page
    When the user enters the valid credentials and press the "Enter" Keys
    Then the user should land on the "Quick Launchpad" page

  @PERF-954
  Scenario: Users can see their username in the profile menu
    Given the user is on the login page
    And the user enters the "driver" information
    When the user should land on the "Quick Launchpad" page
    Then the user should see their own "user1" in the profile menu

  @PERF-955
  Scenario: Sales Managers can see their username in the profile menu
    Given the user is on the login page
    And the user enters the Sales Manager information
    When the user should land on the "Dashboard" page
    Then the user should see their own "SalesManager101" in the profile menu

  @PERF-956
  Scenario: Store Managers can see their username in the profile menu
    Given the user is on the login page
    And the user enters the Store Manager information
    When the user should land on the "Dashboard" page
    Then the user should see their own "storemanager85" in the profile menu



