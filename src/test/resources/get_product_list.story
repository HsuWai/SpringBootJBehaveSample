JBehave story - Get product list test

Narrative:
As a user
I want to retrieve all product list
So that I can review all products
					 
Scenario:  get all product list
Given url is to get all products
When send get request to get all products
Then response status for getting all products is 200
And successfully get all product list