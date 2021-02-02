Feature: Change the country
      As a customer,
      I want to be able to change the shopping country/region
      so that I can buy items according to my location

  @regression
  Scenario: Change the country to USA
      Given the user is on Home page
      When he changes the country
      Then ensure that the user is redirected to the appropriate site