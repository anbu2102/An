@CancelBooking
Feature: Verify Adactin Cancel Booking details

  Scenario Outline: Verifying Adactin Hotel login and cancel booking order id
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello anbu2102!"
    And User is to Search hotel details "<location>","<hotels>","<roomType>","<numberOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search success message "Select Hotel"
    And User should select the hotel
    Then User should verify the after continue success message "Book A Hotel"
    And User should enter details "<firstName>","<lastName>" and "<billingAddress>"
      | creditCardNo     | creditCardType   | expiryMonth | expiryYear | cvvNumber |
      | 6107672594496107 | VISA             | December    |       2023 |       567 |
      | 7683672532687368 | MasterCard       | November    |       2024 |       436 |
      | 8345736646376455 | American Express | May         |       2022 |       931 |
      | 5564623576254625 | Other            | February    |       2025 |       492 |
    Then User should verify after Book hotel success message "Booking Confirmation" and save the generated order id
    And User should cancel the generated order id
    Then User should verify after cancel success message "The booking has been cancelled."

    Examples: 
      | userName | password  | location | hotels         | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | billingAddress |
      | anbu2102 | Anbu@2102 | Adelaide | Hotel Sunshine | Double   | 1 - One       | 07/01/2023  | 08/01/2023   | 1 - One       | 1 - One         | Anbu      | M        | Rasipuram      |

  Scenario Outline: Verifying Adactin Hotel login to cancel existing order id
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello anbu2102!"
    And User should cancel the existing order id "<orderId>"
    Then User should verify after cancel success message "The booking has been cancelled."

    Examples: 
      | userName | password  | orderId    |
      | anbu2102 | Anbu@2102 | 7A1EU361KV |
