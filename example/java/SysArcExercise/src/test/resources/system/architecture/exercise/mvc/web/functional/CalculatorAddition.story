Feature: Add
	In order to avoid silly mistakes
	As a math idiot
	I want to be told the sum of two numbers

Background: 
	Given Calculator is started

Scenario: Add two numbers

Given I have entered <valueone> and <valuetwo> into the calculator and select addition <operation>
When I calculate
Then I should see following result: <result>

Examples:
|valueone|operation|valuetwo|result|
|2|+|5|7|
|5|+|5|2|
