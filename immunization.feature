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
    Then user add Immunization details "<Immunization Name>" "<Dose Number>" 
    When the user selects a date "<Immunization date>"
    Then user select time and location "<Location>" 

    Examples: 
      | country       | Email                     | Password | Immunization Name | Dose Number |Immunization date |  Service      | Location | 
    #  | india         | rahul@mydigirecords.com | Test@123 | UsCovid 199       |           2 | 15/10/2024     |     Immunization | Amravati | 
          | United States | jhon@gmail.com | Testing@88 | Immunization2024        |           1 |        01/11/2024 |   Immunization | Gadag | 

      