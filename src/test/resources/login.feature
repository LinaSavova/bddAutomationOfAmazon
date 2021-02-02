Feature: Use Prime membership
      As a customer,
      I want to have access to Prime section
      so that I can learn about the benefits of Prime membership in Amazon

  @regression
  Scenario: Go to Prime section
      Given the user is on Home page
      When he logs in with valid credentials "lina_svetoslavova@abv.bg" and "1234567890"
      Then ensure the user's name "Lina" is displayed