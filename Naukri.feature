Feature: Get company name and error message

Scenario: Get company name and error message from Naukri.com

Given Open naukri.com
Then Get the company names from each pop up window and close it
Then Now, click on the upload cv button and upload some random image.
And Get the error message printed
