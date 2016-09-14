Feature: Create Issues

Scenario: Create Issues of all issue types
	Given User click on create issue button
	Then Create issue pop gets opened
	When User selects project
	And Select issuetypes 
	And enters summary and click on create button
	Then Issues will be created in jira