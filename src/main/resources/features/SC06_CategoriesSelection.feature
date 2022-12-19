@smoke-test

Feature: Logged user could select different Categories

  Background:
#    Given user opens browser and navigates to test site
    Given user navigates to login page
    And user successfully logs in

    # Test Scenario 1
  Scenario: user can select any category from home page
    When user randomly selects one of the categories in the top menu

    Then list of products will display under this category
