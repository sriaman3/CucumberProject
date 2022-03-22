Feature: Account Page feature

Background: 
Given user has already logged in to application
|username|password|
|sriaman3@gmail.com|123456|

Scenario: Accounts Page Title
Given user is on Accounts Page
When user gets the title of the page 
Then page title should be "My account - My Store"

Scenario: Accounts Section Count
Given user is on Accounts Page
Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And account section count should be 6

