@SignUpSuite
Feature: Mobile Test Automation for MDR

  @signUp
  Scenario Outline: User perfoms login functionality
    Given User Navigate to country selection page
    Then User select country "<country>"
    Then User Navigate to Login page
    Then user clicks on signUp
    Then User select country code and enter Phone number "<Phone Number>"
    Then User Enter firstName "<First Name>" , MiddleName "<Middle Name>" and LastName "<Last Name>"
    Then user Enter Email "<Email>"
    Then User Enter Date of Birth "<DOB>"
    Then User Enter password "<Password>" and Confirm Password "<ConfirmPassword>"
    Then User click iAgree and contine button

    Examples: 
      |country| Email                     | Password | ConfirmPassword | Phone Number | First Name | Middle Name | Last Name | DOB      |
      |india  | tanvighingankar@gmail.com | Test@123 | Test@123        |   7620765274 | pratik     | Vinayak     | Hingankar | 04071997 |
