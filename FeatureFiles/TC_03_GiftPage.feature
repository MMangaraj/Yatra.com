Feature: Verify the Email id and phone Number

  @regression
  Scenario: Capture the Error Message and Display
    Given User is mouse over on the +more icon in the NavBar
    When User is click on the Gift Voucher
    Then User navigate to the Gift Voucher page
    Then User Scroll to corporate queries
    And User fill the Deatils
    Then Display the Error Message
