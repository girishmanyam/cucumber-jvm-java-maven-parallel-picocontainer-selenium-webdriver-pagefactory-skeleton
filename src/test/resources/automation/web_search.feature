Feature: Search the web
  As an ignorant
  In order to learn things
  I want to be able to find stuff on the web

  Scenario: Search for word beginning with A
    Given I am using Google
	When I search for apple
	Then I am shown search results for apple
