package pageobjects;

import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.annotations.Attribute;
import com.vaadin.testbench.elementsbase.Element;

@Element("div")
@Attribute(name = "class", contains = "v-gridlayout")
@Attribute(name = "class", contains = "v-layout")
public class loginElement extends TestBenchElement {

    public TestBenchElement getUsername() {
        return $("input").id("username");
    }

    public TestBenchElement getPassword() {
        return $("input").id("password");
    }

    public TestBenchElement getEnter() {
        return $("div").id("loginBtn");
    }

    public void login(String username, String password){

        $("input").id("username").sendKeys(username);
        $("input").id("password").sendKeys(password);
        $("div").id("loginBtn").doubleClick();



    }

}