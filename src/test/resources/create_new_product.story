JBehave story - Create new product

Narrative:
As a user
I want to create a product
So that I can store the new product details
					 
Scenario:  create new product
Given url is to create new product api
And product name: <product_name>, description: <product_description> and price: <price>
When send post request
Then response status for creation of new product is 200
And new product is created successfully with product name: <product_name>, description: <product_description> and price: <price>

Examples:     
|product_name|product_description|price|
|HP Laptop|Core i5|750.60|
|Dell Laptop|Core i7|660.50|