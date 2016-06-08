Feature: Red Dwarf Service
  As a consumer of hilarious comedy
  I want to see Red Dwarf info
  So I can source more laughs

  @wip
  Scenario: Synopsis information
    Given I query the bbc for information about Red Dwarf
    When I look at the programme overview
    Then I can see the title
    And I can see the short synopsis