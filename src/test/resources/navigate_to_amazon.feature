Feature: Navigate to amazon.co.uk
      As a potential customer,
      I want to be able to go to https://www.amazon.co.uk/
      so that I can see the products offered

  @regression @smoke
  Scenario: Home page is loaded
      Given a Chrome browser is set up
      When user enters amazon.co.uk into the address bar
      Then ensure the right page is loaded