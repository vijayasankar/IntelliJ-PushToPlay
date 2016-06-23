@adhoc
Feature: To test all the scenarios when the user is logged in

   Background:
      Given I am in MyLotto Site
      And I Login as registered user
      And I navigate to PushToPlay page

      Scenario: Enabled Continue Button
         Given I am logged in
         When I navigate to PushToPlay page
         Then the continue button should be enabled

      Scenario: Add new credit card
         Given I do not have credit card to my account
         When I click Add Credit card
         Then I should be navigated to Add Credit card page

      Scenario: Select Favourites from Favourite tab
         Given I Select Favourite tab
         Then I should be able to select my favourites


