Feature: Change currency
      As a customer,
      I want to be able to change the currency
      so that it best suits my preferences

  @regression
  Scenario: Change currency to Euro
      Given the user is on Home page
      When he changes the currency to Euro
      And he goes to Books section
      And he searches for "Harry Potter and the Cursed Child"
      Then verify that the price from here on have "EUR" label

  @regression
  Scenario: Change currency to US Dollar
    Given the user is on Home page
    When he changes the currency to USD
    And he goes to Books section
    And he searches for "Harry Potter and the Cursed Child"
    Then verify that the price from here on have "USD" label

  @regression
  Scenario: Change currency to Bulgaria Lev
    Given the user is on Home page
    When he changes the currency to BGN
    And he goes to Books section
    And he searches for "Harry Potter and the Cursed Child"
    Then verify that the price from here on have "BGN" label

  @bla
  Scenario: Change currency from bottom button
    Given the user is on Home page
    When he scrolls down
    And he taps the "GBP - Pounds" button
    And he changes the currency to Euro
    And he goes to Books section
    And he searches for "Harry Potter and the Cursed Child"
    Then verify that the price from here on have "EUR" label