import com.vaadin.testbench.Parameters;
import com.vaadin.testbench.ScreenshotOnFailureRule;
import com.vaadin.testbench.TestBenchTestCase;
import org.apache.log4j.BasicConfigurator;
import org.junit.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.loginElement;
import org.apache.log4j.Logger;

public class loginIT extends TestBenchTestCase {

    private final static Logger logger = Logger.getLogger(loginIT.class);
    private final String URL = "https://community.iriusrisk.com/#!login/";
    private final String USERNAME = "javierpulidovergara@gmail.com";
    private final String PASSWORD = "Testvaadin123";

    @Before
    public void setUp(){

        //We set up the basic configuration for log4j
        BasicConfigurator.configure();
        Parameters.setScreenshotErrorDirectory("src/test/resources/screenshots");
        logger.info("setUp method started");

        //Adding chrome webdriver to system configuration
        System.setProperty("webdriver.chrome.driver","webdriver/windows/googlechrome/64bit/chromedriver.exe");
        logger.info("Chrome WebDriver loaded");

        //Opening a connection with Google Chrome
        setDriver(new ChromeDriver());
        logger.info("GoogleChrome standalone is now running");

        // Open the application
        getDriver().get(URL);
        logger.info("Driving browser to: " + URL);
        logger.info("Setup method ended");
    }

    @Test
    public void doLogIn(){
        logger.info("doLogin method started");

        try{

            //We initialize the div that holds the log in form
            loginElement loginView = $(loginElement.class).first();

            logger.info("Trying to log in");
            loginView.login(USERNAME, PASSWORD);

            try
            {
                //We make sure the log in has been successful by checking if an element of the next screen is displayed
                Assert.assertTrue($("div").id("PRODUCTS_TAB_NEW_PRODUCT_BUTTON").isDisplayed());
                logger.info("Log in performed succesfully");


            }catch(AssertionError e){

                logger.error("An error ocurred while trying to log into the application \n", e);

            }

        }catch(NoSuchElementException e){

            logger.error("An error ocurred trying to locate any of the provided elements", e);

        }

        logger.info("doLogin method ended");

    }

    //If there has been any problem executing the test a screenshot will be taken
    @Rule
    public ScreenshotOnFailureRule screenshotOnFailureRule =
            new ScreenshotOnFailureRule(this, true);

    //We destroy the connection and the instance of Google Chrome
    @After
    public void destroy(){
        getDriver().close();
    }
}