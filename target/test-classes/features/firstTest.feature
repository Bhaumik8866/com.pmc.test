
Feature: Demo feature

  Scenario: This is test only
    Given I am at login page
    When I enter valid userid and password
    Then It allows me to login

  Scenario: This is HashMap Test
    Given I am at google page
    When I search for google in search
    Then Get all aifferent elements present on result page