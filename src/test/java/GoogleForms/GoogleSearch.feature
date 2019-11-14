Feature: Search in Google
  Scenario Outline: Search nisum technologies in Google
    Given I click on the Google link
    And I enter keyword as "<companyname>" in search bar
    And I validate whether selected company is first option from drop down
    And I select the options from the drop down
    And I click on 1st link in search options
    Examples:
      |companyname|
      |nisum technologies|


