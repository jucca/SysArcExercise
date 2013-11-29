Feature: Reduce
	In order to avoid silly mistakes
	As a math idiot
	I want to be told the result of reduce of two numbers

Background: 
Given Calculator is started

Scenario: Reduce two numbers
Given I have entered <valueone> and <valuetwo> into the calculator and select reduction <operation>
When I calculate
Then I should see following result: <result>
	
Scenario: Negative result
Given I have entered <valueone> and <valuetwo> into the calculator  and select division <operation>
When I calculate
Then I should see following result: <result>

Examples:
|valueone|operation|valuetwo|result|
|10|-|2|8|
|5|-|3|3|

