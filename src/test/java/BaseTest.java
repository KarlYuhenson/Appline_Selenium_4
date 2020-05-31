import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    static WebDriver driver;
    static String baseUrl;
    private static final Properties properties = TestProperties.getInstance ( ).getProperties ( );
    static WebDriverWait wait;


    @BeforeClass
    public static void setUp ( ) throws Exception {

        baseUrl = properties.getProperty ( "app.url" );
        driver.manage ( ).window ( ).maximize ( );
        driver.manage ( ).timeouts ( ).pageLoadTimeout ( 20 , TimeUnit.SECONDS );
        wait = new WebDriverWait ( driver , 20 );

        switch ( properties.getProperty ( "browser" ) ) {
            case "chrome": {
                System.setProperty ( "webdriver.chrome.driver" , properties.getProperty ( "webdriver.chrome.driver" ) );
                DesiredCapabilities capabilities = new DesiredCapabilities ( );
                capabilities.setCapability ( CapabilityType.PAGE_LOAD_STRATEGY , "eager" );
                driver = new ChromeDriver ( capabilities );
                break;
            }
            case "firefox": {
                System.setProperty ( "webdriver.gecko.driver" , properties.getProperty ( "webdriver.gecko.driver" ) );
                DesiredCapabilities capabilities = new DesiredCapabilities ( );
                capabilities.setCapability ( CapabilityType.PAGE_LOAD_STRATEGY , "eager" );
                driver = new FirefoxDriver ( capabilities );
                break;

            }
        }
    }


    @AfterClass
    public static void tearDown ( ) throws Exception {
        driver.quit ( );
    }
}

