@Login
Feature: Verifying Adactin Hotel login details

  Scenario Outline: Verifying Adactin Hotel login valid
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello anbu2102!"

    Examples: 
      | userName | password  |
      | anbu2102 | Anbu@2102 |

  Scenario Outline: Verifying Adactin Hotel login using enter
    Given User is on the adactin page
    When User should perform login "<userName>","<password>" with enter key
    Then User should verify after login success message "Hello anbu2102!"

    Examples: 
      | userName | password  |
      | anbu2102 | Anbu@2102 |
	@res
  Scenario Outline: Verifying Adactin Hotel login invalid credentials
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login with invalid credentials error message contains "Invalid Login details or Your Password might have expired."

    Examples: 
      | userName | password |
      | anbu     | anbu123  |
