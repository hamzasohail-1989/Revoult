@Revoult2
Feature: Search String and Verify the Search Result
	Scenario Outline: Search String and Verify the Search Result
	Given Open browser and enter url
	Then Click on Help in Menu
	Then Click on Community Sub Menu
	Then Verify "<Shortcut>" "<ExpectatedResult>"
	Examples:
	|Shortcut	|ExpectatedResult 						|
	|Latest		|https://community.revolut.com/latest	|
	|Home		|https://community.revolut.com/			|
	