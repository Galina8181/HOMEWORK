# Позитивный сценарий
Feature:find a weather
Scenario:choose a weather in city
Given url 'https://www.accuweather.com'
 Then search a city 'Москва,Москва'
 # Then click on first link
 And assert that chosen city is 'Москва, Москва'

 # Негативный сценарий
Scenario: Incorrect input in search field
 Then search a city  'NULL'
 And assert that a message appears 'Результаты не найдены'