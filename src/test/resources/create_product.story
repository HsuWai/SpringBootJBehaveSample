JBehave story - Create new product

Narrative:
As a user
I want to create a product
So that I can store the new product details

Meta:
@skip

Scenario:  create new product
Given url is to create new product api
When send post request with product name: <product_name>, description: <product_description> and price: <price>
Then response status of creation is 201(CREATED)
And new product is created successfully with product name: <product_name>, description: <product_description> and price: <price>

Examples:     
|product_name|product_description|price|
|HP Backbag|Backbag|85.40|
|HP Laptop|Core i5|750.60|