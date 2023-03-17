package com.manager;

import com.pages.BookHotelPage;
import com.pages.BookingConfirmPage;
import com.pages.CancelBookingPage;
import com.pages.LoginPage;
import com.pages.SearchHotelPage;
import com.pages.SelectHotelPage;
/**
 * @see To used PageObjectManager class
 * @author kaviy
 *
 */
public class PageObjectManager {

	private LoginPage loginPage;
	private SearchHotelPage searchHotelPage;
	private SelectHotelPage selectHotelPage;
	private BookHotelPage bookHotelPage;
	private BookingConfirmPage bookConfirmPage;
	private CancelBookingPage cancelBookingPage;

/**
 * @see To enter  login page
 * @return
 */
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}
/**
 * @see To search hotel page
 * @return
 */
	public SearchHotelPage getSearchHotelPage() {
		return (searchHotelPage == null) ? searchHotelPage = new SearchHotelPage() : searchHotelPage;
	}
/**
 * @see To select hotel page
 * @return
 */
	public SelectHotelPage getSelectHotelPage() {
		return (selectHotelPage == null) ? selectHotelPage = new SelectHotelPage() : selectHotelPage;
	}
/**
 * @see To book a hotel page
 * @return
 */
	public BookHotelPage getBookHotel() {
		return (bookHotelPage == null) ? bookHotelPage = new BookHotelPage() : bookHotelPage;
	}
/**
 * @see To book hotel in Booking confirm page
 * @return
 */
	public BookingConfirmPage getBookConfirmPage() {
		return (bookConfirmPage == null) ? bookConfirmPage=new BookingConfirmPage(): bookConfirmPage;
	}
/**
 * @see to cancel booking in cancelbooing page
 * @return
 */
	public CancelBookingPage getCancelBookingPage() {
		return (cancelBookingPage==null)? cancelBookingPage=new CancelBookingPage(): cancelBookingPage;
	}

}
