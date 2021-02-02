Feature: Log in to amazon.co.uk
      As a potential customer,
      I want to be able to login to https://www.amazon.co.uk/
      so that I can use the personalised options

  @regression
  Scenario: Explore prime membership benefits
      Given the user is on Home page
      When he goes to Prime section
      And he taps to see more details
      Then verify that an additional page with detailed information is loaded
      And verify that a "Try Prime FREE - pay later" button is displayed
      And the button is usable