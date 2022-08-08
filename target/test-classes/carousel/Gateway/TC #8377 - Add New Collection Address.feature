Feature: TC #8377 - Add New Collection Address
  @WIP
  Scenario: TC #8377 - Add New Collection Address
    Given User is logged into Gateway using Carousel Admin credentials
    When I navigate to Address Book > Collection Address page
    And I click Add from Collection Address page
    And I add collection address for random account from following
    And I search and select address for random postcode from following
    And I enter mandatory address details
    And I save collection address
    Then The address should be saved successfully