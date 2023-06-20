@All
Feature: Login

    @Test1 @Positive
    Scenario: Login
      Given User Login
      When User Input username and password
      And User Click login button
      Then User Logged in

    @Test2 @Negative
    Scenario: Login with wrong pass
      Given User Login
      When User Input username and wrong password
      And User Click login button
      Then User Get Error Msg