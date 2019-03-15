JBehave story - Delete product

Narrative:
As a user
I want to delete the product
So that I can remove that product from the product list
	
Meta:
@skip
			 
Scenario:  delete product by id
Given url is to delete the product
When send delete request to delete with product_id <product_id>
Then response status of deletion is 200

Examples:     
|product_id|
|31|
|32|