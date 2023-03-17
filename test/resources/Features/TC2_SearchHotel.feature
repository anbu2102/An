@SearchHotel
Feature: Verifying Adactin Hotel Search Hotel details

  Scenario Outline: Verifying Adactin Hotel login page and to select all fields
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello anbu2102!"
    And User is to Search hotel details "<location>","<hotels>","<roomType>","<numberOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search success message "Select Hotel"

    Examples: 
      | userName | password  | location | hotels         | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | anbu2102 | Anbu@2102 | Adelaide | Hotel Sunshine | Double   | 1 - One       | 05/01/2023  | 06/01/2023   | 1 - One       | 1 - One         |

  Scenario Outline: Verifying Adactin Hotel login and to verify mandatory fields
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello anbu2102!"
    And User should enter only Mandatory fields "<location>","<numberOfRooms>","<checkInDate>","<checkOutDate>" and "<adultsPerRoom>"
    Then User should verify after search success message "Select Hotel"

    Examples: 
      | userName | password  | location | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom |
      | anbu2102 | Anbu@2102 | Adelaide | 1 - One       | 05/01/2023  | 06/01/2023   | 1 - One       |

  Scenario Outline: Verifying Adactin Hotel login and to verify date checking is invalid
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello anbu2102!"
    And User is to Search hotel details "<location>","<hotels>","<roomType>","<numberOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotel with error message is "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName | password  | location | hotels         | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | anbu2102 | Anbu@2102 | Adelaide | Hotel Sunshine | Double   | 1 - One       | 21/01/2023  | 20/01/2023   | 1 - One       | 1 - One         |

  Scenario Outline: Verifying Adactin Hotel login and without enter any fields
    Given User is on the adactin page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello anbu2102!"
    And User should click Search button
    Then User should verify without enter any fields with error message is "Please Select a Location"

    Examples: 
      | userName | password  |
      | anbu2102 | Anbu@2102 |
