@MDRrun
Feature: MDR Mobile Test Automation for Medication

  @medication
  Scenario Outline: User perfoms Add Medication functionality
    Given User Navigate to country selection page
    Then User select country "<country>"
    Then User Navigate to Login page
    Then user enter valid credentials "<Email>" "<Password>"
    Then validate the home page
    Then User clicks menu and select service "<Service>"
    Then user add Medicine "<Medicine>"
    Then user select Frequency
    Then user Validate the added "<Medicine>"

    Examples: 
      | country      | Email                     | Password | Medicine | Service    |
      | India        | tanvighingankar@gmail.com | Test@123 | D-cal    | Medication |
      | United State | tanvighingankar@gmail.com | Test@123 | D-cal    | Medication |
