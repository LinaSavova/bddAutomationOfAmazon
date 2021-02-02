Feature: Search for an item
      As a customer,
      I want to be able to search for an item in the appropriate section
      so that I can easily find the right item

  @regression @smoke @books
  Scenario: Search for a book (Books section)
      Given the user is on Home page
      When he goes to Books section
      And he searches for "Harry Potter and the Cursed Child" book title
      Then ensure that the first items has the title: "Harry Potter and the Cursed Child - Parts One and Two"
      And it has a badge "Best Seller"
      And it has a type "Paperback"
      And ensure that the price is "£9.65"

  @regression @electronics
  Scenario: Search for a camera (Electronics section)
    Given the user is on Home page
    When he goes to Electronics section
    And he searches for "Blink Outdoor"
    Then ensure that the first items has the title: "Blink"
    And it contains a label "Amazon Certified:"
    And it has a Prime checkmark
    And ensure that the price of the first item is "£89.99"

  @regression @gifts
  Scenario: Search for a perfume (Gifts section)
    Given the user is on Home page
    When he goes to Gift Ideas section
    And he searches for "guerlain"
    Then ensure that the first items has the title: "Guerlain"
    And ensure that the price of the first item is "£80.56"
