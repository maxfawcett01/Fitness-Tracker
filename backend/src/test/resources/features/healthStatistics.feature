Feature: Health Statistics API

  Scenario: Retrieve Health Statistics
    Given the Health Statistics API is available
    When I make a GET request to the endpoint "/stats"
    Then the response status code should be 200