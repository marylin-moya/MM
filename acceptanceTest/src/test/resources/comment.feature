Feature: Comment
  Test Author, Title and Body Text is retrieved

  @SmokeTest
  Scenario Outline: Author, Title and Body Text is retrieved
    Given I navigate to Blog site page
    When I found "<Author>" in Blog page
    Then "<Title>" and "<Body Text>" are displayed

    Examples:
      | Author  |  Title      | Body Text   |
      | Bob     |  First Blog | Hello World |
