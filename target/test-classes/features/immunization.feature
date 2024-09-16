@MDRrun
Feature: MDR Mobile Test Automation for Immunization

  @immunization
  Scenario Outline: User perfoms Immunization functionality
    Given User Navigate to country selection page
    Then User select country "<country>"
    Then User Navigate to Login page
    Then user enter valid credentials "<Email>" "<Password>"
    Then validate the home page
    Then User clicks menu and select service "<Service>"
    Then user add Immunization details "<Immunization Name>" "<Dose Number>" "<Immunization Date>"
    Then user select time and location "<Location>"

    Examples: 
      | country       | Email                     | Password | Immunization Name | Dose Number | Immunization Date | Service      | Location      |
      | india         | tanvighingankar@gmail.com | Test@123 | UsCovid 199       |           2 |          10222022 | Immunization | Amravati      |
      | United States | tanvighingankar@gmail.com | Test@123 | Covid 199         |           2 |          10222022 | Immunization | San Francisco |
