Feature: Login Action

Scenario: Successful login with valid credentials
	Given User is on Jira Home Page
	When User enters UserName and Password
	And User searches for issue
	Then Issue page gets opened

Scenario: Enter description to issue
	Given Issue page is open
	When User enters description
	And User submits description
	Then description text gets updated 

Scenario: Successful LogOut
	When User LogOut from the Application
	Then Message displayed LogOut Successfully