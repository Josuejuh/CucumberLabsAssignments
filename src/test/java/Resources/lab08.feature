Feature: Login and List Functionality

  @Smoke
Scenario: Login to orange HR application
Given I open my application
And I login with following credentials
  | Admin | admin123 |
  Then Validate landing Page Title
    |OrangeHRM|

#  @Smoke
  Scenario: The sum of a list of numbers should be calculated
    Given a list of numbers
      | 4 |
      | 5 |
      | 6 |
    When I Multiply them
    Then should I get 120
