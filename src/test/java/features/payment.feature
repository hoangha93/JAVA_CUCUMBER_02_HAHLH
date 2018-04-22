Feature: Payment feature
  As an automation tester
  I want to create new customer
  So that I want to make sure payment correctly

  @payment
  Scenario Outline: Create new Customer and get NewCustomerID
    # Pre-condition
    Given I input to "uid" textbox with data "mngr128520"
    Given I input to "password" textbox with data "nYqunab"
    # Action
    When I click to "btnLogin" button
    # Verify message
    Then I verify Homepage displayed with message "Welcome To Manager's Page of Guru99 Bank"
    When I open "New Customer" page
    # Input data
    And I input to "name" textbox with data "<CustomerName>"
    And I click to "f" radiobutton
    And I input to "dob" textbox with data "<DateOfBirth>"
    And I input to "addr" textarea with data "<Address>"
    And I input to "city" textbox with data "<City>"
    And I input to "state" textbox with data "<State>"
    And I input to "pinno" textbox with data "<PIN>"
    And I input to "telephoneno" textbox with data "<Phone>"
    And I input to "emailid" textbox with random data "<Email>.@gmail.com"
    And I input to "password" textbox with data "<Password>"
    And I click to "sub" button
    Then Verify created or edited successfully with message "Customer Registered Successfully!!!"
    #-----Verify data input------#
    And I verify to "Customer Name" with data "<CustomerName>"
    And I verify to "Gender" with data "female"
    #And I verify to "Birthdate" with data "<DateOfBirth>"
    And I verify to "Address" with data "<Address>"
    And I verify to "City" with data "<City>"
    And I verify to "State" with data "<State>"
    And I verify to "Pin" with data "<PIN>"
    And I verify to "Mobile No." with data "<Phone>"
    And I verify to "Email" with random data "<Email>.@gmail.com"
    When Get CustomerID for edit customer function

    Examples: 
      | CustomerName    | Gender | DateOfBirth | Address | City      | State   | PIN    | Phone      | Email | Password |
      | Automation Test | f      | 16/10/2000  | Ha noi  | Long Bien | Da nang | 456789 | 0123654898 | auto  |   123456 |

  @payment
  Scenario Outline: Edit Customer
    Given I open "Edit Customer" page
    And Input CustomerID
    And I click to "AccSubmit" button
    #-----Input data------#
    And I input to "addr" textarea with data "<Address>"
    And I input to "city" textbox with data "<City>"
    And I input to "state" textbox with data "<State>"
    And I click to "sub" button
    #-----Verify data input------#
    Then Verify created or edited successfully with message "Customer details updated Successfully!!!"
    And I verify to "Address" with data "<Address>"
    And I verify to "City" with data "<City>"
    And I verify to "State" with data "<State>"

    Examples: 
      | Address     | City    | State  |
      | 123 Address | Da nang | Cam Le |

  @payment
  Scenario: Create 2 new accounts and transfer to first account 50000 USD
    Given I open "New Account" page
    When Input CustomerID
    And I select "selaccount" dropdown list is"Current"
    And I input to "inideposit" textbox with data "50000"
    And I click to "button2" button
    Then Verify created or edited successfully with message "Account Generated Successfully!!!"
    When Get first AccountID
    Given I open "New Account" page
    When Input CustomerID
    And I select "selaccount" dropdown list is"Current"
    And I input to "inideposit" textbox with data "10000"
    And I click to "button2" button
    Then Verify created or edited successfully with message "Account Generated Successfully!!!"
    When Get second AccountID

  @payment
  Scenario Outline: Transfer to first account 5000 USD
    Given I open "Deposit" page
    When I input first Account ID
    And I transfer to "<Amount>" USD
    And I write comment is "<Description>"
    And I click to "AccSubmit" button
    Then I verify to "Amount Credited" with data "<Amount>"
    And I verify to "Description" with data "<Description>"
    And I verify to "Current Balance" with data "<Balance>"

    Examples: 
      | Amount | Description | Balance |
      |   5000 | Transfer    |   55000 |

  @payment
  Scenario Outline: Withdraw in first account 15000 USD
    Given I open "Withdrawal" page
    When I input first Account ID
    And I withdraw to "<Amount>" USD
    And I write description is "<Description>"
    And I click to "AccSubmit" button
    Then I verify to "Amount Debited" with data "<Amount>"
    And I verify to "Description" with data "<Description>"
    And I verify to "Current Balance" with data "<Balance>"

    Examples: 
      | Amount | Description | Balance |
      |  15000 | Withdraw    |   40000 |
