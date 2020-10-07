#Author: kavitha.kuttan@ust-global.com

@feature
Feature: Login to makemytrip website
  This feature checks the proper login to makemytrip website

  @assignment
  Scenario: Log on to makemytrip from personal account
    Given user launches the makemytrip url in chrome browser
    And verify the home page loaded successfully.
    When user opt to login to the site with email "kavithakuttan2014@gmail.com"
    And continue with providing password "kavitha@15"
    And Click Login button
    Then verified the user logged to the website.
   
