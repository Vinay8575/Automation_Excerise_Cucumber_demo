Feature: Login

  @sanity
  Scenario: Verify login functionality
    Given The user clicks on signup or login link from the Homepage
    When the user enter the valid credentials
    And the user clicks on Login button
    Then the user validates the Delete Account option is getting displayed

  @regression
  Scenario Outline: verify login functionality with multiple data
    Given The user clicks on signup or login link from the Homepage
    When the user enter the valid credentials "<email>","<password>"
    And the user clicks on Login button
    Then the user validates the Delete Account option is getting displayed

    Examples: 
      | email         | password      |
      | vv1@gmail.com | vv1@gmail.com |
      | vv5@gmail.com | test@123      |
      | vv4@gmail.com | test@123      |
