
Feature: Validation of values 

	Scenario Outline: Validation of values on web page
		Given User launches the "<url>"
		Then validate successful launch
		And check for the number of value fields
		Then validate the values present are nonzero
		And validate the values are passed as currencies
		And validate the sum of values passed is equal to total balance
		
		Examples:
		| url															 |
		| https://www.exercise1.com/values |
