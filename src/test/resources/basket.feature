Feature: Add an item to the basket
      As a customer,
      I want to be able to add an item to the basket and to preview it
      so that I can buy it when I want to

Feature: Change item's quantity in basket
      As a customer,
      I want to be able to change the quantity of item
      so that I can buy more of it

Feature: Remove an item from the basket
      As a customer,
      I want to be able to remove items from the basket
      so that it matches my actual preferences

      Feature: Empty Basket
      As a customer,
      I want to be able to check my Basket
      so that be sure that it is empty if no items are added

  @regression @smoke @books
  Scenario: Add a book to the basket
      Given the user is on Home page
      When he goes to Books section
      And he searches for "Harry Potter and the Cursed Child" book title
      And he taps the type "Paperback"
      And he adds the book to the basket
      Then verify that a notification is shown with the title "Added to Basket"
      And there is "1 item" in the basket

  @regression @smoke @books
  Scenario: Check the basket in Edit mode
      Given the user is on Home page
      When he goes to Books section
      And he searches for "Harry Potter and the Cursed Child" book title
      And he taps the type "Paperback"
      And he adds the book to the basket
      And he taps to edit the basket
      Then verify that the book thumbnail is shown on the list
      And the title "Harry Potter and the Cursed Child - Parts One and Two"
      And the type of print is "Paperback"
      And the price is "£4.00"
      And quantity is "1"
      And the total price is "£4.00"

  @regression @smoke @books
  Scenario: Change book's quantity
      Given the user is on Home page
      When he goes to Books section
      And he searches for "Harry Potter and the Cursed Child"
      And he taps the type "Paperback"
      And he sets the quantity to "3"
      And he adds the book to the basket
      Then verify that a notification is shown with the title "Added to Basket"
      And there is "3 items" in the basket
      And the price in notification is "£12.00"

  @regression @smoke @books
  Scenario: Remove a book from basket
      Given the user is on Home page
      When he goes to Books section
      And he searches for "Harry Potter and the Cursed Child" book title
      And he taps the type "Paperback"
      And he adds the book to the basket
      And he goes to Basket
      And he taps the Delete link
      Then ensure that "Your Amazon basket is empty" message appears

  @regression
  Scenario: Confirm empty Basket
    Given the user is on Home page
    When he goes to Basket
    Then ensure that "Your Amazon basket is empty" message appears






