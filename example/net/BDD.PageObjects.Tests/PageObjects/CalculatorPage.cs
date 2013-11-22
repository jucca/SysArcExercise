
using BDD.PageObjects.Tests.Support;
using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
namespace BDD.PageObjects.Tests.PageObjects
{
    class CalculatorPage
    {
        public CalculatorPage(IWebDriver driver)
        {
            this.driver = driver;
        }

        public CalculatorPage Calculate()
        {
            CalculateButton.Click();
            return this;
        }

        public CalculatorPage NavigateTo()
        {
            SeleniumSupport.WebBrowser.Navigate().GoToUrl(UrlOfCalculator);
            return this;
        }

        public CalculatorPage TypeFirstInput(string input)
        {
            FirstInput.SendKeys(input);
            return this;
        }

        public CalculatorPage TypeSecondInput(string input)
        {
            SecondInput.SendKeys(input);
            return this;
        }

        public CalculatorPage SelectAddOperation()
        {
            Operation.SelectByText("+");
            return this;
        }

        public CalculatorPage SelectReduceOperation()
        {
            Operation.SelectByText("-");
            return this;
        }

        public CalculatorPage SelectDivisionOperation()
        {
            Operation.SelectByText("/");
            return this;
        }

        public CalculatorPage SelectMultiplicationOperation()
        {
            Operation.SelectByText("*");
            return this;
        }

        public bool CalculationCanBeDone
        {
            get { return CalculateButton.Enabled; }
        }

        public string ResultText
        {
            get { return Result.Text; }
        }

        private string UrlOfCalculator
        {
            get { return string.Format("{0}/Calculator", ApplicationSettings.UriOfCalculator); }
        }

        private SelectElement Operation
        {
            get { return new SelectElement(driver.FindElement(By.Id("operation"))); }
        }
        
        private IWebElement FirstInput
        {
            get { return driver.FindElement(By.Id("firstInput")); }
        }

        private IWebElement SecondInput
        {
            get { return driver.FindElement(By.Id("secondInput")); }
        }

        private IWebElement Result
        {
            get { return driver.FindElement(By.Id("result")); }
        }

        private IWebElement CalculateButton
        {
            get { return driver.FindElement(By.Id("calculate")); }
        }

        private IWebDriver driver;
    }
}
