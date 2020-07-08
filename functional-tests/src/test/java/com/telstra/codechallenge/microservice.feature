# See
# https://github.com/intuit/karate#syntax-guide
# for how to write feature scenarios
Feature: As a developer i want to know if my spring boot application is running

  Scenario: Is the GitHub Search API uri to get the old user account details
    Given url microserviceUrl
    And path '/old-users-account'
    Given param limit = '2'
    When method GET
    Then status 200
    And match header Content-Type contains 'application/json'
    # Define the required schema
    * def accountSchema = { id : '#string', login : '#string', html_url : '#string' } }
    # The response should have an array of 12 quote objects
    And match response == '#[2] accountSchema'