
Feature: Login
  Test login with different combination

  Background:
    Given I am on the login page

  Scenario Outline: Login with correct credentials

    When I enter username as '<username>' and password as '<password>'

    Then I land on the Product page
    Examples:
      | username        |  password     |
      | standard_user   | secret_sauce  |
