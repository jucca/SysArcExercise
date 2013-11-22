using BDD.PageObjects.Tests.PageObjects;
using BDD.PageObjects.Tests.Support.Features;
using TechTalk.SpecFlow;

namespace BDD.PageObjects.Tests.Steps.Calculator
{
    [Binding]
    public class ReduceSteps
    {
        [Given(@"I have selected the reduce operation in the calculator")]
        public void GivenIHaveSelectedTheReduceOperationInTheCalculator()
        {
            CalculatorPage.SelectReduceOperation();
        }
        
        private CalculatorPage CalculatorPage
        {
            get { return CalculatorFeatureSupport.CalculatorPage; }
        }
    }
}
