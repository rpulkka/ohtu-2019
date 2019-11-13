package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }
    
    @When("nonexisting username {string} and password {string} are given")
    public void nonexistingUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    } 
    
    @When("username {string} and password {string} are given")
    public void usernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }   
    
    @Then("system will respond {string}")
    public void systemWillRespond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }
    
    //Sign up
    
    @Given("command new user is selected")
    public void commandNewUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
    }
    
    @Given("user with username {string} with password {string} is successfully created")
    public void userWithUsernameWithPasswordIsSuccessfullyCreated(String username, String password) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
        signUpWith(username, password, password);
        assertTrue(driver.getPageSource().contains("Welcome to Ohtu Application!"));
        WebElement element2 = driver.findElement(By.linkText("continue to application mainpage"));
        element2.click();
        WebElement element3 = driver.findElement(By.linkText("logout"));
        element3.click();
        assertTrue(driver.getPageSource().contains("Ohtu App"));
    }
    
    @Given("user with username {string} and password {string} is tried to be created")
    public void userWithUsernameWithPasswordIsTriedToBeCreated(String username, String password) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
        signUpWith(username, password, password);
        WebElement element2 = driver.findElement(By.linkText("back to home"));
        element2.click();
        assertTrue(driver.getPageSource().contains("Ohtu App"));
    }
    
    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void aValidUsernameAndPasswordAndMatchingPassWordConfirmationAreEntered(String username, String password) {
        signUpWith(username, password, password);
    }
    
    @When("too short username {string} and password {string} and matching password confirmation are entered")
    public void anInvalidUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(String username, String password) {
        signUpWith(username, password, password);
    }
    
    @When("a valid username {string} and a too short password {string} and matching password confirmation are entered")
    public void aValidUsernameAndATooShortPasswordAndMatchingPasswordConfirmationAreEntered(String username, String password) {
        signUpWith(username, password, password);
    }
    
    @When("a valid username {string} and a valid password {string} and an invalid confirmation {string} are entered")
    public void aValidUsernameAndAValidPasswordAndAnInvalidConfirmationAreEntered(String username, String password, String confirmation) {
        signUpWith(username, password, confirmation);
    }
    
    @When("recently signed up username {string} and password {string} are given")
    public void recentlySignedUpUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }
    
    @Then("a new user is created")
    public void aNewUserIsCreated() {
        assertTrue(driver.getPageSource().contains("Welcome to Ohtu Application!"));
    }
    
    @Then("user is not created and error that username should have at least 3 characters is reported")
    public void userIsNotCreatedAndErrorThatUsernameShouldHaveAtLeast3CharactersIsReported() {
        assertTrue(driver.getPageSource().contains("username should have at least 3 characters"));
    }
    
    @Then("user is not created and error that password should have at least 8 characters is reported")
    public void userIsNotCreatedAndErrorThatPasswordShouldHaveAtLeast8CharactersIsReported() {
        assertTrue(driver.getPageSource().contains("password should have at least 8 characters"));
    }
    
    @Then("user is not created and error that password and password confirmation do not match is reported")
    public void userIsNotCreatedAndErrorThatPasswordAndPasswordConfirmationDoNotMatchIsReported() {
        assertTrue(driver.getPageSource().contains("password and password confirmation do not match"));
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    }
    
    private void signUpWith(String username, String password, String confirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(confirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();  
    }
}
