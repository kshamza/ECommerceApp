@smoke-test
Feature: User could register with valid data

  Background:
#    Given user opens browser and navigates to test site
    Given user navigates to registration page

    When user enters first name
    And user enters last name
    And user enters email
    And user enters password
    And user confirms password

    # Test Scenario 1
    Scenario: user can register with required fields only

      And user clicks on register button

      Then redirects to result page
      And success message appears
      And continue button appears
      And logout link appears

#    # Test Scenario 2
#    Scenario: user can register with all fields
#      When user selects gender
#      And user selects date of birth
#      And user enters company name
#
#      And user clicks on register button
#
#      Then redirects to result page
#      And success message appears
#      And continue button appears
#      And logout link appears
