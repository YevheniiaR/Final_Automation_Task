Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check add product to Cart
    Given User opens '<homePage>' page
    And User clicks Fashion button
    And User click Women's Accessories button
    And User click product button
    When User clicks add to cart
    Then User checks that amount of products in cart are '<amountOfProducts>'

    Examples:
      | homePage              | amountOfProducts |
      | https://www.ebay.com/ | 1                |


  Scenario Outline: Check not available amount of products
    Given User opens '<homePage>' page
    And User clicks Fashion button
    And User click Women's Accessories button
    And User click product button
    When User type '<notAvailable>' amount
    Then User checks that '<errorMessage>' is appear

    Examples:
      | homePage              |notAvailable| errorMessage |
      | https://www.ebay.com/ |111         | Purchases are limited to  per buyer |



  Scenario Outline: Check Free shipping in cart
    Given User opens '<homePage>' page
    And User clicks Fashion button
    And User click Women's Accessories button
    And User click product button
    When User clicks add to cart
    Then User checks free shipping in cart

    Examples:
      | homePage              |
      | https://www.ebay.com/ |


  Scenario Outline: Check not to add to witchlist without sign on
    Given User opens '<homePage>' page
    And User clicks Fashion button
    And User click Women's Accessories button
    And User click product button
    When User clicks add to watchlist
    Then User checks that new page opened

    Examples:
      | homePage              |
      | https://www.ebay.com/ |


  Scenario Outline: Check URL in search
    Given User opens '<homePage>' page
    When User type '<key>' in field
    And User clicks search
    Then User checks URL contains '<searchKey>'

    Examples:
      | homePage              | key    | searchKey |
      | https://www.ebay.com/ | flower | flower    |


  Scenario Outline: Check wrong amount of products on page
    Given User opens '<homePage>' page
    And User type '<key>' in field
    And User clicks search
    Then User checks page contains more than should products

    Examples:
      | homePage              | key    |
      | https://www.ebay.com/ | flower |


  Scenario Outline: Check button with price after filter
    Given User opens '<homePage>' page
    And User type '<key>' in field
    And User clicks search
    When User clicks button with price
    Then User checks '<max>' price in filter

    Examples:
      | homePage              | key    | max |
      | https://www.ebay.com/ | flower | 5   |


  Scenario Outline: Check NOT registration without personal information
    Given User opens '<homePage>' page
    And User click registration
    When User NOT type personal information
    Then User checks that button not enabled

    Examples:
      | homePage              |
      | https://www.ebay.com/ |


  Scenario Outline: Check input email
    Given User opens '<homePage>' page
    And User click registration
    When User clicks email
    And User clicks password
    Then User see '<errorEmailMessage>'

    Examples:
      | homePage              | errorEmailMessage                |
      | https://www.ebay.com/ | Please enter your email address. |


  Scenario Outline: Check site navigation
    Given User opens '<homePage>' page
    And User clicks Fashion button
    And User click Women's Accessories button
    And User click product button
    When User clicks return to Fashion page
    Then User check page name

    Examples:
      | homePage              |
      | https://www.ebay.com/ |
