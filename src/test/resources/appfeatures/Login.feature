Feature: Login to Application

  @Smoke
  Scenario: SignIN
    Given User Navigates to Application
    Then User Enters UserName "username" and Password "pwd"
    And User Clicks on Login Button
    Then Login Should be successful