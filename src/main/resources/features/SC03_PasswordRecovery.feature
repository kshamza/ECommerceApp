@smoke-test
Feature: User could reset his/her password successfully

  Background:
#    Given user opens browser and navigates to test site
    Given user navigates to login page
    And user navigates to forgot password page

    # Test Scenario 1
  Scenario: user can reset his/her password successfully
    When user enters a registered email
    And user clicks recover button

    Then success flash message is displayed
