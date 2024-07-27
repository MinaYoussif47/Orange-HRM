Feature: OrangHRM_Users

  Scenario: Add and Delete User
    Given I am on the OrangeHRM login page
    When I log in with username and password
    Then I should be logged in
    When I navigate to the Admin tab
    Then I get the number of records
    When I log in with username Admin and password admin123
    Then I search for the username
    When I delete the user and reset the list
    And The number of records should decrease by 1
    Then Quit the browser