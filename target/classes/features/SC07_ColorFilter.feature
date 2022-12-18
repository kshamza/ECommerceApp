
Feature: Logged user could filter with color

  Background:
#    Given user opens browser and navigates to test site
    Given user navigates to login page
    And user successfully logs in

    # Test Scenario 1
  Scenario: user can filter by color when applicable
    When user navigates to shoes subcategory
    And user selects one of the colors

    Then list of products will display based on the color filter
