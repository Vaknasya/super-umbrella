Feature: Bot for the Klavogonki website

  Background: I am on the home page of the website
    Given Open the desired page "https://klavogonki.ru/"
    And Pressing the quickstart button
    And Closing the context menu

  Scenario: The bot starts the game and enters the words itself
    When Starting the game
    And Waiting for the game to start
    And Enter the highlighted word in the loop
    Then Fix that the game is over
    And Fix there are more characters per minute than 1000