package commons;

import java.io.File;

public class GlobalConstants {

	// DEV
	public static final String PORTAL_DEV_URL = "https://demo.nopcommerce.com";
	public static final String ADMIN_DEV_URL = "https://admin-demo.nopcommerce.com/login";

	// TESTING
	public static final String PORTAL_TEST_URL = "https://demo.nopcommerce.com";
	public static final String ADMIN_TEST_URL = "https://admin-demo.nopcommerce.com/login";

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	// Windows/ MAC/ Linux
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";

	// Xử lí Authentication Alert
	// Upload = AutoIT
	// Popup lên mới upload
	// Headless browser
	// Jenkins service (File cài đặt) - Headless
	// Jenkins(.war) - Bật browser

	// Database Account/ User/ Pass/ Port
	public static final String DB_DEV_URL = "192.168.1.15:9860";
	public static final String DB_DEV_USER = "automationfc";
	public static final String DB_DEV_PASS = "P@ss0rd1";

	public static final String DB_TEST_URL = "192.18.195.23:9860";
	public static final String DB_TEST_USER = "automationfc";
	public static final String DB_TEST_PASS = "P@ss0rd1";

	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 10;
	public static final long RETRY_TEST_FAIL = 3;

}
