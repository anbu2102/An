package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
/**
 * @see in search hoyel page to use baseclass
 * @author kaviy
 *
 */
public class SearchHotelPage extends BaseClass {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
/**
 * @see To find location, hotel, room type, room no., checkin date, checkout date, adukt room, children room
 */
	@FindBy(id = "location")
	private WebElement ddnLocation;

	@FindBy(id = "username_show")
	private WebElement txtWelcomeMsg;

	@FindBy(id = "hotels")
	private WebElement ddnHotels;

	@FindBy(id = "room_type")
	private WebElement ddnRoomType;

	@FindBy(id = "room_nos")
	private WebElement ddnRoomNo;

	@FindBy(id = "datepick_in")
	private WebElement txtCheckInDate;

	@FindBy(id = "datepick_out")
	private WebElement txtCheckOutDate;

	@FindBy(id = "adult_room")
	private WebElement ddnAdultPerRoom;

	@FindBy(id = "child_room")
	private WebElement ddnChildPerRoom;

	@FindBy(id = "Submit")
	private WebElement btnSearch;

	@FindBy(xpath = "//span[text() = 'Please Select a Location']")
	private WebElement searchErrorMessage;
	
	@FindBy(xpath = "//span[text()='Check-In Date shall be before than Check-Out Date']")
	private WebElement checkinDateErrormessage;
	
	@FindBy(xpath = "//span[text()='Check-Out Date shall be after than Check-In Date']")
	private WebElement checkoutDateErrormessage;
	

	public WebElement getCheckinDateErrormessage() {
		return checkinDateErrormessage;
	}

	public WebElement getCheckoutDateErrormessage() {
		return checkoutDateErrormessage;
	}

	public WebElement getSearchErrorMessage() {
		return searchErrorMessage;
	}

	public WebElement getDdnLocation() {
		return ddnLocation;
	}

	public WebElement getTxtWelcomeMsg() {
		return txtWelcomeMsg;
	}

	public WebElement getDdnHotels() {
		return ddnHotels;
	}

	public WebElement getDdnRoomType() {
		return ddnRoomType;
	}

	public WebElement getDdnRoomNo() {
		return ddnRoomNo;
	}

	public WebElement getTxtCheckInDate() {
		return txtCheckInDate;
	}

	public WebElement getTxtCheckOutDate() {
		return txtCheckOutDate;
	}

	public WebElement getDdnAdultPerRoom() {
		return ddnAdultPerRoom;
	}

	public WebElement getDdnChildPerRoom() {
		return ddnChildPerRoom;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public void searchHotelCommonStep(String location, String noofrooms, String checkinDate, String checkoutDate,
			String adultsperroom) {

		selectoptionByText(getDdnLocation(), location);
		selectoptionByText(getDdnRoomNo(), noofrooms);
		elementClear(getTxtCheckInDate());
		ElementSendkeys(getTxtCheckInDate(), checkinDate);
		elementClear(getTxtCheckOutDate());
		ElementSendkeys(getTxtCheckOutDate(), checkoutDate);
		selectoptionByText(getDdnAdultPerRoom(), adultsperroom);
	}

	public void searchHotel(String location, String hotel, String roomtype, String noofrooms, String checkinDate,
			String checkoutDate, String adultsperroom, String childperroom) {
		selectoptionByText(getDdnHotels(), hotel);
		selectoptionByText(getDdnRoomType(), roomtype);
		selectoptionByText(getDdnChildPerRoom(), childperroom);
		searchHotelCommonStep(location, noofrooms, checkinDate, checkoutDate, adultsperroom);
		elementclick(getBtnSearch());
	}
	public void searchHotel(String location, String noofrooms, String checkinDate, String checkoutDate,
			String adultsperroom) {
		searchHotelCommonStep(location, noofrooms, checkinDate, checkoutDate, adultsperroom);
		elementclick(getBtnSearch());
	}

	public void searchHotel() {
		elementclick(getBtnSearch());

	}

}
