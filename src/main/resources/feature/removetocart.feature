Feature: Add to cart

  Background:
    Given I am logged in with username as 'standard_user' and password as 'secret_sauce'

    And I add a product to the cart

  Scenario:

    When I remove a product from the cart

    Then the cart shows no items