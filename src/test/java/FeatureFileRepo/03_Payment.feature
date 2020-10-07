@feature
Feature: Verify the payment gateway cases.

@assignment
	Scenario: Verify the payment gateway
		When user leads to payment gateway page
		Then choose the payment method as Credit/Debit Cards
		And enter a invalid card number as "0000111100001111"
		Then verify error message is displayed on the screen.	