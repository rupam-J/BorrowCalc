package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BorrowCalcPage {
    By application_type_single = By.xpath("//label[@for='application_type_single']");
    By application_type_joint = By.xpath("//label[@for='application_type_joint']");
    By dependant_num = By.xpath("//select[@title='Number of dependants']");
    By property_home = By.xpath("//label[@for='borrow_type_home']");
    By property_investment = By.xpath("//label[@for='borrow_type_investment]");
    By annual_income = By.xpath("//input[@aria-labelledby='q2q1']");
    By annual_other_income = By.xpath("//input[@aria-labelledby='q2q2']");
    By annual_income_2nd_applicant = By.xpath("//input[@aria-labelledby='q2q3']");
    By annual_other_2nd_applicant = By.xpath("//input[@aria-labelledby='q2q4']");
    By monthly_living_expense = By.xpath("//input[@aria-labelledby='q3q1']");
    By monthly_home_loan_repayment = By.xpath("//input[@aria-labelledby='q3q2']");
    By other_loan_monthly = By.xpath("//input[@aria-labelledby='q3q3']");
    By monthly_commitment = By.xpath("//input[@aria-labelledby='q3q4']");
    By total_credit_card_limit = By.xpath("//input[@aria-labelledby='q3q5']");
    By borrow_calculator_button = By.id("btnBorrowCalculater");
    By borrow_estimate = By.id("borrowResultTextAmount");
    By start_over = By.className("start-over");
    By error_message = By.className("borrow__error__text");


    WebDriver driver;

    public BorrowCalcPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterValue(String applicationType, String dependantNum, String propertyType, String annualIncome, String annualOtherIncome,
                           String annualIncome2, String annualOtherIncome2, String monthlyLivingExpense,
                           String monthlyHomeLoanRepayment, String otherLoanMonthly, String monthlyCommitment, String totalCreditCardLimit) {

        if (applicationType.equals("single")) {
            driver.findElement(application_type_single).click();
        } else if (applicationType.equals("joint")) {
            driver.findElement(application_type_joint).click();
            driver.findElement(annual_income_2nd_applicant).sendKeys(annualIncome2);
            driver.findElement(annual_other_2nd_applicant).sendKeys(annualOtherIncome2);
        }

        driver.findElement(dependant_num).sendKeys(dependantNum);

        if (propertyType.equals("home")) {
            driver.findElement(property_home).click();

        } else if (propertyType.equals("investment")) {
            driver.findElement(property_investment).click();
        }
        driver.findElement(annual_income).sendKeys(annualIncome);
        driver.findElement(annual_other_income).sendKeys(annualOtherIncome);
        driver.findElement(monthly_living_expense).sendKeys(monthlyLivingExpense);
        driver.findElement(monthly_home_loan_repayment).sendKeys(monthlyHomeLoanRepayment);
        driver.findElement(other_loan_monthly).sendKeys(otherLoanMonthly);
        driver.findElement(monthly_commitment).sendKeys(monthlyCommitment);
        driver.findElement(total_credit_card_limit).sendKeys(totalCreditCardLimit);

    }

    public void borrowCalcButtonClick() {
        driver.findElement(borrow_calculator_button).click();
    }

    public String getEstimate() {
        return driver.findElement(borrow_estimate).getText();

    }

    public void clearForm() {
        driver.findElement(start_over).click();
    }

    public String errorText() {
        return driver.findElement(error_message).getText();
    }

    public void enter(String monthlyLivingExpense){
        driver.findElement(monthly_living_expense).sendKeys(monthlyLivingExpense);
    }

    public String otherLoanMonthly() {
        return driver.findElement(other_loan_monthly).getText();
    }

    public String annualIncome() {
        return driver.findElement(annual_income).getText();
    }
    public String annualOtherIncome() {
        return driver.findElement(annual_other_income).getText();
    }

    public String monthlyHomeLoanRepayment() {
        return driver.findElement(monthly_home_loan_repayment).getText();
    }

    public String monthlyCommitment() {
        return driver.findElement(monthly_commitment).getText();
    }

    public String verifyMonthlyExpense() {
       return driver.findElement(monthly_living_expense).getText();
        }

    public String totalCreditCardLimit() {
        return driver.findElement(total_credit_card_limit).getText();
    }

}

