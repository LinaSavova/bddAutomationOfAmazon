Feature: Sort the searched items by different values
      As a customer,
      I want to use an option to sort the items I search for by different filters
      so that the items searched to suit best to my preferences

  @regression
  Scenario: Sort by price - Low To High
      Given the user is on Home page
      When he goes to Gift Ideas section
      And he searches for "guerlain"
      Then ensure that there is a "Sort by" filter in the upper right corner
      And the filter has a "Price: Low to High" option into it
      And the items are rearranged from low to high price when this option is selected

  @regression
  Scenario: Sort by price - High To Low
      Given the user is on Home page
      When he goes to Gift Ideas section
      And he searches for "guerlain"
      And he sorts the items displayed by "Price: High to Low"
      Then ensure that the items are rearranged from to high to low price

  @regression
  Scenario: Sort by Newest Arrivals
    Given the user is on Home page
    When he goes to Gift Ideas section
    And he searches for "guerlain"
    Then ensure that the user can change the filter to "Newest Arrivals" option

