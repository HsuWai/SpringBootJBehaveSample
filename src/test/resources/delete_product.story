JBehave story - Delete product

Narrative:
As a user
I want to delete the product
So that I can remove that product from the product list
					 
Scenario:  delete product by id
Given url is to delete the product with <product_id>
When send get request to delete
Then response status of deletion is 200

Examples:     
|product_id|
|2|
|3|