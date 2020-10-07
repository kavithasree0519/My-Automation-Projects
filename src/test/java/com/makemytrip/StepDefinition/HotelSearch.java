package com.makemytrip.StepDefinition;

import com.makemytrip.PageObjects.HomePageObjects;
import com.makemytrip.PageObjects.HotelSearchPageObjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelSearch 
{
	HotelSearchPageObjects hObj= new HotelSearchPageObjects();
	HomePageObjects homeObject = new HomePageObjects();
	@Given("Hotel menu is available in the home page")
	public void hotel_menu_is_available_in_the_home_page() 
	{
	    homeObject.presenceOfHotelMenu();
	}

	@When("User clicks on Hotel menu")
	public void user_clicks_on_hotel_menu()
	{
		homeObject.openHoteMenu();
	}

	@Then("Location , Date and Room type should be available as Search filter")
	public void location_date_and_room_type_should_be_available_as_search_filter()
	{
	    hObj.findElement();
	}

	@Then("User select the necessary details \\(Location) {string}, Date and {int} in the form.")
	public void user_select_the_necessary_details_location_date_and_in_the_form(String cityName, int date) throws Exception 
	{
	   hObj.searchHotel(cityName,date);

	}

	@Then("check for the Search result")
	public void check_for_the_search_result()
	{
	   hObj.getResultPageView();
	}
	
	@Given("Search filters are displayed in the page.")
	public void search_filters_are_displayed_in_the_page()
	{
	   hObj.getSearchFilter();
	}

	@When("user apply Locality filter as {string}")
	public void user_apply_locality_filter_as(String locality) 
	{
		hObj.applyLocalityFilter(locality);
	}

	@When("apply user rating as {string}")
	public void apply_user_rating_as(String rating) throws InterruptedException
	{
	   hObj.applyUserRating(rating);
	}

	@Then("search result should be displayed")
	public void search_result_should_be_displayed() throws InterruptedException 
	{
	    hObj.searchedResult();
	}

	@Then("select the 1st hotel and apply book now")
	public void select_the_1st_hotel_and_apply_book_now() {
	    hObj.bookHotel();
	}
	

	@Given("Review your booking is loaded to enter details")
	public void review_your_booking_is_loaded_to_enter_details() throws InterruptedException
	{
	    hObj.reviewPage();
	}
	
	@Then("enter information Title as {string} FirstName as {string} LastName as {string}")
	public void enter_information_title_as_first_name_as_last_name_as(String title, String firstName, String lastName) {
	   hObj.enterName(title,firstName,lastName);
	}
	
	@Then("EmailID as {string} and phonenumber as {string}")
	public void email_id_as_and_phonenumber_as(String mail, String phone) {
	    
		hObj.enterContactDetails(mail,phone);
	}
	
	@Then("apply Couple Code as {string} and Special Request as {string}")
	public void apply_couple_code_as_and_special_request_as(String couponCode, String request) 
	{
	  hObj.specialRequests(couponCode,request);
	}
	@Then("Proceed with Pay Now")
	public void proceed_with_pay_now() {
	    hObj.payNow();
	}
}
