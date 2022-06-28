package StepDefinition;

import Pages.OrangeHomePage;
import Pages.OrangeLoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class scenarios {

    protected WebDriver driver;
    protected OrangeLoginPage olp;
    protected OrangeHomePage ohp;

    @Before
    public void setUp() throws Exception {
        String browser = System.getProperty("browser", "chrome");

        if (browser.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.contains("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.contains("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        olp = new OrangeLoginPage(driver);
        ohp = new OrangeHomePage(driver);

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    @Given("When I am in OrangeHRP Application")
    public void whenIAmInOrangeHRPApplication() {
    driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    }

    @Then("Login to Application")
    public void loginToApplication() {
        olp.login("Admin","admin123");
    }

    @When("Dashboard page is available")
    public void dashboardPageIsAvailable() {
        Assert.assertTrue(ohp.dashboardMenu.isDisplayed());
    }

    @And("click on Admin menu")
    public void clickOnAdminMenu() {
        ohp.adminMenu.click();
    }

    @Given("When I click on Admin Link")
    public void whenIClickOnAdminLink() {
        ohp.adminMenu.click();
    }

    @Then("Click on Job")
    public void clickOnJob() {
        ohp.sbmAdmin02.click();
    }

    @And("Validate text Job Title")
    public void validateTextJobTitle() {
        ohp.jobTitle.click();
        Assert.assertEquals(ohp.jobTittleName.getText(),"Job Titles");
    }
}
