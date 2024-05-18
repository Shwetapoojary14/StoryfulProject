Feature: An example

  Scenario: Successful sign-up with all required fields completed
    Given on the sign-up page
    When user fills the "First Name" field with "Name"
    When user fills the "Last Name" field with "Surname"
    When user fills the "Email" field with "name.sirname"gmail.com"
    When user fills the "Password" field with "namesirname@123#"
    When user click on the both checkbox
    When user click on the "SIGN UP" button
    Then user should see a confirmation message
