Feature: Create an API demo with basic functions

  @post
  Scenario: Post a product
    When the user POST the product to the response body
    Then valid response with status 201 appears

  @get
  Scenario: Get an existing product
    Given the user provides existing product name
    When the user make a GET request
    Then the correct product appears

  @update
  Scenario: Update an existing product
    Given the user provides details
    When the user submits update request
    Then product details updated successfully

  @delete
  Scenario: Delete an existing product
    Given the user provides id of the product
    When the user submits remove request
    Then product should be removed from successfully