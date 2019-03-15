JBehave story - View the product details

Narrative:
As a user
I want to view my product
So that I can know my product details
					 
Scenario:  get the product by id
Given url is to get the product
When send get request with <product_id>
Then response status of viewing product is 200
And product will be get as response

Examples:     
|product_id|
|4|