
Feature:


Scenario:Retrieve weather of tomorrow's  for Nottingham
    Given the user is a MetaWeather client
    When the user looks up the weather for "Nottingham" and date of "tomorrow"
    Then the endpoint should return status code 200
    And the payload data should reflect the date of "tomorrow"


  Scenario Outline: Retrieve weather data from <location> for the date of <date>
    Given the user is a MetaWeather client
    When the user looks up the weather for "<location>" and date of "<date>"
    Then the endpoint should return status code 200
    And the content type should be "application/json"
    And the payload data should reflect the date of "<date>"
    And the payload "id" should not be null

    Examples:
      | location   | date       |
      | Nottingham | tomorrow   |
      | Nottingham | today      |
      | Leeds      | yesterday  |
      | London     | 2021/07/24 |
      | London     | 2019/12/31 |
      | Manchester | 2020/05/15 |
      | Manchester | 2017/07/17 |
      | Oxford     | 2016/06/01 |
      | York       | 2021/05/18 |
      | Cardiff    | 2013/08/15 |


    Scenario Outline: Negative scenario/bug
      Given the user is a MetaWeather client
      When the user looks up the weather for "<location>" and date of "<date>"
      Then the endpoint should return status code 404
      Examples:
        | location   | date       |
        | Nottingham | 2022/06/04 |
        | Nottingham | 2008/03/16 |
        | Leeds      | 2013/12/12 |
        | London     | 2021/08/29 |



      Scenario Outline: Negative scenario
        Given the user is a MetaWeather client
        When the user looks up the weather for "<location>" and date of "<date>"
        Then the endpoint should return status code 404
        Examples:
          | location   | date       |
          | 0          | today      |
          | 2222222222 | tomorrow   |