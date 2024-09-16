Feature: MDR Mobile Test Automation for Profile

  @editProfile
  Scenario Outline: User perfoms Edit profile functionality
    Given User Navigate to country selection page
    Then User select country "<country>"
    Then User Navigate to Login page
    Then user enter valid credentials "<Email>" "<Password>"
    Then validate the home page
    Then User clicks menu and select service "<Service>"
    Then user click edit profile button
    Then user edit firstName "<First Name>"
    Then user edit Middle Name "<Middle Name>"
    Then user edit Last Name "<Last Name>"
    Then user edit date of birth "<dob>"
    Then user edit gender
    Then user edit blood group
    Then user edit Emergency contact "<sos>"
    Then user edit RelationShip "<SosconatctName>" "<relationship>"
    Then user edit Location
    Then user edit city "<city>"
    Then user user save the profile

    Examples: 
      | country       | Email                     | Password | First Name | Middle Name | Last Name | dob      | blood group | gender | Service | sos        | city     | relationship |
      #| india         | tanvighingankar@gmail.com | Test@123 | Pratik     | shyam       | surve     | 04071995 | B+          | Male   | Profile | 1234567890 | Amravati | Father       |
      | United States | tanvighingankar@gmail.com | Test@123 | Pratik     | shyam       | surve     | 04071995 | B+          | Male   | Profile | 1234567890 | Amravati | Father       |
