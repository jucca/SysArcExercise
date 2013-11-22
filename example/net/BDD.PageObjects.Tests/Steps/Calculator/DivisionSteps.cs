using BDD.PageObjects.Tests.PageObjects;
using BDD.PageObjects.Tests.Support.Features;
using TechTalk.SpecFlow;

namespace BDD.PageObjects.Tests.Steps.Calculator
{
    [Binding]
    public class DivisionSteps
    {
        [Given(@"I have selected the division operation in the calculator")]
        public void GivenIHaveSelectedTheDivisionOperationInTheCalculator()
        {
            CalculatorPage.SelectDivisionOperation();
        }
                
        private CalculatorPage CalculatorPage
        {
            get { return CalculatorFeatureSupport.CalculatorPage; }
        }
    }
}
