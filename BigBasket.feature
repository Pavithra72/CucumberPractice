Feature: Shop with BigBasket

Scenario: Successful shopping with big basket

Given Go to https://www.bigbasket.com/  
Then mouse over on Shop by Category  
Then Go to FOODGRAINS, OIL & MASALA and RICE & RICE PRODUCTS  
And Click on BOILED & STEAM RICE  
Then Get the URL of the page and check eith with site navigation link(HOME > FOODGRAINS, OIL & MASALA> RICE & RICE PRODUCTS> BOILED & STEAM RICE)  
Then Choose the Brand as bb Royal  
And Go to Ponni Boiled Rice and select 10kg bag from Dropdown  
And Click Add button  
Then Go to search box and type Dal  
Then Add Toor/Arhar Dal two kg and set Qty two from the list  
Then click Address  
And Select Chennai as City, Alandur as Area and click Continue  
Then Mouse over on My Basket take a screen shot  
Then Click View Basket and Checkout  
And Click the close button and close the browser
