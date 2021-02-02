Feature: Log out
      As a customer,
      I want to be able to log out from https://www.amazon.co.uk/
      so that I have a choice to stay logged in or to log out

  @regression
  Scenario: Log out from amazon.co.uk
      Given the user is on Home page
      When he logs in with valid credentials "putYourEmailHere" and "putYourPasswordHere"
      And he logs out
      Then verify Sign-In section to appear
      And amazon.co.uk if tapped leads to LogIn page
