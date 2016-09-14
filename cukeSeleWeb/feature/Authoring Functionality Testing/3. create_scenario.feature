Feature: Login Action

Scenario: Successful login with valid credentials
	Given User is on Jira Home Page
	When User enters UserName and Password
	Then User is logged in