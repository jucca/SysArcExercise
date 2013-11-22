using BDD.PageObjects.Tests.PageObjects;
using BDD.PageObjects.Tests.Support.Features;
using TechTalk.SpecFlow;

namespace BDD.PageObjects.Tests.Steps.Calculator
{
    [Binding]
    public class MultiplicationSteps
    {
        [Given(@"I have selected the multiplication operation in the calculator")]
        public void GivenIHaveSelectedTheMultiplicationOperationInTheCalculator()
        {
            CalculatorPage.SelectMultiplicationOperation();
        }


        private CalculatorPage CalculatorPage
        {
            get { return CalculatorFeatureSupport.CalculatorPage; }
        }
    }
}
