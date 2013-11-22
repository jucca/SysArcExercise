
using BDD.PageObjects.Tests.Support;
namespace BDD.PageObjects.Tests.PageObjects
{
    class PageObjectFactory
    {
        public static CalculatorPage CalculatorPage
        {
            get { return new CalculatorPage(SeleniumSupport.WebBrowser); }
        }
    }
}
