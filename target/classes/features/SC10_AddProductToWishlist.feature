
Feature: Logged user could add different products to wishlist

  Background:
#    Given user opens browser and navigates to test site
    Given user navigates to login page
    And user successfully logs in

       # Test Scenario 1
  Scenario: user can add an uncustomizable product to wishlist
    When user navigates to an uncustomizable product
    And user clicks the add to wishlist button

    Then added to "wishlist" success flash message displays
    And product is added successfully to the wishlist


# Scenario: user can add a customizable product to wishlist

# Scenario: user can add a product with multiple options to wishlist

# Scenario: user can add a rentable product to wishlist

# Scenario: user can add a gift card to wishlist

# Scenario: user can add a donation product to wishlist