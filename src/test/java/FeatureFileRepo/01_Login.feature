#Author: kavitha.kuttan@ust-global.com

@feature
Feature: Login to makemytrip website
  This feature checks the proper login to makemytrip website

  @assignment
  Scenario: Log on to makemytrip from personal account
    Given user launches the makemytrip url in chrome browser
    And verify the home page loaded successfully.
    When user opt to login to the site with email "xxxxx@gmail.com"
    And continue with providing password "xxxx"
    And Click Login button
    Then verified the user logged to the website.
   
