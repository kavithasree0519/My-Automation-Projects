package com.makemytrip.StepDefinition;

import com.makemytrip.PageObjects.PaymentPageObjects;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Payment
{
	PaymentPageObjects pObj = new PaymentPageObjects();
	@When("user leads to payment gateway page")
	public void user_leads_to_payment_gateway_page() throws InterruptedException 
	{
		pObj.pageLoaded();
	
	}

	@Then("choose the payment method as Credit\\/Debit Cards")
	public void choose_the_payment_method_as_credit_debit_cards() 
	{
		pObj.cardPaymentSelection();
	}

	@Then("enter a invalid card number as {string}")
	public void enter_a_invalid_card_number_as(String cardNumber) 
	{
	    pObj.enterCardNumber(cardNumber);
	}

	@Then("verify error message is displayed on the screen.")
	public void verify_error_message_is_displayed_on_the_screen()
	{
	   pObj.verifyFailedPayment();
	}
}
