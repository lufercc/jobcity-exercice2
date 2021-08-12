Feature: Dress verification

  Scenario: Add Items to the Card
    Given Open Automation Practice page
    And I hover "Printed Dress" then add to the card
    And I click on "Continue shopping" button
    And I input "Blouse" in search field
    Then I hover "Blouse" then add to the card
    And I click on "Continue shopping" button
    And I go to the Cart dropdown and select "Check Out"
    Then I expect "Printed Dress" is displayed in summary table and the availability is "In stock"
    And I expect "Blouse" is displayed in summary table and the availability is "In stock"
    And I remove "Blouse" from the summary table
    And I expect "Blouse" is no longer displayed in the summary table
    And I expect the total amount to pay is "$28.00"