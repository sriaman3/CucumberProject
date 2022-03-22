Feature: Login Page feature
	
  Scenario: Login Page Title
    Given user is on Login page
    When user gets the title of the page
    Then page title should be "Login - My Store"

  Scenario: forgot password link
    Given user is on Login page
    Then forgot password link should displayed
    
  Scenario: Login with credentials
    Given user is on Login page
    When user enters username "sriaman3@gmail.com"
    And user enter password "123456"
    And user clicks on login button
    Then page title should be "My account - My Store"
   