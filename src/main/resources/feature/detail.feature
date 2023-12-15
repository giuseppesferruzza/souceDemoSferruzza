Feature: detail
  Test detail of a product

  Background:
    Given I am logged in with username as 'standard_user' and password as 'secret_sauce'
    And I land on the Product page

  Scenario:
    When I click on the title of the product

    Then I land on the detail page of the product 'Sauce Labs Backpack'