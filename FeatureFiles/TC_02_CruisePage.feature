Feature: Pick one Cruise line and Retrieve all the Inclusion points

  @regression
  Scenario: Pick one Cruise Line
    Given User is mouse over on the +more in the navbar menu
    When User select the curise on the list
    Then User Click on the one Cruise Line
    Then Display the all Inclusion Point of the cruise
