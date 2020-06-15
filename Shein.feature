Feature: Validating the selewcted product in Shein

Scenario: Select a product and validating the product as per the given condition

Given open https://www.shein.in/ 
Then Mouseover on Clothing and click Jeans 
Then Choose Black under Jeans product count 
And check size as medium 
#And Click + in color 
Then check whether the color is black 
And Click first item to Add to Bag  
And Click the size as M and click Submit 
Then Click view Bag  
And Check the size is Medium or not
Then Close browser