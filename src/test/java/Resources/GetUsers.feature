Feature: Get Users endp oint verification

Scenario Outline: To create User
		Given I provide "<UserName>" and "<Email>" to create user		
		Then User should be created with "<UserName>" and "<Email>"
		Examples:
		|	UserName	|	Email	|
		|	Test1	|	Test1@api.com	|
		|Test2|Test2@api.com|
		
Scenario: To get user with id details
	Given I provide ID to getUser endpoint
	Then User details should be available in response
	
Scenario: To verify list of all users in system
	Given I hit GetUsers End point
	Then I check the response of GetUsers
	
Scenario Outline: To verify update user with user ID
	Given User update details with "<UserName>" and "<Email" on User ID
	Then User details should be updated with "<UserName>" and "<Email"
	Examples:
		|	UserName	|	Email	|
		|	Test3	|	Test3@api.com	|
		|Test4|Test4@api.com|
	
Scenario: To verify Delete User endpoint
	Given user Id to Delete end point
	Then User should be deleted with success response