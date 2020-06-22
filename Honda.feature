Feature: Compare two vehicles in Honda site

Scenario: compare two vehicles specification in honda site

Given Go to https://www.honda2wheelersindia.com/
Then Click on scooters and click dio
And Click on Specifications and mouseover on Engine
And Put all the details as key and value into Map
Then Go to Scooters and click Activa 125
And Put All its Engine Specification into another Map same as like dio
Then Compare Dio and Activa Maps and print the different values of the samekeys.
Then Click FAQ from Menu and Click dio under Browse By Product
Then Click  Vehicle Price and Select scooter, Dio BS-VI from the dropdown and click submit
Then click the price link,  Go to the new Window and select the state, city
And Print the price and model 
And Click Product Enquiry and Fill all the * field except Mobile, check the terms and conditions box and click submit
Then Verify the error message under the mobile number field.

