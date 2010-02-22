package de.randi2.ui;

import static de.randi2.ui.util.ComponentFinder.findAnchorById;
import static de.randi2.ui.util.ComponentFinder.findElementById;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

import de.randi2.ui.util.Pages;

public class NewTrialTest extends AbstractUITest{

	
	@Test
	public void newTrialTest() throws Exception{
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_3);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        HtmlPage randi2page;
        // Trying to log in
        HtmlPage page = webClient.getPage(testData.getProperty("baseURL") + Pages.LOGIN.toString());
        HtmlForm form = page.getFormByName("loginForm");
        HtmlButton button = form.getButtonByName("submitButton");
        HtmlTextInput usernameInput = form.getInputByName("j_username");
        HtmlPasswordInput passwordInput = form.getInputByName("j_password");
        usernameInput.setValueAttribute(testData.getProperty("username"));
        passwordInput.setValueAttribute(testData.getProperty("password"));
        randi2page = button.click();
        // Checking if logged in
        assertEquals(findElementById(randi2page, "userHeader")
                .getTextContent(), testData.getProperty("name"));
        // Calling the "New Trial" UI
        findElementById(randi2page, "trialMenu").click();
        findElementById(randi2page, "create").click();
        System.out.println(findElementById(randi2page, "name").getTextContent());
	}
	
}
