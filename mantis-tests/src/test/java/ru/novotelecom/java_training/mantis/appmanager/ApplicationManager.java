package ru.novotelecom.java_training.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;

    private WebDriver wd;

    private String browser;
    private RegistrationHelper registrationHelper;
    private FtpHelper ftp;
    private MailHelper mail;
    private JamesHelper james;
    private DbHelper db;
    private ResetPasswordHelper reset;


    public ApplicationManager(String browser)  {

        this.browser = browser;
        properties = new Properties();
    }


    public void init() throws IOException {

        String target = System.getProperty("target","local");

        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));

    }



    public void stop() {
        if (wd!=null) {
            wd.quit();
        }
    }

    public HttpSession newSession () {
        return new HttpSession(this);
    }


    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public RegistrationHelper registration() {
        if (registrationHelper ==null) {
            registrationHelper = new RegistrationHelper(this);
        }
        return registrationHelper;
    }

    public FtpHelper ftp() {
        if (ftp==null) {
            ftp = new FtpHelper(this);
        }
        return ftp;
    }

    public MailHelper mail() {
        if (mail==null) {
            mail = new MailHelper(this);
        }
        return mail;
    }

    public JamesHelper james() {
        if (james==null) {
            james = new JamesHelper(this);
        }
        return james;
    }

    public DbHelper db() {
        if (db==null) {
            db = new DbHelper(this);
        }
        return db;
    }
    public ResetPasswordHelper reset() {
        if (reset==null) {
            reset = new ResetPasswordHelper(this);
        }
        return reset;
    }



    public WebDriver getDriver() {

        if (wd==null) {
            if (browser.equals(BrowserType.FIREFOX)) {
                wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("/opt/firefox/firefox"));
            } else if (browser.equals(BrowserType.CHROME)) {
                wd = new ChromeDriver();
            } else if (browser.equals(BrowserType.IE)) {
                wd = new InternetExplorerDriver();
            }

            wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            wd.get(properties.getProperty("web.baseUrl"));
        }
        return wd;
    }
}
