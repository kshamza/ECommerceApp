Feature: Logged user could select different tags

  Background:
#    Given user opens browser and navigates to test site
    Given user navigates to login page
    And user successfully logs in

    # Test Scenario 1
  Scenario: user can select any tag from any product category
    When user randomly selects one of the categories in the top menu
    And user randomly selects one of the tags in the Popular tags section
    And user randomly selects one of the products displayed after selecting a tag

    Then the product selected by the user has a tag that matches the selected tag by the user
