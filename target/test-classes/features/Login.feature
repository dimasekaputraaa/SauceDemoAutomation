@all
Feature: Login

    Scenario: user login Use Valid Username And Password
      Given User Open url website
      When User do Input valid username and password
      And User Click login button
      Then User success Logged in
    Scenario Outline: user login with invalid username or invalid password
      Given User Open url website
      When User Input <username> and <password>
      And User Click login button
      Then User failed Loggin with result

    Examples:
      | username | password | result |
      | standard_user | secret_sauce | passed |
      | standard_userz | secret_sauce | passed |
      | standard_user  | public_sauce | passed |
