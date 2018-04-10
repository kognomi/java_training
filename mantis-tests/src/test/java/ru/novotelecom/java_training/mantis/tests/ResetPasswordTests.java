package ru.novotelecom.java_training.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.novotelecom.java_training.mantis.model.MailMessage;
import ru.novotelecom.java_training.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResetPasswordTests extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testResetPassword () throws IOException, MessagingException {

        String adminLogin =  app.getProperty("web.adminLogin");
        String adminPassword =  app.getProperty("web.adminPassword");
        UserData user = app.db().users().iterator().next();
        String userNewPassword ="pass";

        app.reset().login(adminLogin,adminPassword);
        app.reset().manageUsers();
        app.reset().gotoUserPage(user);
        app.reset().resetPassword();



        String mail=user.getEmail();
        List<MailMessage> mailMessages = app.mail().waitForMail(1,70000);

        String  resetLink = findResetLink(mailMessages, user.getEmail());
        app.reset().finish(resetLink, userNewPassword);
        assertTrue(app.newSession().login(user.getUsername(), userNewPassword));

    }

    private String findResetLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage =  mailMessages.stream().filter((m)-> m.to.equals(email)).findFirst().get();
        VerbalExpression regex= VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}
