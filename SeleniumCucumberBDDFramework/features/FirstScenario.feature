@Revoult1
Feature: Search String and Verify the Search Result
	Scenario Outline: Search String and Verify the Search Result
	Given Open browser and enter url
	Then Click on Help in Menu
	Then Click on Community Sub Menu
	Then Click on Search and Search the topic "<topic>"
	Then Verify heading of selected topic "<topic>"
	Examples:
	|topic|
	|We got a banking licence|	
	