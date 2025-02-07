
Feature: MDR New App Mobile Test Automation for login

@newapplogin
  Scenario Outline: User perfoms login functionality in new application
    Given User Navigate to country selection page for new app
    Then User select country "<country>" for new app
    Then User Navigate to new app Login page
    Then user enter valid credentials "<Email>" "<Password>" for new app
    Then validate the home page for new app
		#Then User clicks menu and select logout "<Logout>" from new app
		
    Examples: 
      | country       | Email                   | Password |Logout |
     # |  United States  | jhon@gmail.com | Testing@88 |Logout |
   		| India | shivan@gmail.com | Testing@888 | Logout |
