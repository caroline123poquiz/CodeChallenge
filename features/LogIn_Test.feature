Feature: Login Action
Scenario: Verify that user can successfully login with valid credentials
	    Given I am on Straittimes website
        When I navigate to the login page
	    And I enter valid username and password
	    And I click on the “Sign In“ button
	    Then I successfully logged in
	    And I should see the “picture/video” in the main article
	    When I click on the main article
        Then I should see the same “picture/video” in the main article 
