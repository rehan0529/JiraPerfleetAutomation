@logout
Feature: Logout Functionality

  User Story :
  As a user I should be able to log out

  Background:
    Given the user is on the login page


@PERF-958
Scenario: Users can logout by using logout button
  Given the user enters the "driver" information
  And the user should land on the "Quick Launchpad" page
  When user clicks on the "logout" button from profile menu
  Then the user back is on the login page

  @PERF-959 @wip
  Scenario: Users can not login with back button after logout
    Given the user enters the "driver" information
    And the user should land on the "Quick Launchpad" page
    And user clicks on the "logout" button from profile menu
    When the user click on "back" button
    Then the user back is on the login page

  @PERF-960 @wip
  Scenario: Users logout from the account after closing the tabs
    Given the user enters the "driver" information
    And the user should land on the "Quick Launchpad" page
    When the user copy the url close all the tabs and paste the Copied url into new Browser
    Then the user back is on the login page

  @PERF-961 @wip
  Scenario: Users logout from the account after closing the tabs
    Given the user enters the "driver" information
    And the user should land on the "Quick Launchpad" page
    When the user waits for 3 minutes
    Then the user back is on the login page








