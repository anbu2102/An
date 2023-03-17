@SelectHotel
Feature: Verify Adactin Select Hotel details

  Scenario Outline: Verifying Adactin Hotel login and to Select Hotel Name
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello anbu2102!"
    And User is to Search hotel details "<location>","<hotels>","<roomType>","<numberOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search success message "Select Hotel"
    And User should select the hotel
    Then User should verify the after continue success message "Book A Hotel"

    Examples: 
      | userName | password  | location | hotels         | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | anbu2102 | Anbu@2102 | Adelaide | Hotel Sunshine | Double   | 1 - One       | 07/01/2023  | 08/01/2023   | 1 - One       | 1 - One         |

  Scenario Outline: Verifying Adactin Hotel login and search hotel without select hotel
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello anbu2102!"
    And User is to Search hotel details "<location>","<hotels>","<roomType>","<numberOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search success message "Select Hotel"
    And User should click continue
    Then User should verify after continue error message "Please Select a Hotel"

    Examples: 
      | userName | password  | location | hotels         | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | anbu2102 | Anbu@2102 | Adelaide | Hotel Sunshine | Double   | 1 - One       | 07/01/2023  | 08/01/2023   | 1 - One       | 1 - One         |
