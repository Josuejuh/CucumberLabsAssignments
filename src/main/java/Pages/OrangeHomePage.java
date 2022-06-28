package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHomePage {
    WebDriver driver;
    @FindBy(xpath = "//b[.='Admin']")
    public WebElement adminMenu;

    @FindBy(xpath = "//b[.='PIM']")
    public WebElement PIMMenu;
    @FindBy(id = "searchSystemUser_userName")
    WebElement searchUser;
    @FindBy(id = "searchBtn")
    WebElement searchUserBtn;
    @FindBy(linkText = "User Management")
    public WebElement sbmAdmin01;
    @FindBy(linkText = "Job")
    public WebElement sbmAdmin02;
    @FindBy(id = "menu_admin_viewJobTitleList")
    public WebElement jobTitle;
    @FindBy(xpath = "//div[@class='inner']/div[1]//fieldset[@class='panel_resizable panel-preview']")
    public WebElement dashboardMenu;

    @FindBy (css = "h1")
    public WebElement jobTittleName;


    public OrangeHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchOnAdminPanel(String search) {
        adminMenu.click();
        searchUser.sendKeys(search);
        searchUserBtn.click();

    }

}
