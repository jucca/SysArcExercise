using BDD.PageObjects.Tests.PageObjects;
using BDD.PageObjects.Tests.Support.Features;
using TechTalk.SpecFlow;

namespace BDD.PageObjects.Tests.Steps.Calculator
{
    [Binding]
    public class AddSteps
    {
        [Given(@"I have selected the add operation in the calculator")]
        public void GivenIHaveSelectedTheAddOperationInTheCalculator()
        {
            CalculatorPage.SelectAddOperation();
        }

        private CalculatorPage CalculatorPage
        {
            get { return CalculatorFeatureSupport.CalculatorPage; }
        }
    }
}
