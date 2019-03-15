JBehave story - Edit the product

Narrative:
As a user
I want to edit the product 
So that I can update the product information
					 
Scenario:  edit the product by valid id 
Given url is to edit the product
When send put request with product_id <product_id>, product name: <product_name>, description: <product_description> and price: <price>
Then response status for editing product is 200
And the product will be updated with product name: <product_name>, description: <product_description> and price: <price>

Examples:     
|product_id|product_name|product_description|price|
|4|HP Mouse|Wireless Mouse|750.60|