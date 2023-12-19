Feature: detail
  Test detail of a product

  Background:
    Given I am logged in with username as 'standard_user' and password as 'secret_sauce'

  Scenario:
    When I open the function that sorts the elements from Z to A
    Then The items update from Z to A