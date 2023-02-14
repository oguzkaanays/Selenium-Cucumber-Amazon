@Mobil
Feature: Mobil testleri

  @Home
  Scenario Outline: Kullanıcı olmadan giriş yapmak
    Given user should see the Login page
    When user taps to "<button>" button on the Login page
    Then user should see the Home page
    Examples:
      | button      |
      | Girişi Atla |

  @Search
  Scenario Outline: Kullanıcı olmadan arama yapmak
    Given user is on the Home page
    When user searchs to "<product>" name on the Home page
    Then user should see the Product List page
    Examples:
      | product |
      | apple   |

