Feature: Bot for the Klavogonki website

  Background: I am on the home page of the website "https://klavogonki.ru/"
    Given Open the desired page by pressing the button "Быстрый старт"

  Scenario: The bot starts the game and enters the words itself
    When Starting the game
    And Waiting for the game to start
    And Enter the highlighted word in the loop
    Then Fix that the game is over and there are more characters per minute than 1000