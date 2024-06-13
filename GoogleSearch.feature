Feature: Google search

  Scenario: User searches for Selenium Webdriver on Google
    Given the user is on the Google search page
    When the user searches for "Selenium Webdriver"
    Then the search results are displayed
