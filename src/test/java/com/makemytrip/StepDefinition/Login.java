package com.makemytrip.StepDefinition;

import com.makemytrip.PageObjects.LoginPageObjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

	LoginPageObjects loginObj = new LoginPageObjects();
	@Given("user launches the makemytrip url in chrome browser")
	public void user_launches_the_makemytrip_url_in_chrome_browser()
	{
	   loginObj.OpenURL();
	}

	@Given("verify the home page loaded successfully.")
	public void verify_the_home_page_loaded_successfully()
	{
	    loginObj.makemytripLogon();
	}

	@When("user opt to login to the site with email {string}")
	public void user_opt_to_login_to_the_site_with_email(String username) 
	{
		loginObj.enterMailID(username);

	}

	@When("continue with providing password {string}")
	public void continue_with_providing_password(String password)
	{
	    loginObj.enterPassword(password);
	}

	@When("Click Login button")
	public void click_login_button() 
	{
		loginObj.clickLogin();

	}

	@Then("verified the user logged to the website.")
	public void verified_the_user_logged_to_the_website() throws InterruptedException 
	{
	    loginObj.verifyUser();
	}
}
