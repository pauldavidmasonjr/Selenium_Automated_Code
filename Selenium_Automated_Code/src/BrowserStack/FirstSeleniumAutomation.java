package BrowserStack;

import XPathClasses.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstSeleniumAutomation {

    public static void main(String[] args) throws InterruptedException, AWTException {


        System.out.println("Hello World!");
        // TODO Auto-generated method stub

        //setting the driver executable
        System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");

        //Initiating your chromedriver
        WebDriver driver=new ChromeDriver();

        //Applied wait time
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize window
        driver.manage().window().maximize();

        //open browser with desried URL
        driver.get("https://communication.workwave.com/inbox");

        // sling shot login select
        driver.findElement(By.cssSelector("a[href*='https://slingshot.workwave.com/login']")).click();

        // Login with credentials
        driver.findElement(By.id("user_email")).sendKeys("paul.masonjr@workwave.com");
        driver.findElement(By.id("user_password")).sendKeys("Hudson27Brooks26Knox11!");
        driver.findElement(By.cssSelector("input[type*='submit']")).click();

        //go to companies page
        driver.get("https://slingshot.workwave.com/companies");

        //search for company
        driver.findElement(By.id("query")).sendKeys("Mosquito Squad (Annapolis)");
        driver.findElement(By.id("query")).sendKeys(Keys.RETURN);

        //click company
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a[href*='/companies/1068']")).click();

        //Click Business Profile
        driver.findElement(By.cssSelector("a[href*='/companies/1068/business-info']")).click();

        //Click Plan and Pricing
        driver.findElement(By.cssSelector("a[href*='/companies/1068/plans']")).click();

        //click new plan
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/button[2]/span")).click();

        /////////////////////////////////////////////// FIELD INPUTS /////////////////////////////////////////////////////////////////
        //name
        driver.findElement(By.cssSelector("input[name*='name']")).sendKeys("Test Plan Name");
        //display Name
        driver.findElement(By.cssSelector("input[name*='displayName']")).sendKeys("Test Display Name");

        //////////////////////////////////////////////// PLAN TYPE ////////////////////////////////////////////////////////////////////
        driver.findElement(By.xpath(PlanType.PlanXPath)).click();

        ///////////////////////////////////////////// SERVICE AREAS ///////////////////////////////////////////////////////////////////
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div[2]/div/div[1]/div[1]/div/div[1]/input")).click();

        //////////////////////////////////////// COVERED PROPERTY TYPES ///////////////////////////////////////////////////////////////
        //Apartment
        driver.findElement(By.xpath(CoveredPropertyTypes.ApartmentXPath)).click();
        //Commercial Property
        driver.findElement(By.xpath(CoveredPropertyTypes.CommercialPropertyXPath)).click();
        //Condo
        driver.findElement(By.xpath(CoveredPropertyTypes.CondoXPath)).click();
        //Mobile Home
        driver.findElement(By.xpath(CoveredPropertyTypes.MobileHomeXPath)).click();
        //Multi-Unit Residence
        driver.findElement(By.xpath(CoveredPropertyTypes.MultiUnitResidenceXPath)).click();
        //Single-Family Home
        driver.findElement(By.xpath(CoveredPropertyTypes.SingleFamilyHomeXPath)).click();
        //Townhouse
        driver.findElement(By.xpath(CoveredPropertyTypes.TownHomeXPath)).click();

        //////////////////////////////////////////// SERVICE FREQUENCY ///////////////////////////////////////////////////////////////////
        // Bi Annual
        driver.findElement((By.xpath(ServiceFrequency.BiAnnualXPath))).click();

        //////////////////////////////////////////// BILLING FREQUENCY /////////////////////////////////////////////////////////////////////
        driver.findElement(By.xpath(BillingFrequency.PerYearXPath)).click();

        //////////////////////////////////////////// START & END DATE ////////////////////////////////////////////////////////////////////////////
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/mm/dd");
        //LocalDate localDate = LocalDate.now();
        //driver.findElement(fromDate).sendKeys(dtf.format(localDate));
        //driver.findElement(By.xpath(Dates.StartDateXPath)).click();
        //driver.findElement(By.xpath(Dates.StartDateXPath)).sendKeys("05/02/2022");
        //driver.findElement(By.xpath(Dates.EndDateXPath)).sendKeys("05012022");

        //JavascriptExecutor js = (JavascriptExecutor)driver;
        //js.executeScript("document.evaluate("+Dates.StartDateXPath+", document, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null ).value='2018-07-17'");

        //WebElement startDate=driver.findElement(By.xpath(Dates.StartDateXPath));

        //startDate.clear();
        //startDate.sendKeys("05012022s");
        //startDate.sendKeys("05012022s");


        /////////////////////////////////////////// Measurement Unit /////////////////////////////////////////////////////////////////////////
        driver.findElement(By.xpath(MeasurementUnit.SquareFootageHomeXPath)).click();

        ////////////////////////////////////////// Create New PRicing Tier //////////////////////////////////////////////////////////////
        driver.findElement(By.xpath(Buttons.CreateNewPricingTierXPath)).click();
        driver.findElement(By.xpath(Buttons.CreateNewPricingTierXPath)).click();
        driver.findElement(By.xpath(Buttons.CreateNewPricingTierXPath)).click();
        driver.findElement(By.xpath(Buttons.CreateNewPricingTierXPath)).click();
        driver.findElement(By.xpath(Buttons.CreateNewPricingTierXPath)).click();
        driver.findElement(By.xpath(Buttons.CreateNewPricingTierXPath)).click();
        driver.findElement(By.xpath(Buttons.CreateNewPricingTierXPath)).click();
        driver.findElement(By.xpath(Buttons.CreateNewPricingTierXPath)).click();


        //////////////////////////////////////////////// INSERT DATA INTO PRICE TIERS //////////////////////////////////////////////////////

        List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"root\"]/div[4]/div[3]/div[2]/div/div/table/thead/tr/th"));
        List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"root\"]/div[4]/div[3]/div[2]/div/div/table/tbody/tr/td[1]"));

        System.out.println("COL SIZE: " + col.size());
        System.out.println("ROW SIZE: " + row.size());

        for(int currentCol = 1; currentCol < col.size(); currentCol++)
        {
            System.out.println("currentCol: "+col);
            for (int currentRow = 1; currentRow <= row.size(); currentRow++)
            {
                System.out.println("currentRow: "+currentRow);
                driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[3]/div[2]/div/div/table/tbody/tr["+currentRow+"]/td["+currentCol+"]/div/div[1]/input")).sendKeys("1");
                driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[3]/div[2]/div/div/table/tbody/tr["+currentRow+"]/td["+currentCol+"]/div/div[2]/input")).sendKeys("2");
            }
        }

        ///////////////////////////////////////////////////// Drag Drop Covered Pests ////////////////////////////////////////////////////////////

        //need to get all following sibling divs to drag
        List<WebElement> dragRows = driver.findElements(By.xpath("/html/body/div[1]/div/div[4]/div[4]/div/div[1]/div[2]/div"));

        System.out.println("DRAG ROW: " + dragRows.size());
        System.out.println(dragRows.toString());

        WebElement To = driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[4]/div/div[2]/div[2]"));


        for(int currentDragRow=1; currentDragRow <= dragRows.size(); currentDragRow++)
        {
            System.out.println("CURENT DRAG ROW: " + currentDragRow);
            if (currentDragRow == 1)
            {
                //do nothing this is the search bar row
            }
            else
            {
                WebElement sourceElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[4]/div/div[1]/div[2]/div[2]/div[1]"));

                WebElement pestElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[4]/div/div[1]/div[2]/div[2]/div[2]"));

                String pest = pestElement.getText();

                if(pest.equals("Fleas") || pest.equals("Mosquitoes"))
                {
                    sourceElement.sendKeys(Keys.SPACE);
                    sourceElement.sendKeys(Keys.ARROW_RIGHT);
                    sourceElement.sendKeys(Keys.SPACE);
                }

//                sourceElement.sendKeys(Keys.SPACE);
//                sourceElement.sendKeys(Keys.ARROW_RIGHT);
//                sourceElement.sendKeys(Keys.SPACE);
            }
        }

        //closing the browser
        //driver.close();
        //*[@id="root"]/div[4]/div[4]/div/div[1]/div[2]/div[1]
        //*[@id="root"]/div[4]/div[4]/div/div[1]/div[2]/div[2]
    }

}