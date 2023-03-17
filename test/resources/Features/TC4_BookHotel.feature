@BookHotel
Feature: Verify Adactin Book Hotel details

  Scenario Outline: Verifying Adactin Hotel login and Book Hotel by select all fields
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

    Examples: 
      | userName | password  | location | hotels         | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | billingAddress |
      | anbu2102 | Anbu@2102 | Adelaide | Hotel Sunshine | Double   | 1 - One       | 08/01/2023  | 09/01/2023   | 1 - One       | 1 - One         | Anbu      | M        | Rasipuram      |

  Scenario Outline: Verifying Adactin Hotel login and Book Hotel without enter any fields
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello anbu2102!"
    And User is to Search hotel details "<location>","<hotels>","<roomType>","<numberOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search success message "Select Hotel"
    And User should select the hotel
    Then User should verify the after continue success message "Book A Hotel"
    And User should book hotel without enter any fields
    Then User should verify after Booking error message "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName | password  | location | hotels         | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | anbu2102 | Anbu@2102 | Adelaide | Hotel Sunshine | Double   | 1 - One       | 08/01/2023  | 09/01/2023   | 1 - One       | 1 - One         |
