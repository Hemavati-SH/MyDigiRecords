@MDRrun @MDRrunUS
Feature: MDR Mobile Test Automation for Pharmacy

  @Pharmacy
  Scenario Outline: User perfoms login functionality
    Given User Navigate to country selection page
    Then User select country "<country>"
    Then User Navigate to Login page
    Then user enter valid credentials "<Email>" "<Password>"
    Then validate the home page
    Then user select Pharmacy "<Pharmacy>" service and validate

    Examples: 
      | country       | Email                     | Password | Pharmacy |
      | india         | tanvighingankar@gmail.com | Test@123 | 1mg      |
    #  | United States | tanvighingankar@gmail.com | Test@123 | 1mg      |
