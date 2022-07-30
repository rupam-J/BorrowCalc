Feature: Borrowing Power Calculator

  Scenario: Calculate how much to borrow

    Given User is at borrow calculator page
    When User enters details with below values
      | applicationType          | single |
      | dependantNum             | 0      |
      | propertyType             | home   |
      | annualIncome             | 80000  |
      | annualOtherIncome        | 10000  |
      | annualIncome2            | 0      |
      | annualOtherIncome2       | 0      |
      | monthlyLivingExpense     | 500    |
      | monthlyHomeLoanRepayment | 0      |
      | otherLoanMonthly         | 100    |
      | monthlyCommitment        | 0      |
      | totalCreditCardLimit     | 10000  |
    And User click on calculate
    Then User gets final borrow estimate

  Scenario: Clear the values by clicking on Start over

    Given User is at borrow calculator page
    When User enters details with below values
      | applicationType          | joint  |
      | dependantNum             | 0      |
      | propertyType             | home   |
      | annualIncome             | 80000  |
      | annualOtherIncome        | 10000  |
      | annualIncome2            | 0      |
      | annualOtherIncome2       | 5000   |
      | monthlyLivingExpense     | 500    |
      | monthlyHomeLoanRepayment | 0      |
      | otherLoanMonthly         | 100    |
      | monthlyCommitment        | 0      |
      | totalCreditCardLimit     | 10000  |
    And User click on calculate
    Then User gets final borrow estimate
    And User click on start over
    And All the fields are cleared

    Scenario: Error message being displayed when $1 is entered as living expenses

      Given User is at borrow calculator page
      When User enters below values
      | monthlyLivingExpense | 1 |
      And User click on calculate
      Then Error Message pops up


