Feature: Column verify
 @db
Scenario: verify users' table columns
When Execute query to get all columns
Then verify the below columns are listed in the result
  | id            |
  | full_name     |
  | email         |
  | password      |
  | user_group_id |
  | image         |
  | extra_data    |
  | status        |
  | is_admin      |
  | start_date    |
  | end_date      |
  | address       |