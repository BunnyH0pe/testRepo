# Test
Feature: Validate google search

  Scenario: Validate google search is working
    Given browser is open
    And user is on google search page
    Then user click to accept the cookies 
    When user enters a text in google search box
    And hits Enter  
    Then user is navigated to the Search Results page