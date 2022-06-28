package StepDefinition;

import Pages.OrangeLoginPage;
import io.cucumber.datatable.DataTable;
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
import java.util.List;

public class lab08 {

    protected WebDriver driver;
    protected OrangeLoginPage olp;

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

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Given("I open my application")
    public void iOpenMyApplication() {
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    }

    @And("I login with following credentials")
    public void iLoginWithFollowingCredentials(DataTable userCred) {
        List<String> signUpForm = userCred.transpose().asList(String.class);
        String usr = signUpForm.get(0);
        String psw = signUpForm.get(1);
        olp.login(usr,psw);
    }

    @And("Validate landing Page Title")
    public void validateLandingPage(DataTable tittle) {
        List<String> titlePage = tittle.transpose().asList(String.class);
        String title = titlePage.get(0);
        Assert.assertEquals(driver.getTitle(), title);
    }

    Integer mul, num1, num2, num3 = 0;

    @Given("a list of numbers")
    public void aListOfNumbers(DataTable listNum) {
        System.out.println("Initiating process described...");
        List<String> numbers = listNum.asList(String.class);
        num1 = Integer.valueOf(numbers.get(0));
        num2 = Integer.valueOf(numbers.get(1));
        num3 = Integer.valueOf(numbers.get(2));
    }

    @When("I Multiply them")
    public void iMultiplyThem() {
        mul = num1 * num2 * num3;
        System.out.println("Result of the process: " + mul.toString());
    }

    @Then("should I get 120")
    public void shouldIGet120() {
        Assert.assertEquals(mul, 120);
    }

}
