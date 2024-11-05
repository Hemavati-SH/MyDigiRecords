@ABHA
Feature: Mobile Test Automation for MDR

  @CreateABHAAccount
  Scenario Outline: User perfoms ABHA functionality
    Given User Navigate to country selection page
    Then User select country "<country>"
    Then User Navigate to Login page
    Then user enter valid credentials "<Email>" "<Password>"
    Then validate the home page
    Then User clicks menu and select service "<Service>"
    Then user create ABHA Account using Adhar Number "<Adhar>"

    Examples: 
      |country| Email                     | Password | Service | Adhar        |
      |india  | hemavati@gmail.com | Testing@88 | ABHA    | 279646267047 |

  @CreateConsentReqest
  Scenario Outline: User perfoms ABHA functionality
    Given User Navigate to country selection page
    Then User Navigate to Login page
    Then user enter valid credentials "<Email>" "<Password>"
    Then validate the home page
    Then User clicks menu and select service "<Service>"
    Then user click create consent request
    Then user Enter Abha Address "<ABHA Address>" and click on find user
    Then User select purpose of request 
    Then user enter date of health info from and to
    Then user select health info type
    Then user enter consent expiry date 

    Examples: 
      | Email                     | Password | Service | Adhar        | ABHA Address |
      |  hemavati@gmail.com | Testing@88 | ABHA    | 996787677924 | hemavati_19882703@sbx   |

