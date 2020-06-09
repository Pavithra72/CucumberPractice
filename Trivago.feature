Feature: Reservation through Trivago
Background:
Given User launches the Chrome Browser
And Disable the notification
And Launch https://www.trivago.com/
And maximise the browser
And User set the implicit timeout


Scenario: Reserve a room in hotel in Agra through Trivago

Given Type Agra in Destination and select Agra, Uttar Pradesh.
And Choose June 15 as check in and June 30 as check out
And Select Room as Family Room
And Choose Number of Adults 2, Childern 1 and set Child's Age as 4
Then Click Confirm button and click Search
And Select Accommodation type as Hotels only and choose 4 stars
And Select Guest rating as Very Good
And Set Hotel Location as Agra Fort and click Done
Then In more Filters, select Air conditioning, Restaurant and WiFi and click Done
And Sort the result as Rating & Recommended
Then Print the Hotel name, Rating, Number of Reviews and Click View Deal
Then Print the URL of the Page
Then Print the Price of the Room and click Choose Your Room
Then Click Reserve and I'll Reserve
And Close the browser

