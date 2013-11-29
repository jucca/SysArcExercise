Feature: Multiplication
	In order to avoid silly mistakes
	As a math idiot
	I want to be told the multiplication of two numbers
	
Background: 
Given Calculator is started
	
Scenario: Multiplication of two numbers
Given I have entered <valueone> and <valuetwo> into the calculator and select multiplication <operation>
When I calculate
Then I should see following result: <result>

Examples:
|valueone|operation|valuetwo|result|
|10|*|2|20|
|5|*|3|16|

