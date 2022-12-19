@smoke-test

Feature: Logged user could add different products to Shopping cart

  Background:
#    Given user opens browser and navigates to test site
    Given user navigates to login page
    And user successfully logs in

       # Test Scenario 1
  Scenario: user can add an uncustomizable product to shopping cart
    When user navigates to an uncustomizable product
    And user clicks the add to cart button

    Then added to "shopping cart" success flash message displays
    And product is added successfully to the shopping cart


# Scenario: user can add a customizable product to shopping cart

# Scenario: user can add a product with multiple options to shopping cart

# Scenario: user can add a rentable product to shopping cart

# Scenario: user can add a gift card to shopping cart

# Scenario: user can add a donation product to shopping cart
