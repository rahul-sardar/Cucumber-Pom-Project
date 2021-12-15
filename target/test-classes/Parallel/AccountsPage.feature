Feature: Account Page Feature

Background:
Given user has already logged in to application
|username|password|
|naveenanimation20@gmail.com|Selenium12345|

@accounts
Scenario: Accounts page title
Given user is on Accounts page
When user gets the title of the page
Then page title should be "My Account"

@accounts
Scenario: Accounts section count
Given user is on Accounts page
Then user gets accounts section
|My Account|
|My Orders|
|My Affiliate Account|
|Newsletter|
And accounts section count should be 4