
Feature: Logged user could add different products to compare list

  Background:
#    Given user opens browser and navigates to test site
    Given user navigates to login page
    And user successfully logs in

       # Test Scenario 1
  Scenario: user can add an uncustomizable product to compare list
    When user navigates to an uncustomizable product
    And user clicks the add to compare list button

    Then added to "product comparison" success flash message displays
    And product is added successfully to the comparison list


# Scenario: user can add a customizable product to compare list

# Scenario: user can add a product with multiple options to compare list

# Scenario: user can add a rentable product to compare list

# Scenario: user can add a gift card to compare list

# Scenario: user can add a donation product to compare list