Feature: Login Tests

Scenario: User login with valid credentials
  Given User lands on OPSdash Login page
  When User logged in with "valid" credentials
  Then User should land on home page
  Then Close Browser tabs

Scenario: User login with invalid credentials
  Given User lands on OPSdash Login page
  When User logged in with "invalid" credentials
  Then Error message should display
  Then Close Browser tabs
  