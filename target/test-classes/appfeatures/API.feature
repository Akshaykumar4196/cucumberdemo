Feature: API Testing

  @Smoke
  Scenario: verify getOrders API is Fetching All Orders
    Given User triggers GetOrders API
    Then Verify All Records are Present in Response
  @Smoke
  Scenario: Verify CreateOrder API is Creating Order
    Given User Triggers CreateOrder API
    Then Verify Record is inserted successfully
  @Smoke
  Scenario: Verify User is able to fetch order
    Given User Triggers GetOrders API with OrderID <5>
    Then Verify Order is retrieved Successfully

  Scenario: Verify User is Able to Delete Order
    Given User Triggers DeleteOrder with OrderID
    Then Verify Order is deleted from Orders Table



