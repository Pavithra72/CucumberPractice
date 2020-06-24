Feature: Compare bikes in bikewale site

Scenario: Comparing bikes

Given Go to https://www.bikewale.com/ 
Then Go to menu and click new bikes 
Then Click New Bikes Then compare bikes 
And Add first bike as Royal Enfield and model as Thunderbird 350 
And Add second bike Jawa, model as 42 and version Dual Channel ABS - BS VI 
And Add bike brand Kawasaki model as Ninja 300 
Then click compare 
Then Find and print the maximum overall rating of all the bikes and find the max