@payment
Feature: Payment feature
  As an automation tester
  I want to create new customer
  So that I want to make sure payment correctly

  @demo
  Scenario Outline: Create new Customer
    Given I input "<Username>" and "<Password>"
    When I click to Login button
    Then I verify Homepage displayed with message "<Message>"

    Examples: Username valid
      | Username   | Password | Message                                  |
      | mngr117091 | dusUvys  | Welcome To Manager's Page of Guru99 Bank |

  @demo
  Scenario: Create new Customer and get NewCustomerID
    Given I open New Customer page
    And Input data to all fields required
      | CustomerName | Gender | DateOfBirth | Address | City    | State   | PIN    | Phone       | Email      | Password |
      | Dam Dao      | m      | 16/10/1989  | Da nang | Da nang | Da nang | 456789 | 01223456789 | automation |   123456 |
    And Click to Submit button
    Then Verify Customer created successfully with message "Customer Registered Successfully!!!"
    And Customer infomation should be shown
      | CustomerName | Birthday   | City    | Address | Phone       | Email      |
      | Dam Dao      | 16/10/1989 | Da nang | Da nang | 01223456789 | automation |
    And Get CustomerID for edit customer function


  Scenario: Edit Customer
    Given I open Edit Customer page
    When Input CustomerID
    Then Click to Submit
    And I quit browser
