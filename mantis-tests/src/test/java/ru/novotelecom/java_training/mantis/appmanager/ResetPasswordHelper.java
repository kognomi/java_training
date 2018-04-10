package ru.novotelecom.java_training.mantis.appmanager;

import org.openqa.selenium.By;
import ru.novotelecom.java_training.mantis.model.UserData;

public class ResetPasswordHelper extends HelperBase {


    public ResetPasswordHelper(ApplicationManager app) {
        super(app);
    }

    public void login (String login,String password) {
        wd.get(app.getProperty("web.baseUrl"));
        type(By.id("username"),login);
        click(By.cssSelector("input[value='Войти']"));
        type(By.id("password"),password);
        click(By.cssSelector("input[value='Войти']"));
    }

    public void gotoUserPage(UserData user) {
        wd.findElement(By.cssSelector("a[href='manage_user_edit_page.php?user_id="+user.getId()+"']")).click();

    }

    public void manageUsers() {
        wd.get(app.getProperty("web.baseUrl")+"manage_user_page.php");
    }

    public void resetPassword() {
        click(By.cssSelector("input[value='Сбросить пароль']"));
    }

    public void finish(String resetLink, String password) {
        wd.get(resetLink);
        type(By.name("password"),password);
        type(By.name("password_confirm"),password);
        click(By.tagName("button"));


    }
}
