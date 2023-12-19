Feature: logout
  Test logout from site

  Background:
    Given I am logged in with username as 'standard_user' and password as 'secret_sauce'

  Scenario:
    When I press the cart functionality
    Then I view the cart