Feature: Navigate to item's details
      As a customer,
      I want to be able to click on a found item
      so that I can see more information about it

  @regression @smoke @books
  Scenario: Navigate to book details via photo
    Given the user is on Home page
    When he goes to Books section
    When he searches for "Harry Potter and the Cursed Child" book title
    And he taps the thumbnail of the first book that is displayed
    Then ensure that the title contains "Harry Potter and the Cursed Child - Parts One and Two"
    And verify that the "#1 Best Seller" badge is displayed
#    Because currently the default value is Kindle Edition with Audio/Video, and the price
#    is 0.00 I will set these values as expected results:
    And verify the price is "£0.00"
    And verify that the marked type is "Kindle Edition with Audio/Video"

  @regression @smoke @books
  Scenario: Navigate to book details via title
    Given the user is on Home page
    When he goes to Books section
    When he searches for "Harry Potter and the Cursed Child" book title
    And he taps the title of the first book that is displayed
    Then ensure that the title contains "Harry Potter and the Cursed Child - Parts One and Two"
    And verify that the "#1 Best Seller" badge is displayed
#    Because currently the default value is Kindle Edition with Audio/Video, and the price
#    is 0.00 I will set these values as expected results:
    And verify the price is "£0.00"
    And verify that the marked type is "Kindle Edition with Audio/Video"

  @regression @smoke @books
  Scenario: Navigate to book details via type
    Given the user is on Home page
    When he goes to Books section
    When he searches for "Harry Potter and the Cursed Child" book title
    And he taps the type "Paperback"
    Then ensure that the title contains "Harry Potter and the Cursed Child"
    And verify the price is "£9.65"
    And verify that the marked type is "Paperback"