package AutomatedTasks;

import Utility.Credentials;
import WebApp.Plan;
import WebApp.PricingTier;
import WebApp.config;
import XPathClasses.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URLDecoder;
import java.time.Duration;
import java.util.List;

public class SeleniumAutomation {

    public static void createFullPlan(Plan planObject, String companyName) throws InterruptedException {
        //setting the driver executable
        System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");

        //Initiating your chromedriver
        WebDriver driver=new ChromeDriver();

        //Applied wait time

        //maximize window
        driver.manage().window().maximize();

        //open browser with desried URL
        driver.get(config.webAppURL);

        // sling shot login select
        driver.findElement(By.cssSelector("a[href*='https://slingshot.workwave.com/login']")).click();

        // Login with credentials
        driver.findElement(By.id("user_email")).sendKeys(Credentials.username);
        driver.findElement(By.id("user_password")).sendKeys(Credentials.password);
        driver.findElement(By.cssSelector("input[type*='submit']")).click();

        Thread.sleep(5000);

        Cookie currentUserCookie = driver.manage().getCookieNamed("Current-User");
        System.out.println(">>>>>>>>>>>>>>>>> COOKIE:   " + currentUserCookie.toString());
        //CurrentUserInformation currentUserInformation = JsonUtils.readValue(URLDecoder.decode(currentUserCookie.getValue(), "UTF-8"), CurrentUserInformation.class);
        //String userId = currentUserInformation.getUserId();

        /*//go to companies page
        driver.get(config.companiesURL);

        //search for company
        driver.findElement(By.xpath(Buttons.SearchInputXPath)).sendKeys(companyName);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/form/button")).click();

        //click company
        Thread.sleep(3000);

        driver.findElement(By.xpath(Buttons.CompanyFirstResultXPath)).click();

        //access url to get company id
        Thread.sleep(2000);
        String url = driver.getCurrentUrl();
        String companyID = url.substring(url.indexOf("companies/")+10);

        System.out.println("COMPANY ID: " + companyID);

        //Click Business Profile
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[href$='business-info']")).click();

        //Click Plan and Pricing
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("a[href$='plans']")).click();

        //click new plan
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(Buttons.CreateNewPlanXPath)).click();

        /////////////////////////////////////////////// FIELD INPUTS /////////////////////////////////////////////////////////////////

        driver.findElement(By.cssSelector("input[name*='name']")).sendKeys(planObject.getName());

        //display Name
        driver.findElement(By.cssSelector("input[name*='displayName']")).sendKeys(planObject.getDisplayName());


        //////////////////////////////////////////////// PLAN TYPE ////////////////////////////////////////////////////////////////////
        driver.findElement(By.xpath(PlanType.PlanXPath)).click();

        ///////////////////////////////////////////// SERVICE AREAS ///////////////////////////////////////////////////////////////////

        List<WebElement> allPageCheckBoxes = driver.findElements(By.cssSelector("input[type*='checkbox']"));
        System.out.println("Service Area Options Size: " + allPageCheckBoxes.size());

        for(int currentPlanObjectServiceAreaIndex=0; currentPlanObjectServiceAreaIndex < planObject.getServiceAreas().size(); currentPlanObjectServiceAreaIndex++)
        {
            System.out.println("CURRENT PLAN OBJECT SERVICE AREA ROW: " + currentPlanObjectServiceAreaIndex);

            for (int allPageCheckboxesIndex = 0; allPageCheckboxesIndex < allPageCheckBoxes.size(); allPageCheckboxesIndex++)
            {
                WebElement serviceAreaElement = allPageCheckBoxes.get(allPageCheckboxesIndex);

                String serviceArea = serviceAreaElement.findElement(By.xpath("following-sibling::*")).getText();

                System.out.println("Plan Service Areas: " + planObject.getServiceAreas().get(currentPlanObjectServiceAreaIndex));
                System.out.println("current inner html service area: " + serviceArea);

                if(planObject.getServiceAreas().get(currentPlanObjectServiceAreaIndex).equals(serviceArea))
                {

                    System.out.println("MATCHING SERVICE AREAS!");
                    allPageCheckBoxes.get(allPageCheckboxesIndex).click();
                }
            }
        }

        //////////////////////////////////////// COVERED PROPERTY TYPES ///////////////////////////////////////////////////////////////

        for(int currentPlanObjectCoveredPropertyIndex=0; currentPlanObjectCoveredPropertyIndex < planObject.getCoveredPropertyTypes().size(); currentPlanObjectCoveredPropertyIndex++)
        {
            System.out.println("CURRENT PLAN OBJECT COVERED PROPERTY ROW: " + currentPlanObjectCoveredPropertyIndex);
            System.out.println("Plan Covered Property: " + planObject.getCoveredPropertyTypes().get(currentPlanObjectCoveredPropertyIndex));

            for (int allPageCheckboxesIndex = 0; allPageCheckboxesIndex < allPageCheckBoxes.size(); allPageCheckboxesIndex++)
            {
                WebElement serviceAreaElement = allPageCheckBoxes.get(allPageCheckboxesIndex);

                String coveredProperty = serviceAreaElement.findElement(By.xpath("following-sibling::*")).getText();

                System.out.println("current inner html covered property: " + coveredProperty);

                if(planObject.getCoveredPropertyTypes().get(currentPlanObjectCoveredPropertyIndex).equals(coveredProperty))
                {

                    System.out.println("MATCHING COVERED PROPERTY!");
                    allPageCheckBoxes.get(allPageCheckboxesIndex).click();
                }
            }
        }

        //////////////////////////////////////////// SERVICE FREQUENCY ///////////////////////////////////////////////////////////////////

        String serviceFreqXPath = "";
        switch(planObject.getServiceFrequency())
        {
            case "Bi Annual":
                serviceFreqXPath = ServiceFrequency.BiAnnualXPath;
                break;
            case "Bi Annual B2b":
                serviceFreqXPath = ServiceFrequency.BiAnnualB2BXPath;
                break;
            case "Bi Monthly":
                serviceFreqXPath = ServiceFrequency.BiMonthlyXPath;
                break;
            case "Bi Monthly B2b":
                serviceFreqXPath = ServiceFrequency.BiMonthlyB2BXPath;
                break;
            case "Custom":
                serviceFreqXPath = ServiceFrequency.CustomXPath;
                break;
            case "Monthly":
                serviceFreqXPath = ServiceFrequency.MonthlyXPath;
                break;
            case "One Time":
                serviceFreqXPath = ServiceFrequency.OneTimeXPath;
                break;
            case "Quarterly":
                serviceFreqXPath = ServiceFrequency.QuarterlyXPath;
                break;
            case "Quarterly B2b":
                serviceFreqXPath = ServiceFrequency.QuarterlyB2BXPath;
                break;
            case "Tri Annual":
                serviceFreqXPath = ServiceFrequency.TriAnnualXPath;
                break;
            case "Tri Annual B2b":
                serviceFreqXPath = ServiceFrequency.TriAnnualB2BXPath;
                break;
            case "Yearly":
                serviceFreqXPath = ServiceFrequency.YearlyXPath;
                break;
            default:
                serviceFreqXPath = "Default Case";
        }
        driver.findElement((By.xpath(serviceFreqXPath))).click();

        //////////////////////////////////////////// BILLING FREQUENCY /////////////////////////////////////////////////////////////////////
        String billingFrequencyXPath = "";

        switch(planObject.getBillingFrequency())
        {
            case "Custom Billing":
                billingFrequencyXPath = BillingFrequency.CustomBillingXPath;
                break;
            case "Per Month":
                billingFrequencyXPath = BillingFrequency.PerMonthXPath;
                break;
            case "Per Service":
                billingFrequencyXPath = BillingFrequency.PerServiceXPath;
            default:
                billingFrequencyXPath = "Default Case";
        }
        driver.findElement(By.xpath(billingFrequencyXPath)).click();

        //////////////////////////////////////////// START & END DATE ////////////////////////////////////////////////////////////////////////////

        System.out.println("Sending Date Keys");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement startDate  = driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div[2]/div/div[1]/div[2]/div[1]/div"));
        startDate.click();


        WebElement startDateInput = driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div[2]/div/div[1]/div[2]/div[1]/input"));
        startDateInput.sendKeys(Keys.TAB);

        Thread.sleep(10000);

        /////////////////////////////////////////// Measurement Unit /////////////////////////////////////////////////////////////////////////
        String measurementUnitXPath = "";

        switch(planObject.getMeasurementUnit())
        {
            case "Square Footage - Home":
                measurementUnitXPath = MeasurementUnit.SquareFootageHomeXPath;
                break;
            case "Square Footage - Lawn Size":
                measurementUnitXPath = MeasurementUnit.SquareFootageLawnSizeXPath;
                break;
            case "Square Footage - Lot Size":
                measurementUnitXPath = MeasurementUnit.SquareFootageLotSizeXPath;
                break;
            case "Number of Bedrooms":
                measurementUnitXPath = MeasurementUnit.NumberOfBedroomsXPath;
                break;
            case "Linear Feet - Home Perimeter":
                measurementUnitXPath = MeasurementUnit.LinearFeetHomePerimeterXPath;
                break;
            default:
                measurementUnitXPath = MeasurementUnit.DefaultSquareFootageHomeXPath;

        }
        driver.findElement(By.xpath(measurementUnitXPath)).click();

        ////////////////////////////////////////// Create New PRicing Tier //////////////////////////////////////////////////////////////
        List<PricingTier> pricingTiersList = planObject.getPriceTiers();

        for(int i = 0; i < pricingTiersList.size(); i++)
        {
            driver.findElement(By.xpath(Buttons.CreateNewPricingTierXPath)).click();
        }

        //////////////////////////////////////////////// INSERT DATA INTO PRICE TIERS //////////////////////////////////////////////////////

        List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"root\"]/div[4]/div[3]/div[2]/div/div/table/thead/tr/th"));
        List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"root\"]/div[4]/div[3]/div[2]/div/div/table/tbody/tr/td[1]"));

        System.out.println("----COL SIZE: " + col.size());
        System.out.println("----ROW SIZE: " + row.size()*2);

        for(int currentPriceTierIndex = 0; currentPriceTierIndex < planObject.getPriceTiers().size(); currentPriceTierIndex++)
        {
            int tierRow = currentPriceTierIndex + 1;

            //min sqft
            System.out.println("min sqft: " + planObject.getPriceTiers().get(currentPriceTierIndex).getSqftMin());
            driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[3]/div[2]/div/div/table/tbody/tr["+tierRow+"]/td[1]/div/div[1]/input")).clear();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[3]/div[2]/div/div/table/tbody/tr["+tierRow+"]/td[1]/div/div[1]/input")).sendKeys(String.valueOf(planObject.getPriceTiers().get(currentPriceTierIndex).getSqftMin()));

            //max sqft
            System.out.println("max sqft: " + planObject.getPriceTiers().get(currentPriceTierIndex).getSqftMax());
            driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[3]/div[2]/div/div/table/tbody/tr["+tierRow+"]/td[1]/div/div[2]/input")).clear();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[3]/div[2]/div/div/table/tbody/tr["+tierRow+"]/td[1]/div/div[2]/input")).sendKeys(String.valueOf(planObject.getPriceTiers().get(currentPriceTierIndex).getSqftMax()));

            //min initial
            System.out.println("max initial price: " + planObject.getPriceTiers().get(currentPriceTierIndex).getInitialMax());
            driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[3]/div[2]/div/div/table/tbody/tr["+tierRow+"]/td[2]/div/div[1]/input")).sendKeys(String.valueOf(planObject.getPriceTiers().get(currentPriceTierIndex).getInitialMax()));

            //max initial
            System.out.println("max initial price: " + planObject.getPriceTiers().get(currentPriceTierIndex).getInitialMax());
            driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[3]/div[2]/div/div/table/tbody/tr["+tierRow+"]/td[2]/div/div[2]/input")).sendKeys(String.valueOf(planObject.getPriceTiers().get(currentPriceTierIndex).getInitialMax()));

            //min recurring
            System.out.println("min recurring price: " + planObject.getPriceTiers().get(currentPriceTierIndex).getRecurringMin());
            driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[3]/div[2]/div/div/table/tbody/tr["+tierRow+"]/td[3]/div/div[1]/input")).sendKeys(String.valueOf(planObject.getPriceTiers().get(currentPriceTierIndex).getRecurringMin()));

            //max recurring
            System.out.println("max recurring price: " + planObject.getPriceTiers().get(currentPriceTierIndex).getRecurringMax());
            driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[3]/div[2]/div/div/table/tbody/tr["+tierRow+"]/td[3]/div/div[2]/input")).sendKeys(String.valueOf(planObject.getPriceTiers().get(currentPriceTierIndex).getRecurringMax()));

        }

        ///////////////////////////////////////////////////// Drag Drop Covered Pests ////////////////////////////////////////////////////////////

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

                if(planObject.getServices().contains(pest))
                {
                    sourceElement.sendKeys(Keys.SPACE);
                    sourceElement.sendKeys(Keys.ARROW_RIGHT);
                    sourceElement.sendKeys(Keys.SPACE);
                }
            }
        }


        /////////////////////////////////////////////////////////////// Save PLan ////////////////////////////////////////////////////////////////////////
        driver.findElement(By.xpath(Buttons.SavePlanXPath)).click();

        //closing the browser
        //driver.close();
        //*[@id="root"]/div[4]/div[4]/div/div[1]/div[2]/div[1]
        //*[@id="root"]/div[4]/div[4]/div/div[1]/div[2]/div[2]*/
    }
}
