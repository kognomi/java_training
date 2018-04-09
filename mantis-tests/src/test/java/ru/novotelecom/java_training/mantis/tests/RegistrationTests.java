package ru.novotelecom.java_training.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.novotelecom.java_training.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testRegistration() throws IOException, MessagingException {
        long now = System.currentTimeMillis();
        String email = String.format("user%s@localhost",now);
        String login = String.format("user%s",now);
        String password = "password";
        app.registration().start(login, email);
        List<MailMessage> mailMessages = app.mail().waitForMail(2,50000);
        String  confirmationLink = findConfirmationLink(mailMessages, email);
        app.registration().finish(confirmationLink, password,"FIO");
        assertTrue(app.newSession().login(login, password));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
       MailMessage mailMessage =  mailMessages.stream().filter((m)-> m.to.equals(email)).findFirst().get();
        VerbalExpression regex= VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }


    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}
