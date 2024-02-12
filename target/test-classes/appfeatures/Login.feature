Feature: Purchase

  @Smoke
  Scenario Outline: Purchase
    Given User Navigates to Application
    Then User Navigates to purchase Screen
    And User Enters "<Size>" , "<Quantity>" , "<Name>" , "<Email>"
    And verify Prise Displayed Accordingly
    Then Continue Shopping for Customer
    Then verify order purchase is successful

    Examples:
    |Size|Quantity|Name|Email|
    |Small|10|ads|cad@gmail.com|
