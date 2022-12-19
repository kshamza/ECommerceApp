@smoke-test

  Feature: Create successful order

    Background:
#    Given user opens browser and navigates to test site
      Given user navigates to login page
      And user successfully logs in
#      user adds different products to the shopping list
      And user navigates to an uncustomizable product
      And user clicks the add to cart button
      Then added to "shopping cart" success flash message displays

      When user clicks the shopping cart button
      And user checks the terms of service checkbox
      And user clicks the checkout button

      # User fills the Billing address
      And user checks the ship to the same address checkbox
      And user selects the country
      And user selects the state
      And user enters the city name
      And user enters the first address line
      And user enters the zip code
      And user enters the phone number
      And user clicks continue button
      And user accepts ground shipping

       # Test Scenario 1
    Scenario: user can create a successful order using check/money order payment method
      And user selects the "check / money order" payment method
      And user clicks continue in payment method section
      And user clicks continue button in payment information section
      And user clicks confirm button

      Then confirmation page displays





             # Test Scenario 2
#    Scenario: user can create a successful order using credit card payment method

