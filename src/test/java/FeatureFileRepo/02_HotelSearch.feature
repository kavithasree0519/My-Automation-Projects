#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@feature
Feature: Hotel Search
	User could able to search for Hotel
  @assignment
  Scenario: Verify the hotel search possible
    Given Hotel menu is available in the home page
    When User clicks on Hotel menu
    Then Location , Date and Room type should be available as Search filter
    And User select the necessary details (Location) "Cochin, Kerala", Date and 3 in the form.
    Then check for the Search result 

	@assignment
	Scenario: Verify the Search filter and Select hotel
		Given Search filters are displayed in the page.
		When user apply Locality filter as "Kakkanad"
		And apply user rating as "5 Star"
		Then  search result should be displayed
		And select the 1st hotel and apply book now
		
		
	@assignment
	Scenario: Verify Traveller Information setting
		Given Review your booking is loaded to enter details
		Then enter information Title as "Mrs" FirstName as "Nancy" LastName as "Tom"
		And EmailID as "nancytom1@gmail.com" and phonenumber as "9955555555"
		And apply Couple Code as "ASA@##$ty" and Special Request as "Twin beds"
		Then Proceed with Pay Now
		
	
		