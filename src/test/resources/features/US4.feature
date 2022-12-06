Feature: Book informations

  @db @ui
  Scenario: Verify book information with DB
    Given user login as a librarian
    And I navigate to "Books" page
    When I open book "Chordeiles minor"
    Then book information must match the Database
