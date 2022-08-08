@completed
Feature: TC #11100 - Gateway Login - Valid & Invalid Credentials

  Scenario Outline: Login to Gateway using invalid Email Id
    Given I am on Login Page
    When I login with invalid email as <email> and password as <password>
    Then I should be able to see an error message
    Examples:
      | email | password |
      | "mauli.jadeja@pmcretail123.com" | "GatewayDev@2020" |

  Scenario Outline: Login to Gateway using invalid Password
    Given I am on Login Page
    When I login with email as <email> and invalid password as <password>
    Then I should be able to see an error message
    Examples:
      | email | password |
      | "mauli.jadeja@pmcretail.com" | "GatewayDev@202011" |

  Scenario Outline: Login to Gateway using invalid Password
    Given I am on Login Page
    When I login with valid email as <email> and valid password as <password>
    Then I should be able to login successfully
    Examples:
      | email | password |
      | "mauli.jadeja@pmcretail.com" | "GatewayDev@2020" |