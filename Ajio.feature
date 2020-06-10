Feature: Shop on Ajio.com
Background:
Given launch the Chrome Browser
And Disable notification
And launch the url https://www.ajio.com/shop/women
And maximise browser
And set the implicit timeout


Scenario: Successfully perform shopping on Ajio

Given Mouseover on Women, CATEGORIES and click on Kurtas
And Click on Brands and choose Ajio
Then Check all the results are Ajio
Then Set Sort by the result as Discount
And Select the first product
And Select the Color and click ADD TO BAG
Then Verify the error message Select your size to know your estimated delivery date
Then Select size and click ADD TO BAG
Then click on Enter pin-code to know estimated delivery date
And Enter the pincode as 603103 and click Confirm pincode
And Print the message and click Go to  Bag
Then Click on Proceed to Shipping and close the browser
