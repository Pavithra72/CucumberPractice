Feature: Buy contact lenses

Scenario: Buy contact lense through Lenskart

Given Go to https://www.lenskart.com/ 
Then Mouseover on Contact Lenses  
Then Click on Monthly under Explore By Disposability 
And Select brand as Aqualens 
And Click on the first product 
And Click Buy Now 
Then Select No of boxes as 2 and Power as -1 for both eyes
And Type your name in User's name  
And And click Save and continue 
Then Print total amount and click Proceed to Checkout