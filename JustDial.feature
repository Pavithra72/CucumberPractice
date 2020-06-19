Feature: Book Airline Tickets to Canada

Scenario: Book airline tickets to canada through JustDial

Given Go to https://www.justdial.com/
Then Click on Air Tickets
And Type Chennai and choose Chennai, IN - Chennai Airport (MAA) as Leaving From 
And Type Toronto and select Toronto, CA - Toronto City Centre Airport (YTZ) as Going To
Then Set Departure as 2020, July 22
And Add Adult 2, Children 1 click and Search
Then Select Air Canada from multi-airline itineraries
And Click on Price to sort the result
And Click on +Details of first result under Price
Then Capture the Flight Arrival times.
And Capture the total price in a list and Click on Book
And Capture the Airport name base on the list of time
And Capture the total fare and print the difference amount from previous total price