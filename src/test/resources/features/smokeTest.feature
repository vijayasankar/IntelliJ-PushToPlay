Feature: Smoke test

  Scenario: User Lands on push To Play page successfully
    When I navigate to PushToPlay homepage
    Then I validate title and URL

  Scenario: User logs in successfully
    Given I navigate to PushToPlay homepage
    When I login successfully
    Then I should be landing in PushToPlay homepage

  Scenario: User successfully completes PushToPlay set up
    Given I am logged in already
    And I navigate to PushToPlay homepage
    When Fill all the fields and Continue
    And I enter correct verification code
    Then I should get success message
    And the details should be displayed in My Accounts page
