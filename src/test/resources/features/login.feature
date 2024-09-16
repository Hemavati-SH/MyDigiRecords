@MDRrun @MDRrunUS
Feature: Mobile Test Automation for login

  @login
  Scenario Outline: User perfoms login functionality
    Given User Navigate to country selection page
    Then User select country "<country>"
    Then User Navigate to Login page
    Then user enter valid credentials "<Email>" "<Password>"
    Then validate the home page

    Examples: 
      | country       | Email                     | Password |
      | india         | tanvighingankar@gmail.com | Test@123 |
      | United States | tanvighingankar@gmail.com | Test@123 |
