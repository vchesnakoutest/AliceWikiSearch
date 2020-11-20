Feature: Wikipedia search
  Scenario: Search wiki page for ALICE
    Given Keyword for search is "ALICE company"
    When User does search
    Then Wiki page "ALICE (company)" is on the first page
  Scenario: Search wiki page for Google
    Given Keyword for search is "Google Company"
    When User does search
    Then Wiki page "Google" is on the first page
  Scenario: Search wiki page for Apple
    Given Keyword for search is "Apple Company"
    When User does search
    Then Wiki page "Apple" is on the first page
    
    