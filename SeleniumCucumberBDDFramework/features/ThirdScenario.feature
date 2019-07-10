@Revoult3
Feature: Change Language By selecting Flag
	Scenario Outline: Change Language By selecting Flag and Verifying the page
	Given Open browser and enter url
	Then Scroll to Page Bottom and Click UK Flag
	Then Scroll to USA Flag and Click on the Flag
	Then Verify the Page with url "<url>"
	Examples:
	|url	|
	|https://www.revolut.com/en-US/|
	