Feature: Division
	In order to avoid silly mistakes
	As a math idiot
	I want to be told the division of two numbers
	
Background: 
	Given Calculator is started
	
Scenario: Division of two numbers

Given I have entered <valueone> and <valuetwo> into the calculator and select division <operation>
When I calculate
Then I should see following result: <result>
		
Scenario: Division by zero

Given I have entered <valueone> and <valuetwo> into the calculator and select division <operation>
Then I should not be able to calculate

Examples:
|valueone|operation|valuetwo|result|
|10|%|2|5|
|5|%|0|2|

