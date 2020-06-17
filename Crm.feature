Feature: Create contact

Scenario: Create contact using Crm

Given Go to https://demo.1crmcloud.com/
Then Give username as admin and password as admin
And Choose theme as Claro Theme
Then Go to Sales and Marketting and click Sales Home
Then Click Create contact
And Select Title and type First name, Last Name, Email and Phone Numbers
And Select Lead Source as Public Relations and Business Roles
Then Fill the Primary Address, City, State, Country and Postal Code and click Save
Then Click create in Leads
And Fill First & Last name, Status as In Process, Title as Manager and Department as Sales
Then Select Lead as Public Relations and fill department, Email and Phone Number
And Click Save and View
Then Mouse over on Today's Activities and click Meetings
And Type Subject as Project Status Status as Planned and Time as tomorrow 3 p.m
And Click Add paricipants, add your created Lead name and click Save
Then Click contacts under Sales and Marketting, search the lead Name and click the name from the result
And Check weather the Meeting is assigned to the contact.
