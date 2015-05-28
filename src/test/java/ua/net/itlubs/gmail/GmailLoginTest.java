package ua.net.itlubs.gmail;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static ua.net.itlubs.gmail.Config.myLoginName;
import static ua.net.itlubs.gmail.Config.myPassword;

/**
 * Created by Shykov M. on 25.05.2015.
 * Test task: GmailLogin
 */
public class GmailLoginTest {

    @Test
    public void loginToGmail() {
        open("https://www.gmail.com");
        $("#Email").setValue(myLoginName).pressEnter();
        $("#Passwd").setValue(myPassword).pressEnter();
        $(byText("COMPOSE")).waitUntil(exist, 120000).click();
        $("[class='wO nr l1']>textarea").waitUntil(exist, 60000).click();
        $("[class='wO nr l1']>textarea").setValue(myLoginName);
        $("[name='subjectbox']").click();
        $("[name='subjectbox']").setValue("test my mail");
        $("[data-tooltip='Send ‪(Ctrl-Enter)‬']").click();
        $$(".y6>span").get(0).shouldHave(exactText("test my mail"));
    }

}
