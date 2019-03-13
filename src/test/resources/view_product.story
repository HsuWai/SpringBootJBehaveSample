JBehave story - View the product details

Narrative:
As a user
I want to view my product
So that I can know my product details
					 
Scenario:  get the product by id
Given url is to get the product with <product_id>
When send get request
Then response status of viewing product is 200
And result will be <product_name>, <product_description> and <price>

Examples:     
|product_id|product_name|product_description|price|
|2|HP Laptop|Core i5|750.60|
|3|Dell Laptop|Core i7|660.50|