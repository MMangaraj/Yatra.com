# Calculate Trip Cost_Hackathon

## Problem Statement : Calculate Trip Cost
- Display Hotel name, total amount for first 3 hotels for 4 people in any location for 5 days of stay from tomorrow's date; Should have sorted the list with highest User rating, show hotels with free WiFi, free breakfast and amenities with laundry and swimming pool.

- Pick any one cruise line 
                - Retrieve all the Inclusion points and Display the same
                
- Go to gift voucher and scroll to corporate queries and fill it with invalid email and phone number.
	- capture error message and display the same.

## Key Automation Scope
- Handling different browser windows, search option
- Validation of date controls
- Capture warning message
- Extract list items & store in collections
- Scrolling down in web page

## WebSite Used
- https://www.yatra.com/

## Tools/Software's Used:
- Selenium – Portable Framework for testing Web Applications and automating the process.
- Java –  High level Programming Language.
- Eclipse – Integrated Development Environment for various ‘Languages’.
- TestNG – Open source testing framework.
- Cucumber - A software tool used by the testers to develop test cases for the testing of behavior of the software.
- Maven – Software and project Management Tool.
- POM – Object repository design pattern.
- Jenkins – An open source automation server for continuous integration.
- Selenium Grid – Tool use to distribute test to run test in parallel on multiple machine or browser.
- GIT – A distributed version-control system for tracking changes in any set of files for better co-ordination

## Output 
```
@smoke @regression
Scenario: Display Hotels Name                                             FeatureFiles/TC_01_HotelSearch.feature:
clicked on hotels
Given User click on Hotel Navbar
stepDefinition.StepsforHotelSearch.user_click_on_hotel_navbar
Pune is selected
When User Enter the Hotel Loaction                              stepDefinition.StepsforHotelSearch.user_enter_the_hotel_loaction
Check-in Date : 2024-04-18
Check-out Date : 2024-04-22
checkout date selected
Then User pickup the checkout date after five days from tomorrow's date stepDefinition.StepsforHotelSearch.user_pickup_the_checkout_date_after_five_days_from_tomorrow_s_date
clicked on traveller drop down
2 traveller added
And User add four People                                             stepDefinition.StepsforHotelSearch.user_add_four_people
clicked on search button
And User Click on Search buttton                                       stepDefinition.StepsforHotelSearch.user_click_on_search_buttton
clicked on user rating
Then User Click on the user rating                                   stepDefinition.StepsforHotelSearch.user_click_on_the_user_rating
And User Click on all amenities                                       stepDefinition.StepsforHotelSearch.user_click_on_all_amenities()
Hotel Name : Marriott Suites Pune
Price : ₹86,700
Hotel Name : Radisson Blu Hinjawadi Pune
Price : ₹12,27,500
Hotel Name : O Hotel Pune
Price : ₹1,24,996
Then Display the top hotels from the hotel list
stepDefinition.StepsforHotelSearch.display_the_top_hotels_from_the_hotel_list(java.lang.Integer)

@regression
Scenario: Pick one Cruise Line                           
FeatureFiles/TC_02_CruisePage.feature:

Given User is mouse over on the +more in the navbar menu
stepDefinition.StepsforCruisePage.user_is_mouse_over_on_the_more_in_the_navbar_menu()
User select the curise on the list
stepDefinition.StepsforCruisePage.user_select_the_curise_on_the_list()
Then User Click on the one Cruise Line
stepDefinition.StepsforCruisePage.user_click_on_the_one_cruise_line()
INCLUSION
2 Nights Cruise Accommodation
Meals (as specified in the itinerary)
Onboard Entertainment & Activities.(Some onboard activities and entertainment are chargeable)
Then Display the all Inclusion Point of the cruise
stepDefinition.StepsforCruisePage.display_the_all_inclusion_point_of_the_cruise()

@regression
Scenario: Capture the Error Message and Display           
FeatureFiles/TC_03_GiftPage.feature:
Given User is mouse over on the +more icon in the NavBar
stepDefinition.StepsforGiftPage.user_is_mouse_over_on_the_more_icon_in_the_nav_bar()
  When User is click on the Gift Voucher                 stepDefinition.StepsforGiftPage.user_is_click_on_the_gift_voucher()
  Then User navigate to the Gift Voucher page              stepDefinition.StepsforGiftPage.user_navigate_to_the_gift_voucher_page()
  Then User Scroll to corporate queries                   stepDefinition.StepsforGiftPage.user_scroll_to_corporate_queries()
Email error message : Please enter your valid email id
  And User fill the Deatils                                 stepDefinition.StepsforGiftPage.user_fill_the_deatils()
Phone number error message : Please enter mobile number
  Then Display the Error Message                           stepDefinition.StepsforGiftPage.display_the_error_message()
PASSED: io.cucumber.testng.AbstractTestNGCucumberTests.runScenario("Display Hotels Name", "Display Hotels Name")
        Runs Cucumber Scenarios
PASSED: io.cucumber.testng.AbstractTestNGCucumberTests.runScenario("Capture the Error Message and Display", "Verify the Email id and phone Number")
        Runs Cucumber Scenarios
PASSED: io.cucumber.testng.AbstractTestNGCucumberTests.runScenario("Pick one Cruise Line", "Pick one Cruise line and Retrieve all the Inclusion points")
        Runs Cucumber Scenarios

===============================================
    Default test
    Tests run: 1, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 3, Passes: 3, Failures: 0, Skips: 0
===============================================
```

