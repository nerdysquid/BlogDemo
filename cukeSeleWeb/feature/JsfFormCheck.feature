Feature: CustomerRegistrationForm

Scenario: Register customer
	Given User is on register customer Page
	When User enters John as customer name
	And User enters Wall Street as customer address
	And submit the form
	Then form is submitted successfully
	
Scenario: Verify registered customer details
	When user is on register customer page
	Then A row with new customer is added
	And value in the name column is cust_name
	And value in Address column is cust_addr
	And user is navigated to login page
