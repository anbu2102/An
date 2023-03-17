package com.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author kaviy
 * @See to stored all resuable methods
 *
 */
public class BaseClass {
	public static WebDriver driver;

	DataTable datatable;

	/**
	 * @see get cell value from excel sheet
	 * @param SheetName
	 * @param rowNum
	 * @param colmNum
	 * @return
	 * @throws IOException
	 */

	public String getcellvalue(String SheetName, int rowNum, int colmNum) throws IOException {
		String res = "";
		File file = new File("C:\\Users\\kaviy\\eclipse-workspace\\Sampleproject1\\Excel\\3B data Base 19.12.17.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colmNum);
		CellType type = cell.getCellType();
		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				res = dateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				res = String.valueOf(l);
			}
		default:
			break;
		}
		return res;
	}

	/**
	 * @see update the cell data from excel sheet
	 * @param SheetName
	 * @param rowNum
	 * @param colmNum
	 * @param olddata
	 * @param Newdata
	 * @throws IOException
	 */

	public void uptatecelldata(String SheetName, int rowNum, int colmNum, String olddata, String Newdata)
			throws IOException {
		File file = new File("C:\\Users\\kaviy\\eclipse-workspace\\Sampleproject1\\Excel\\3B data Base 19.12.17.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colmNum);
		String value = cell.getStringCellValue();
		if (value.equals(olddata)) {
			cell.setCellValue(Newdata);
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}

	/**
	 * @see write cell data from excell sheet
	 * @param SheetName
	 * @param rowNum
	 * @param colmNum
	 * @param data
	 * @throws IOException
	 */
	public void writecelldata(String SheetName, int rowNum, int colmNum, String data) throws IOException {
		File file = new File(
				"D:\\Testing Courses\\Java Course\\software for java\\eclipse-committers-oxygen-3a-win32-x86_64\\FrameWorkDaySeven&EightJunits\\Excel\\Excel.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(colmNum);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}

	/**
	 * @see get property path
	 * @return
	 */
	public static String getPropertyPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	/**
	 * @see get property file value
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getPropertyPath() + "\\Config\\Config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}

	/**
	 * @see select browser type
	 * @param browserType
	 */
	public static void getDriver(String browserType) {
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}
	}

	/**
	 * @see to element clear
	 * @param element
	 */
	public void elementClear(WebElement element) {
		element.clear();
	}

	/**
	 * @see enter url
	 * @param Url
	 */
	public static void enterappurl(String Url) {
		driver.get(Url);
	}

	/**
	 * @see To maximiize window
	 */
	public static void MaxizimizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * @see To pass the text in textbox
	 * @param element
	 * @param text
	 */
	public void ElementSendkeys(WebElement element, String text) {
		element.sendKeys(text);
	}

	/**
	 * @see To pass the text in textbox using Javascript
	 * @param element
	 * @param text
	 */
	public void ElementSentkeysJS(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].setattribute('value','" + text + "')", element);

	}

	/**
	 * @see To get the attribute value from textbox
	 * @param element
	 * @param attributeName
	 * @return
	 */
	public Object ElementgetattributebyJS(WebElement element, String attributeName) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object attributeValue = executor.executeScript("return argument[0].getattribute(attributeName)", element);
		return attributeValue;

	}

	/**
	 * @see To click element
	 * @param element
	 */
	public void elementclick(WebElement element) {
		element.click();
	}

	/**
	 * @see To get the tittle
	 * @return
	 */
	public String gettitle() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * @see To find attribute value by id
	 * @param attributevalue
	 * @return
	 */
	public WebElement findelementbyid(String attributevalue) {
		WebElement element = driver.findElement(By.id(attributevalue));
		return element;
	}

	/**
	 * @see To find attribute value by name
	 * @param attributevalue
	 * @return
	 */
	public WebElement findelementByName(String attributevalue) {
		WebElement element = driver.findElement(By.name(attributevalue));
		return element;
	}

	/**
	 * @see To find attribute value by classname
	 * @param attributevalue
	 * @return
	 */
	public WebElement findelementByClassName(String attributevalue) {
		WebElement element = driver.findElement(By.className(attributevalue));
		return element;
	}

	/**
	 * @see To close current window
	 */
	public void closewindow() {
		driver.close();
	}

	/**
	 * @see To Close Entire window
	 */
	public static void quitewindow() {
		driver.quit();
	}

	/**
	 * @see To get the text
	 * @param element
	 * @return
	 */
	public String elementGettext(WebElement element) {
		String text = element.getText();
		return text;
	}

	/**
	 * @see To get attribute value
	 * @param element
	 * @return
	 */
	public String elementgetattribute(WebElement element) {
		String attribute = element.getAttribute("Value");
		return attribute;
	}

	/**
	 * @see To get attribute name
	 * @param element
	 * @param attributeName
	 * @return
	 */
	public String elementgetattributename(WebElement element, String attributeName) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}

	/**
	 * @see To select dropdown using visible text
	 * @param element
	 * @param text
	 */
	public void selectoptionByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * @see To select dropdown using select by value
	 * @param element
	 * @param Value
	 */
	public void selectoptionByAttribute(WebElement element, String Value) {
		Select select = new Select(element);
		select.selectByValue(Value);
	}

	/**
	 * @see To selct dropdown using select by index
	 * @param element
	 * @param index
	 */
	public void selectoptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * @see To click alert
	 */
	public void clickokinalret() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	/**
	 * @see To click cancel
	 */
	public void clickcancelinalret() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	/**
	 * @see to get current url
	 * @return
	 */
	public String getcurrenturl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	/**
	 * @see To excute element using JavaScript
	 * @param element
	 */
	public void clickactionusingJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].click()", element);
	}
/**
 * @see To handle the window
 * @return
 */
	public String getParntWindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
/**
 * @see To get all window
 * @return
 */
	public Set<String> getallwindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}
/**
 * @see To switch the window
 * @param id
 */
	public void switchtochildwindow(String id) {
		WebDriver window = driver.switchTo().window(id);

	}
/**
 * @see To find value using xpath
 * @param value
 * @return
 */
	public WebElement switchtoframeById(String value) {
		WebElement element = driver.findElement(By.xpath(value));
		element.click();
		return element;
	}
/**
 * @see To find locator using by xpath
 * @param xpathvalue
 * @return
 */
	public WebElement findlocatorbyXpath(String xpathvalue) {
		WebElement element = driver.findElement(By.xpath(xpathvalue));
		return element;
	}
/**
 * @see To get all option using dropdown
 * @param element
 * @return
 */
	public List<WebElement> getalloptionfromdropdown(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		return options;
	}
/**
 * @see To get first select option using dropdown
 * @param element
 * @return
 */
	public String getfirstselectoptionindropdown(WebElement element) {
		Select s = new Select(element);
		WebElement option = s.getFirstSelectedOption();
		String text = option.getText();
		return text;
	}
/**
 * @see To verify multiple option using boolean
 * @param element
 * @return
 */
	public boolean dropdownismultiple(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		return multiple;
	}
/**
 * @see To verify whether its displayed or not using boolean
 * @param element
 * @return
 */
	public boolean verifyisdisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}
/**
 * @see To verify is it enable or not using boolean
 * @param element
 * @return
 */
	public boolean verifyisenable(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}
/**
 * @see To verify is iy select or not using boolean
 * @param element
 * @return
 */
	public boolean verifyisselected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}
/**
 * @see To deselect index by index
 * @param element
 * @param index
 */
	public void deselectbyindex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
/**
 * @see To deselect value using by value 
 * @param element
 * @param value
 */
	public void deselectbyattribute(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}
/**
 * @see To deselect by visible text
 * @param element
 * @param text
 */
	public void deselectbytext(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}
/**
 * @see To select the deselectall
 * @param element
 */
	public void deselectallvalue(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}
/**
 * @see To clear the text in text box
 * @param element
 */
	public void clearthetextbox(WebElement element) {
		element.clear();
	}
/**
 * @see To take screenshot
 * @param location
 * @throws IOException
 */
	public void takescreenshot(String location) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File f = ts.getScreenshotAs(OutputType.FILE);
		File f1 = new File(location);
		FileUtils.copyFile(f, f1);
	}
/**
 * @see To use mouseover action
 * @param element
 */
	public void mouseoversingleaction(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
/**
 * @see To perform drag and drop action
 * @param source
 * @param target
 */
	public void draganddropaction(WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}
/**
 * @see To click right click action
 * @param element
 */
	public void rightclickaction(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
/**
 * @see To use Doubleclick action
 * @param element
 */
	public void doubleclick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
/**
 * @see To find id using xpath
 * @param id
 * @param Xpathvalue
 * @return
 */
	public WebElement clickframeById(String id, String Xpathvalue) {
		driver.switchTo().frame(id);
		WebElement element = driver.findElement(By.xpath(Xpathvalue));
		element.click();
		return element;
	}
/**
 * @see To use switch window
 */
	public void switchtochidwindow() {
		String ParaWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String eachid : allWindow) {
			if (!ParaWindow.equals(eachid)) {
				driver.switchTo().window(eachid);
			}
		}
	}
/**
 * @see To get all option text using dropdown 
 * @param element
 */
	public void getalloptionastextdropdown(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement ele = options.get(i);
			String text = ele.getText();
		}
	}
/**
 * @see To get all option value using dropdown
 * @param element
 */
	public void getalloptionindropdownasvalue(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement ele : options) {
			String attribute = ele.getAttribute("value");
		}
	}
/**
 * @see To take screenshot action
 * @param element
 * @param location
 * @throws IOException
 */
	public void Takescreenshotusingelement(WebElement element, String location) throws IOException {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File f = ts.getScreenshotAs(OutputType.FILE);
		File f1 = new File(location);
		FileUtils.copyFile(f, f1);
	}
/**
 * @see To use refresh option
 */
	public void refereshthepage() {
		driver.navigate().refresh();
	}
/**
 * @see To use Implicit wait
 */
	public void implicitwait() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
/**
 * @see To used fluent wait
 * @param timeout
 * @param interval
 */
	public void fluentwait(Duration timeout, Duration interval) {
		Wait wait = new FluentWait(driver).withTimeout(timeout).pollingEvery(interval).ignoring(Exception.class);
	}
/**
 * @see To used insert value using enter key
 * @param element
 * @param value
 */
	public void InsertvalueandEnter(WebElement element, String value) {
		element.sendKeys(value, Keys.ENTER);
	}
/**
 * @see To used forward navigator
 */
	public void forwardpage() {
		driver.navigate().forward();
	}
/**
 * @see To use backward page
 */
	public void backwardpage() {
		driver.navigate().back();
	}
/**
 * @see  To use switch to alert
 * @param value
 */
	public void sendkeysusingAlert(String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}
/**
 * @see To use scroll down using java script executor
 * @param element
 * @return
 */
	public Object scrolldowntoelement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object executeScript = executor.executeScript("argument[0].scrollIntoView(true)", element);
		return executeScript;
	}
/**
 * @see To use Scorllup using java script executor
 * @param element
 */
	public void scrollUptoelement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView(false)", element);
	}
/**
 * @see  To get value fro data table
 * @param key
 * @param Value
 * @return
 */
	public String getDataTable(int key, String Value) {
		List<Map<String, String>> details = datatable.asMaps();
		Map<String, String> datas = details.get(key);
		String data = datas.get(Value);
		return data;

	}
/**
 * @see To get doubletab using enter key
 * @throws AWTException
 */
	public void doubleTapWithEnter() throws AWTException {
		Robot robot = new Robot();
		for (int i = 0; i < 2; i++) {
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
/**
 * @see To get the Project path
 * @return
 */
	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;

	}
	/**
	 * @see To take screenshot into output file
	 * @return
	 */
	public byte [] screenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] b = screenshot.getScreenshotAs(OutputType.BYTES);
		return b;
		
		
	}
}
