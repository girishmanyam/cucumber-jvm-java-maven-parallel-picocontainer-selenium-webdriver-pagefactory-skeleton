Feature: Search the web some more to demonstrate parallel testing
  As an ignorant
  In order to learn things
  I want to be able to find stuff on the web

  Scenario: Search for word beginning with A
    Given I am using Google
	When I search for aardvark
	Then I am shown search results for aardvark

  Scenario: Search for word beginning with B
    Given I am using Google
	When I search for bear
	Then I am shown search results for bear

  Scenario: Search for word beginning with C
    Given I am using Google
	When I search for cat
	Then I am shown search results for cat

  Scenario: Search for word beginning with D
    Given I am using Google
	When I search for dog
	Then I am shown search results for dog

  Scenario: Search for word beginning with E
    Given I am using Google
	When I search for elephant
	Then I am shown search results for elephant
