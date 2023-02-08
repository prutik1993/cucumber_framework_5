@Wiki
Feature: Validate Wikipedia Search

  Background:
    Given user navigates to "https://www.wikipedia.org/"

  Scenario Outline: Validate first heading
    Given user navigates to "https://www.wikipedia.org/"
    When user searches for "<name>" on Wikipedia
    Then user should see "<name>" in the title
    And user should see "<name>" in the url
    And user should see "<name>" in the first heading
    Examples:
    |name|
    |Elon Musk|
    |Johnny Depp|
    |Madonna|
    |Lana Del Rey|
@WikiLanguages
  Scenario: Validate Wikipedia main languages
    Then user should see below languages around the logo
      | English | Русский | 日本語 | Deutsch | Français | Español | Italiano | 中文 | فارسی | Polski |