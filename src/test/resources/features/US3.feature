Feature: Book categories
@db @ui
Scenario: verify book categories with DB
Given user login as a librarian
When I navigate to "Books" page
And I take all book categories in UI
And I execute query to get book categories
Then verify book categories must match book_categories table from db