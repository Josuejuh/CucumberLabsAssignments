Feature: Second Scenario
  Background: I am logged into Orange Application
    Given When I am in OrangeHRP Application
    Then Login to Application
  Scenario: Scenario 02 OrangeHRP App
    Given When I click on Admin Link
    Then Click on Job
    And Validate text Job Title