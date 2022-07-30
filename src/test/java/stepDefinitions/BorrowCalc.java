package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import pages.BorrowCalcPage;

import java.io.File;
import java.time.Duration;
import java.util.Map;

public class BorrowCalc {
    WebDriver driver;
    BorrowCalcPage borrowCalcPage;


    @Given("User is at borrow calculator page")
    public void user_is_at_borrow_calculator_page() {
        String rootDir = System.getProperty("user.dir");
        String chromeDriverPath = rootDir + File.separator + "src"+File.separator+"test"+File.separator+"resources"+File.separator+"drivers"+File.separator+"chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        driver =new ChromeDriver();
        borrowCalcPage = new BorrowCalcPage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
    }

    @When("User enters details with below values")
    public void user_enters_details_with_below_values(Map<String,String> table){

        borrowCalcPage.enterValue(table.get("applicationType"),table.get("dependantNum"),table.get("propertyType"),table.get("annualIncome"),table.get("annualOtherIncome"),
                table.get("annualIncome2"),table.get("annualOtherIncome2"),table.get("monthlyLivingExpense"),table.get("monthlyHomeLoanRepayment"),table.get("otherLoanMonthly"),
                table.get("monthlyCommitment"),table.get("totalCreditCardLimit"));
    }

    @And("User click on calculate")
    public void user_click_on() throws InterruptedException {
        borrowCalcPage.borrowCalcButtonClick();
        Thread.sleep(5000);
    }

    @Then("User gets final borrow estimate")
    public void user_gets_final_borrow_estimate() {
        System.out.println(borrowCalcPage.getEstimate());
    }

    @Given("All the data is filled")
    public void all_the_data_is_filled() {
        System.out.println("All the data is filled");
    }

    @Then("User click on start over")
    public void user_click_on_start_over()  {
        borrowCalcPage.clearForm();
    }
    @And("All the fields are cleared")
    public void all_the_fields_are_cleared() {

        Assert.assertEquals(borrowCalcPage.annualIncome(),"");
        Assert.assertEquals(borrowCalcPage.annualOtherIncome(),"");
        Assert.assertEquals(borrowCalcPage.verifyMonthlyExpense(),"");
        Assert.assertEquals(borrowCalcPage.monthlyHomeLoanRepayment(),"");
        Assert.assertEquals(borrowCalcPage.otherLoanMonthly(),"");
        Assert.assertEquals(borrowCalcPage.monthlyCommitment(),"");
        Assert.assertEquals(borrowCalcPage.totalCreditCardLimit(),"");
        System.out.println("All the fields are cleared");
        driver.close();
    }
    @When("User enters below values")
    public void user_enters_below_values(Map<String,String> table){
        borrowCalcPage.enter(table.get("monthlyLivingExpense"));
    }

    @Then("Error Message pops up")
    public void error_message_pops_up(){
        System.out.println(borrowCalcPage.errorText());
        driver.close();
    }
}
