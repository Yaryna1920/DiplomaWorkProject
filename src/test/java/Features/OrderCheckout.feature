Feature: User is able to make order checkout

  Scenario: Verify an unauthorized user is able to make order checkout
    Given User is at Home page
    When User searches for "За перекопом є земля" book
    And User is redirected to Book page
    And And User adds "За перекопом є земля" book to cart
    And User is redirected to Cart page
    And User fills out required fields
    And User checks the delivery method
    And User selects the delivery unit
    And User clicks on Pay order button
    Then User is redirected to Order Payment page