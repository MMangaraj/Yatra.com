Feature: Display Hotels Name
  
  As a User
  I want to see Top 3 Hotels of the particular loaction
  so i am now in the HomePage of Yatra.com

  @smoke @regression
  Scenario: Display Hotels Name
    Given User click on Hotel Navbar
    When User Enter the Hotel Loaction
    Then User pickup the checkout date after five days from tomorrow's date
    And User add four People
    And User Click on Search buttton
    Then User Click on the user rating
    And User Click on all amenities
    Then Display the top 3 hotels from the hotel list
