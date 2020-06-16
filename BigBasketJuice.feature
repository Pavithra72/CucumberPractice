Feature: Select and validate juice through Big basket

Scenario: Using Big Basket selecting and validating the juice products

Given launch https://www.bigbasket.com/
Then mouse over to  Shop by Category 
And Go to Beverages and Fruit juices & Drinks
And Click on JUICES
Then click Tropicana and Real under Brand
And Check count of the products from each Brands and total count
And Check whether the products is availabe with Add button.
Then Add the First listed available product 
And click Change Address 
Then Select Chennai, Alandur as Area  and click Continue
And Mouse over on My Basket print the product name. count and price.
And Click View Basket then Checkout
And Click the close button