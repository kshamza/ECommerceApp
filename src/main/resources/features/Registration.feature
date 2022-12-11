Feature: User could register with valid data

  Background:
    Given user opens browser and navigates to test site
    And user navigate to registration site

    # Test Scenario 1
    Scenario: user can register with required fields only
      When user enters first name
      And user enters last name
      And user enters email
      And user enters password
      And user confirms password
      And user clicks on register button

      Then redirects to result page
      And success message appears
      And continue button appears
      And log out link appears
      And user click continue button
      And user go to home page

    # Test Scenario 2
    Scenario: user can register with all fields
      When user selects gender
      And user enters first name
      And user enters last name
      And user selects date of birth
      And user enters email
      And user enters company name
      And user selects newsletter checkbox
      And user enters password
      And user confirms password
      And user clicks on register button

      Then redirects to result page
      And success message appears
      And continue button appears
      And log out link appears
      And user click continue button
      And user go to home page