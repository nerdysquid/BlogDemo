Feature: Google Search

Scenario: Search for infostretch site in google
	Given User is on Google Search Page
	When User enters search text
	Then Search List is displayed
	When user selects the infostretch site
	Then user is navigated to infostretch home page
