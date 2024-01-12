package commons;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest {
	private WebDriver driver;

	private String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("firefox")) {
			// System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			driver = new FirefoxDriver();
			// } else if (browserName.equals("h_firefox")) {
			// // System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			// FirefoxOptions options = new FirefoxOptions();
			// options.addArguments("--headless");
			// options.addArguments("window-size=1920x1080");
			// driver = WebDriverManager.firefoxdriver().capabilities(options).create();
		} else if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
			// } else if (browserName.equals("h_chrome")) {
			// // System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
			// ChromeOptions options = new ChromeOptions();
			// options.addArguments("--headless");
			// options.addArguments("window-size=1920x1080");
			// driver = WebDriverManager.chromedriver().capabilities(options).create();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
			// } else if (browserName.equals("ie")) {
			// WebDriverManager.iedriver().arch32().setup();
			// driver = new InternetExplorerDriver();
			// } else if (browserName.equals("opera")) {
			// WebDriverManager.operadriver().setup();
			// driver = new OperaDriver();
			// } else if (browserName.equals("coccoc")) {
			// WebDriverManager.chromedriver().driverVersion("93.0.4577.63").setup();
			// ChromeOptions options = new ChromeOptions();
			// options.setBinary("");
			// driver = new ChromeDriver(options);
			// } else if (browserName.equals("brave")) {
			// WebDriverManager.chromedriver().driverVersion("95.o.4638.17").setup();
			// driver = new ChromeDriver();
		} else {
			throw new RuntimeException("Browser name invalid.");
		}
		driver.manage().window().setPosition(new Point(0, 0));
		driver.get(GlobalConstants.PORTAL_TEST_URL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String environment) {
		if (browserName.equals("firefox")) {
			// System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			driver = new FirefoxDriver();
			// } else if (browserName.equals("h_firefox")) {
			// // System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			// FirefoxOptions options = new FirefoxOptions();
			// options.addArguments("--headless");
			// options.addArguments("window-size=1920x1080");
			// driver = WebDriverManager.firefoxdriver().capabilities(options).create();
		} else if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
			// } else if (browserName.equals("h_chrome")) {
			// // System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
			// ChromeOptions options = new ChromeOptions();
			// options.addArguments("--headless");
			// options.addArguments("window-size=1920x1080");
			// driver = WebDriverManager.chromedriver().capabilities(options).create();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
			// } else if (browserName.equals("ie")) {
			// WebDriverManager.iedriver().arch32().setup();
			// driver = new InternetExplorerDriver();
			// } else if (browserName.equals("opera")) {
			// WebDriverManager.operadriver().setup();
			// driver = new OperaDriver();
			// } else if (browserName.equals("coccoc")) {
			// WebDriverManager.chromedriver().driverVersion("93.0.4577.63").setup();
			// ChromeOptions options = new ChromeOptions();
			// options.setBinary("");
			// driver = new ChromeDriver(options);
			// } else if (browserName.equals("brave")) {
			// WebDriverManager.chromedriver().driverVersion("95.o.4638.17").setup();
			// driver = new ChromeDriver();
		} else {
			throw new RuntimeException("Browser name invalid.");
		}
		driver.manage().window().maximize();
		driver.get(GlobalConstants.PORTAL_DEV_URL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		return driver;
	}

	private String getEnvironmentUrl(String environmentName) {
		String url = null;
		switch (environmentName) {
		case "DEV":
			url = GlobalConstants.PORTAL_DEV_URL;
			break;
		case "TEST":
			url = GlobalConstants.PORTAL_TEST_URL;
			break;
		}
		return url;
	}
}
