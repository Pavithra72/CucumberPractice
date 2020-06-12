Feature: Shop shoes with shopclues 

Scenario: Shopping shoes with Shopclue.com

Given Go to https://www.shopclues.com/
Then Mouseover on women and click Casual Shoes
And Select Color as Black
When Check whether the product name contains the word black
Then If so, add the product name and price in to Map
When Check Display the count of shoes which are more than 500 rupees
Then Click the highest price of the shoe
And Get the current page URL and check with the product ID
And Copy the offercode 
Then Select size, color and click ADD TO CART
Then Mouse over on Shopping cart and click View Cart 
And Type Pincode as 600016 click Submit and Place Order
And Close the Browser
