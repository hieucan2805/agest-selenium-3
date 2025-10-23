package agest.pages.Google;

import agest.base.element.Button;
import agest.base.element.TextInput;
import agest.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import agest.utils.ConfigReader;

// 1. Make the class extend BasePage
public class GoogleHomePage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchBox_raw; // We name it '_raw' to be clear

    @FindBy(name = "btnK")
    private WebElement searchButton_raw;
    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    // 4. Create a public 'getter' method for the custom element
    // This is the "Factory Method" within the Page Object
    public TextInput getSearchBox() {
        // This 'wraps' the raw element in our smart 'TextInput' class
        return new TextInput(this.driver, searchBox_raw);
    }

    public Button searchButton(){
        return new Button(this.driver,searchButton_raw);
    }

    // ... (You could create a getter for the button)
    // public BaseElement getSearchButton() {
    //    // Use BaseElement for simple clicks
    //    return new BaseElement(this.driver, searchButton_raw);
    // }

    // --- Page Action Methods ---

    public void navigateTo() {
        driver.get(ConfigReader.getProperty("url.google"));
    }

    /**
     * Performs a search using the smart TextInput element.
     * @param text The text to search for.
     */
    public void searchFor(String text) {
        // 5. The page logic is now clean and beautiful
        // It calls methods on its own custom elements.
        getSearchBox().sendKeys(text);
        getSearchBox().submit();

        searchButton().click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
