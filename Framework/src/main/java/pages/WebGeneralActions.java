package pages;
import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ie.curiositysoftware.testmodeller.TestModellerModule;
import utilities.reports.ExtentReportManager;
import utilities.testmodeller.TestModellerLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jayway.jsonpath.JsonPath;

// https://internalcsitraining.cloud.testinsights.io/app/#!/module-collection/guid/176e0e25-5856-4f07-a2a6-3e7a36b164a5
@TestModellerModule(guid = "176e0e25-5856-4f07-a2a6-3e7a36b164a5")
public class WebGeneralActions extends BasePage
{
	public WebGeneralActions (WebDriver driver)
	{
		super(driver);
	}




	
public void AcceptAlert()
    {
        try  {
            m_Driver.switchTo().alert().accept();

            passStepWithScreenshot("Accepted alert");
        }  catch (NoAlertPresentException Ex)  {
            failStep("Alert is not present");
        }
    }

public void AddADifferentCookie(String name, String value)
    {
        Cookie cookie = new Cookie(name, value);
        m_Driver.manage().addCookie(cookie);

        passStep("Cookie added to driver with name '" + name + "' and value '" + value + "'");
    }

public void AddCapability(String capabilityName, String value)
    {
        CapabilityLoader.addCapability(capabilityName, value);
    }

public void AddCookie(String name, String value)
    {
        Cookie cookie = new Cookie(name, value);
        // this is a code change
        m_Driver.manage().addCookie(cookie);

        passStep("Cookie added to driver with name '" + name + "' and value '" + value + "'");
    }

public void AssertAlertText(String text)
    {
        try  {
            String alertText = m_Driver.switchTo().alert().getText();

            if (alertText.equals(text)) {
                passStepWithScreenshot("Alert text is equal to '" + alertText + "'");
            } else {
                failStep("Expected alert text '" + text + "' found ' " + alertText + "'");

            }
        }  catch (NoAlertPresentException Ex)  {
            failStep("Alert is not present");
        }
    }

public void AlertShouldBePresent()
    {
        try  {
            m_Driver.switchTo().alert();

            passStepWithScreenshot("Alert is present");
        }  catch (NoAlertPresentException Ex)  {
            failStep("Alert is not present");
        }
    }

public void AlertShouldNotBePresent()
    {
        try  {
            m_Driver.switchTo().alert();

            failStep("Alert is present");
        }  catch (NoAlertPresentException Ex)  {
            passStepWithScreenshot("Alert is not present");
        }

    }

public void CurrentFrameShouldContain(String text)
    {
        if (m_Driver.getPageSource().contains(text)) {
            passStepWithScreenshot("Current Frame Contains '" + text + "'");
        } else {
            failStep("Current frame does not contain '" + text + "'");
        }
    }

public void CurrentFrameShouldNotContain(String text)
    {
        if (!m_Driver.getPageSource().contains(text)) {
            passStepWithScreenshot("Current frame does not contain '" + text + "'");
        } else {
            failStep("Current frame contains '" + text + "'");
        }
    }

public void CheckboxShouldBeSelected(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Checkbox Should Be Selected", "Unable to locate object: " + objectLocator);
        }

        if (elem.isSelected()) {
            passStepWithScreenshot("Checkbox with locator '" + objectLocator + "' is Selected");
        } else {
            failStep("Checkbox with locator '" + objectLocator + "' is Selected");
        }
    }

public void CheckboxShouldNotBeSelected(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("", "Unable to locate object: " + objectLocator);
        }

        if (!elem.isSelected()) {
            passStepWithScreenshot("Checkbox with locator '" + objectLocator + "' is not Selected");
        } else {
            failStep("Checkbox with locator '" + objectLocator + "' is Selected");
        }
    }

public void ClearElementText(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Clear Element Text", "Unable to locate object: " + objectLocator);
        }

        elem.clear();

        passStepWithScreenshot("Clear Element Text");
    }

public void Click(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));

        if (elem == null) {
            failStep("Click", "Click failed. Unable to locate object: " + objectLocator);
        }

        elem.click();

        passStepWithScreenshot("Click");
    }

public void ClickByText(String text)
    {
        String xPath = "//*[contains(text(), \"" + text + "\")]";
        WebElement elem = getWebElement(By.xpath(xPath));

        if (elem == null) {
            failStep("Click", "Click failed. Unable to locate object by text: " + text + " with xpath " + xPath);
        }

        elem.click();

        passStepWithScreenshot("Click");
    }

public void QuitCurrentBrowser()
    {
        if (m_Driver != null) {
            try {
                m_Driver.quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

public void ConnectSauceLabsEU(String username, String accessKey)
    {
        QuitCurrentBrowser();

        setDriver(CapabilityLoader.createSauceLabsDriver(username, accessKey, "eu"));
    }

public void ConnectSauceLabsUS(String username, String accessKey)
    {
        QuitCurrentBrowser();

        setDriver(CapabilityLoader.createSauceLabsDriver(username, accessKey, "us"));
    }

public void DeleteAllCookies()
    {
        m_Driver.manage().deleteAllCookies();

        passStep("All cookies deleted");
    }

public void DeleteCookie(String name)
    {
        m_Driver.manage().deleteCookieNamed(name);

        passStep("Cookie '" + name + "' deleted");
    }

public void DismissAlert()
    {
        try  {
            m_Driver.switchTo().alert().dismiss();

            passStepWithScreenshot("Dismissed alert");
        }  catch (NoAlertPresentException Ex)  {
            failStep("Alert is not present");
        }
    }

public void DoubleClick(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));

        if (elem == null) {
            failStep("Double Click", "Double Click failed. Unable to locate object: " + objectLocator);
        }

        Actions act = new Actions(m_Driver);
        act.doubleClick(elem).perform();

        passStepWithScreenshot("Double Click");
    }

public void DragAndDrop(String fromLocator, String targetLocator)
    {
        WebElement fromElem = getWebElement(getLocatorFromString(fromLocator));
        if (fromElem == null) {
            failStep("Drag And Drop", ". Unable to locate from object: " + fromLocator);
        }

        WebElement targetElem = getWebElement(getLocatorFromString(targetLocator));
        if (targetElem == null) {
            failStep("Drag And Drop", ". Unable to locate to object: " + targetLocator);
        }

        Actions action = new Actions(m_Driver);
        action.dragAndDrop(fromElem, targetElem).build().perform();

        passStepWithScreenshot("Drag And Drop");
    }

public void DragAndDropByOffset(String objectLocator, Integer xPos, Integer yPos)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Drag And Drop By Offset", "Unable to locate object: " + objectLocator);
        }

        Actions action = new Actions(m_Driver);
        action.dragAndDropBy(elem, xPos, yPos).build().perform();


        passStepWithScreenshot("Drag And Drop By Offset");
    }

public void ElementAttributeValueShouldBe(String objectLocator, String elementAttribute, String attributeValue)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Element Attribute Value Should Be", "Unable to locate object: " + objectLocator);
        }

        if (elem.getAttribute(elementAttribute) == null)
            failStep("Element '" + objectLocator + "' does not contain attribute '" + elementAttribute + "'");

        if (elem.getAttribute(elementAttribute).equals(attributeValue)) {
            passStepWithScreenshot("Element '" + objectLocator + "' Attribute Value '" + elementAttribute + "' Should Be '" + attributeValue + "'");
        } else {
            failStep("Element '" + objectLocator + "' Attribute Value '" + elementAttribute + "' Should Be '" + attributeValue + "'. Found '" + elem.getAttribute(elementAttribute) + "'");
        }
    }

public void ElementShouldBeDisabled(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Element Should Be Disabled", "Unable to locate object: " + objectLocator);
        }

        if (elem.isEnabled()) {
            failStep("Element '" + objectLocator + "' is enabled.");
        } else {
            passStepWithScreenshot("Element '" + objectLocator + "' is disabled.");
        }
    }

public void ElementShouldBeEnabled(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Element Should Be Enabled", "Unable to locate object: " + objectLocator);
        }

        if (elem.isEnabled()) {
            passStepWithScreenshot("Element '" + objectLocator + "' is enabled.");
        } else {
            failStep("Element '" + objectLocator + "' is disabled.");
        }

    }

public void ElementShouldBeFocused(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Element Should Be Focused", "Unable to locate object: " + objectLocator);
        }

        if (elem.isSelected()) {
            passStepWithScreenshot("Element '" + objectLocator + "' is focused.");
        } else {
            failStep("Element '" + objectLocator + "' is not focused.");
        }
    }

public void ElementShouldBeVisible(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Element Should Be Visible", "Unable to locate object: " + objectLocator);
        }

        if (elem.isDisplayed()) {
            passStepWithScreenshot("Element '" + objectLocator + "' is visible.");
        } else {
            failStep("Element '" + objectLocator + "' is not visible.");
        }
    }

public void ElementShouldContain(String objectLocator, String message)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Element Should Contain", "Unable to locate object: " + objectLocator);
        }

        if (elem.getText().contains(message)) {
            passStepWithScreenshot("Element '" + objectLocator + "' contains text '" + message + "'.");
        } else {
            failStep("Element '" + objectLocator + "' does not contain text '" + message + "'.");
        }
    }

public void ElementShouldNotBeVisible(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Element Should Not Be Visible", "Unable to locate object: " + objectLocator);
        }

        if (elem.isDisplayed()) {
            failStep("Element '" + objectLocator + "' is visible.");
        } else {
            passStepWithScreenshot("Element '" + objectLocator + "' is not visible.");
        }
    }

public void ElementShouldNotContain(String objectLocator, String message)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Element Should Not Contain", "Unable to locate object: " + objectLocator);
        }

        if (elem.getText().contains(message)) {
            failStep("Element '" + objectLocator + "' contains text '" + message + "'.");
        } else {
            passStepWithScreenshot("Element '" + objectLocator + "' does not contains text '" + message + "'.");
        }
    }

public void ElementTextShouldBe(String objectLocator, String text)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Element Text Should Be", "Unable to locate object: " + objectLocator);
        }

        if (elem.getText().equals(text)) {
            failStep("Element '" + objectLocator + "' text is '" + text + "'.");
        } else {
            passStepWithScreenshot("Element '" + objectLocator + "' text is not '" + text + "'.");
        }
    }

public void ElementTextShouldNotBe(String objectLocator, String text)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Element Text Should Not Be", "Unable to locate object: " + objectLocator);
        }

        if (elem.getText().equals(text)) {
            failStep("Element '" + objectLocator + "' text is '" + text + "'.");
        } else {
            passStepWithScreenshot("Element '" + objectLocator + "' text is not '" + text + "'.");
        }
    }

public void EnterText(String objectLocator, String text)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));

        if (elem == null) {
            failStep("EnterText", "EnterText failed. Unable to locate object: " + objectLocator);
        }

        elem.sendKeys(text);

        passStepWithScreenshot("EnterText " + text);
    }

public void ExecuteJavascript(String javaScript)
    {
        ((JavascriptExecutor)m_Driver).executeScript(javaScript);
    }

public void FrameShouldContain(String objectLocator, String text)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Frame Should Contain", "Unable to locate object: " + objectLocator);
        }

        if (elem.getText().contains(text)) {
            passStepWithScreenshot("Frame contains value '" + text + "'");
        } else {
            failStep("Frame does not contain '" + text + "'");
        }
    }

public String GetCapability(String capability)
    {
        return CapabilityLoader.getCapability(capability);
    }

public String GetElementAttribute(String objectLocator, String attribute)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Get Element Attribute", "Unable to locate object: " + objectLocator);
        }

        return elem.getAttribute(attribute);
    }

public String GetText(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Get Text", "Unable to locate object: " + objectLocator);
        }

        return elem.getText();
    }

public String GetTitle()
    {
        return m_Driver.getTitle();
    }

public String GetValue(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Get Value", "Unable to locate object: " + objectLocator);
        }

        return elem.getText();
    }

public void GoBack()
    {
        m_Driver.navigate().back();
    }

public void InputTextIntoAlert(String text)
    {
        try  {
            m_Driver.switchTo().alert().sendKeys(text);

            passStepWithScreenshot("Input text '" + text + "' into alert");
        }  catch (NoAlertPresentException Ex)  {
            failStep("Alert is not present");
        }
    }

public void MaximiseWindow()
    {
        m_Driver.manage().window().maximize();

        passStepWithScreenshot("Maximise Window");
    }

public void MouseDown(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Mouse Down", "Unable to locate object: " + objectLocator);
        }

        Actions action = new Actions(m_Driver);
        action.clickAndHold(elem);
        action.perform();

        passStepWithScreenshot("Mouse Down");
    }

public void MouseOut(String objectLocator)
    {
// TODO
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Mouse Out", "Unable to locate object: " + objectLocator);
        }

        Actions action = new Actions(m_Driver);
        action.moveToElement(elem);
        action.moveByOffset((int) (elem.getSize().getWidth() / 2.0) + 1, (int) (elem.getSize().getHeight() / 2.0) + 1);
        action.perform();

        passStepWithScreenshot("Mouse Out");

    }

public void MouseOver(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Mouse Over", "Unable to locate object: " + objectLocator);
        }

        Actions action = new Actions(m_Driver);
        action.moveToElement(elem);
        action.perform();

        passStepWithScreenshot("Mouse Over");

    }

public void MouseUp(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Mouse Up", "Unable to locate object: " + objectLocator);
        }

        Actions action = new Actions(m_Driver);
        action.release(elem);
        action.perform();

        passStepWithScreenshot("Mouse Up");
    }

public void NewWindow()
    {
        ((JavascriptExecutor) m_Driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(m_Driver.getWindowHandles());
        m_Driver.switchTo().window(tabs.get(1));

        passStepWithScreenshot("New Window");
    }

public void OpenChrome()
    {
        QuitCurrentBrowser();

        setDriver(CapabilityLoader.createChromeDriver());
    }

public void OpenContextMenu(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Open context menu", "Unable to locate object: " + objectLocator);
        }

        Actions action = new Actions(m_Driver);
        action.contextClick(elem);
        action.perform();

        passStepWithScreenshot("Open context menu");
    }

public void OpenFirefox()
    {
        QuitCurrentBrowser();

        setDriver(CapabilityLoader.createFirefoxDriver());
    }

public void OpenURL(String url)
    {
        m_Driver.get(url);

        passStepWithScreenshot("Go to URL - " + url);
    }

public void PageShouldContainElement(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Page does not contain element", "Unable to locate object: " + objectLocator);
        }

        passStepWithScreenshot("Page contains element");
    }

public void PageShouldContainText(String text)
    {
        if (m_Driver.getPageSource().contains(text)) {
            passStepWithScreenshot("Page contains text '" + text + "'");
        } else {
            failStep("Page does not contains text '" + text + "'");
        }
    }

public void PageShouldNotContainElement(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            passStepWithScreenshot("Page does not contain element '" + objectLocator + "'");
        }

        failStep("Page contains element '" + objectLocator + "'");
    }

public void PageShouldNotContainText(String text)
    {
        if (m_Driver.getPageSource().contains(text)) {
            failStep("Page does contains text '" + text + "'");
        } else {
            passStepWithScreenshot("Page does not contain text '" + text + "'");
        }
    }

public void RadioButtonShouldBeSetTo(String groupName, String value)
    {
        By radioGroup = By.xpath("//input[@type='radio' and @name='" + groupName + "']");

        List<WebElement> webElements = getWebElements(radioGroup);
        if (webElements.isEmpty()) {
            failStep("Not radio buttons found in group '" + value + "'");
        }

        Boolean found = false;
        for (WebElement elem : webElements) {
            if (elem.isSelected()) {
                if (elem.getText().equals(value)) {
                    found = true;
                }
            }
        }

        if (found) {
            passStepWithScreenshot("Radio button is set to '" + value + "'");
        } else {
            failStep("Radio button '" + value + "' is not set in the group '" + groupName + "'");
        }
    }

public void RadioButtonShouldNotBeSelected(String groupName, String value)
    {
        By radioGroup = By.xpath("//input[@type='radio' and @name='" + groupName + "']");

        List<WebElement> webElements = getWebElements(radioGroup);
        if (webElements.isEmpty()) {
            failStep("Not radio buttons found in group '" + value + "'");
        }

        Boolean found = false;
        for (WebElement elem : webElements) {
            if (elem.isSelected()) {
                if (elem.getText().equals(value)) {
                    found = true;
                }
            }
        }

        if (found) {
            failStep("Radio button '" + value + "' is set in the group '" + groupName + "'");
        } else {
            passStepWithScreenshot("Radio button is not set to '" + value + "'");
        }
    }

public void ReloadPage()
    {
        m_Driver.navigate().refresh();
    }

public void ScrollElementIntoView(String objectLocator) throws InterruptedException {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Scroll Element Into View", "Unable to locate object: " + objectLocator);
        }

        ((JavascriptExecutor) m_Driver).executeScript("arguments[0].scrollIntoView(true);", elem);
        Thread.sleep(500);

        passStepWithScreenshot("Scroll Element Into View");
    }

public void SelectAllFromList(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Select All From List", "Unable to locate object: " + objectLocator);
        }

        Select selectObject = new Select(elem);
        int index = 0;
        for (WebElement selectOptions : selectObject.getOptions()) {
            selectObject.selectByIndex(index);
            index++;
        }

        passStepWithScreenshot("Select All From List");
    }

public void SelectCheckbox(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Select Checkbox", "Unable to locate object: " + objectLocator);
        }

        if (!elem.isSelected())
            elem.click();

        passStepWithScreenshot("Select Checkbox");
    }

public void SelectFromListByIndex(String objectLocator, Integer index)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Select From List By Index", "Select From List By Index. Unable to locate object: " + objectLocator);
        }

        Select dropdown = new Select(elem);
        dropdown.selectByIndex(index);

        passStepWithScreenshot("Select From List By Index");
    }

public void SelectFromListByLabel(String objectLocator, String label)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Select From List By Label", "Select From List By Label. Unable to locate object: " + objectLocator);
        }

        Select dropdown = new Select(elem);
        dropdown.selectByVisibleText(label);

        passStepWithScreenshot("Select From List By Label");
    }

public void SelectFromListByValue(String objectLocator, String value)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Select From List By Value", "Select From List By Value. Unable to locate object: " + objectLocator);
        }

        Select dropdown = new Select(elem);
        dropdown.selectByValue(value);

        passStepWithScreenshot("Select From List By Value");
    }

public void SelectRadioButton(String groupName, String value)
    {
        By radioGroup = By.xpath("//input[@type='radio' and @name='" + groupName + "']");

        List<WebElement> webElements = getWebElements(radioGroup);
        if (webElements.isEmpty()) {
            failStep("Not radio buttons found in group '" + value + "'");
        }

        Boolean found = false;
        for (WebElement elem : webElements) {
            if (elem.getText().equals(value)) {
                elem.click();

                found = true;
            }
        }

        if (found) {
            passStepWithScreenshot("Radio button '" + value + "' selected in group '" + groupName + "'");
        } else {
            failStep("Radio button with value '" + value + "' not found in group '" + groupName + "'");
        }
    }

public void SetBrowserType(String platformName)
    {
        AddCapability("browserName", platformName);
    }

public void SetWindowSize(int width, int height)
    {
        m_Driver.manage().window().setSize(new Dimension(width, height));

        passStepWithScreenshot("Set Window Size");
    }

public void SubmitForm(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Submit Form", "Unable to locate object: " + objectLocator);
        }

        elem.submit();;

        passStepWithScreenshot("Submit Form");
    }

public void SwitchTab(int tabIndex)
    {
        ArrayList<String> tabs = new ArrayList<String>(m_Driver.getWindowHandles());
        m_Driver.switchTo().window(tabs.get(tabIndex));

        passStepWithScreenshot("Switch tab with index " + tabIndex);
    }

public void TitleShouldBe(String value)
    {
        if (m_Driver.getTitle().equals(value)) {
            passStepWithScreenshot("Title is equal to '" + value + "'");
        } else {
            failStep("Title is '" + m_Driver.getTitle() + "' expected '" + value + "'");
        }
    }

public void UnselectAllFromList(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Unselect All From List", "Unable to locate object: " + objectLocator);
        }

        Select selectObject = new Select(elem);
        selectObject.deselectAll();

        passStepWithScreenshot("Unselect All From List");
    }

public void UnselectCheckbox(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Unselect Checkbox", "Unable to locate object: " + objectLocator);
        }

        if (elem.isSelected())
           elem.click();

        passStepWithScreenshot("Unselect Checkbox");
    }

public void UnselectFromListByIndex(String objectLocator, Integer index)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Unselect From List By Index", "Unable to locate object: " + objectLocator);
        }

        Select selectObject = new Select(elem);
        selectObject.deselectByIndex(index);

        passStepWithScreenshot("Unselect from list");
    }

public void UnselectFromListByLabel(String objectLocator, String label)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Unselect From List By Label", "Unable to locate object: " + objectLocator);
        }

        Select selectObject = new Select(elem);
        selectObject.deselectByVisibleText(label);

        passStepWithScreenshot("Unselect from list");
    }

public void UnselectFromListByValue(String objectLocator, String value)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Unselect From List By Value", "Unable to locate object: " + objectLocator);
        }

        Select selectObject = new Select(elem);
        selectObject.deselectByValue(value);

        passStepWithScreenshot("Unselect from list");
    }

public void WaitUntilElementIsEnabled(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Wait Until Element Is Enabled", "Unable to locate object: " + objectLocator);
        }

        try {
            WebDriverWait wait = new WebDriverWait(m_Driver, Duration.ofSeconds(15));

            wait.until(ExpectedConditions.elementToBeClickable(elem));
        } catch (Exception e) {

        }

        passStepWithScreenshot("Wait until element is enabled");
    }

public void WaitUntilElementIsNotVisible(String objectLocator)
    {
        WebElement elem = getWebElement(getLocatorFromString(objectLocator));
        if (elem == null) {
            failStep("Wait Until Element Is Not Visible", "Unable to locate object: " + objectLocator);
        }

        try {
            WebDriverWait wait = new WebDriverWait(m_Driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.invisibilityOf(elem));
        } catch (Exception e) {

        }

        passStepWithScreenshot("Wait until element is not visible");
    }

public void WaitUntilElementIsVisible(String objectLocator)
    {
        waitForVisible(getLocatorFromString(objectLocator), 10);

        passStepWithScreenshot("Wait until element '" + objectLocator + "' is visible");
    }

public void WaitUntilPageContainsElement(String objectLocator)
    {
        waitForLoaded(getLocatorFromString(objectLocator), 10);

        passStepWithScreenshot("Wait until page contains element '" + objectLocator + "'");
    }

}