@MDRrun @MDRrunUS
Feature: MDR Mobile Test Automation for Prenatal Care

  @addappointment
  Scenario Outline: User perfoms add appointment for Prenatal care functionality
    Given User Navigate to country selection page
    Then User select country "<country>"
    Then User Navigate to Login page
    Then user enter valid credentials "<Email>" "<Password>"
    Then validate the home page
    Then User clicks menu and select service "<Service>"
    Then user continue for prenatal care service
    Then user add apointment "<AppointmentFor>" "<Doctor>"

    Examples: 
      | country       | Email                     | Password | Service       | AppointmentFor  | Doctor   |
     # | india         | rahul@mydigirecords.com | Test@123 | Prenatal care | Genral Check-up | Dr.batra |
      | United States | jhon@gmail.com | Testing@88 | Prenatal care | Genral Check-up | Dr.batra |

  @article
  Scenario Outline: User perfoms Article checkout for Prenatal care functionality
    Given User Navigate to country selection page
    Then User select country "<country>"
    Then User Navigate to Login page
    Then user enter valid credentials "<Email>" "<Password>"
    Then validate the home page
    Then User clicks menu and select service "<Service>"
    Then user continue for prenatal care service
    Then user checkout Article

    Examples: 
      | country       | Email                     | Password | Service       |
     # | india   | rahul@mydigirecords.com | Test@123 | Prenatal care |
      | United States |jhon@gmail.com | Testing@88 | Prenatal care |

  @addJournal
  Scenario Outline: User perfoms add Journal for Prenatal care functionality
    Given User Navigate to country selection page
    Then User select country "<country>"
    Then User Navigate to Login page
    Then user enter valid credentials "<Email>" "<Password>"
    Then validate the home page
    Then User clicks menu and select service "<Service>"
    Then user continue for prenatal care service
    Then user add todays feelings in journal "<Title>" "<Description>"

    Examples: 
      | country       | Email                     | Password | Service       | Title | Description |
    #  | india   | rahul@mydigirecords.com | Test@123 | Prenatal care | happy | happy       |
      | United States | jhon@gmail.com | Testing@88 | Prenatal care | happy | happy       |

  @PenatalcareMedicine
  Scenario Outline: User perfoms Add Medication for prenatal care functionality
    Given User Navigate to country selection page
    Then User select country "<country>"
    Then User Navigate to Login page
    Then user enter valid credentials "<Email>" "<Password>"
    Then validate the home page
    Then User clicks menu and select service "<Service>"
    Then user continue for prenatal care service
   # Then user click Medicine button
    Then user clheckout Medicine

    Examples: 
      | country       | Email                     | Password | Service       |
      #| india   | rahul@mydigirecords.com | Test@123 | Prenatal care |
      | United States | jhon@gmail.com | Testing@88 | Prenatal care |
