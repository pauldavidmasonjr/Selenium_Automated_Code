package BrowserStack;

import Services.WebAppService;
import WebApp.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstSeleniumAutomation {

    public static void main(String[] args) throws ParseException, InterruptedException, IOException {


        // ------------------------------ Company ID ------------------------------------------------------------------
        Integer companyId = 1501;
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // ------------------------------ Plan Name -------------------------------------------------------------------
        String planName = "Test Plan Name";
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // ------------------------------ Display Name ----------------------------------------------------------------
        String displayName = "Test Display Name";
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // ------------------------------ Service Frequency -----------------------------------------------------------
        String serFreq = ServiceFrequency.Custom;
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // ------------------------------ Billing Frequency -----------------------------------------------------------
        String billFreq = BillingFrequency.CustomBilling;
        /////////////////////////////////////////////////////////////////////////////////////////////

        // ------------------------------ Measurement Unit ------------------------------------------------------------
        String measureUnit = MeasurementUnit.DefaultSquareFootageHome;
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // ------------------------------ Service Areas ---------------------------------------------------------------
        List<String> serviceAreas = Arrays.asList("");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // ------------------------------ Covered Properties ----------------------------------------------------------
        List<String> coverPropertyTypes = Arrays.asList(
                                            CoveredPropertyTypes.ApartmentId,
                                            CoveredPropertyTypes.CondoId,
                                            CoveredPropertyTypes.MobileHomeId,
                                            CoveredPropertyTypes.MultiUnitResidenceId
                                        );
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////


        // ------------------------------ Start and End Dates ---------------------------------------------------------
        String startDateString = "2022-01-02";
        String endDateString = "2022-12-27";
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////


        // ------------------------------ Services --------------------------------------------------------------------
        Service service1 = new Service("Fleas", true);
        Service service2 = new Service("Mosquitoes", true);

        List<Service> services = new ArrayList<Service>();
        services.add(service1);
        services.add(service2);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////


        // ------------------------------ Pricing Tiers ----------------------------------------------------------------
        PricingTier priceT1 = new PricingTier(1, 2000, 250, 250, 450, 450);
        PricingTier priceT2 = new PricingTier(2001, 4000, 350, 350, 550, 550);
        PricingTier priceT3 = new PricingTier(4001, 5000, 450, 450, 650, 650);

        List<PricingTier> pricingTierList = new ArrayList();
        pricingTierList.add(priceT1);
        pricingTierList.add(priceT2);
        pricingTierList.add(priceT3);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////






        //----------------------------------- DO NOT EDIT ANYTHING BELOW THIS LINE -------------------------------------
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Plan newPlan = new Plan();

        //newPlan.setCompanyName("Mosquito Squad (Annapolis)");
        newPlan.setCompanyId(companyId);
        newPlan.setName(planName);
        newPlan.setDisplayName(displayName);
        newPlan.setPlanType("plan");
        newPlan.setServiceAreas(serviceAreas);
        newPlan.setCoveredPropertyTypes(coverPropertyTypes);
        newPlan.setServiceFrequency(serFreq);
        newPlan.setBillingFrequency(billFreq);
        newPlan.setBillingFrequencyNotes("");
        newPlan.setStartDate(startDateString);
        newPlan.setEndDate(endDateString);
        newPlan.setMeasurementUnit(measureUnit);
        newPlan.setPriceTiers(pricingTierList);
        newPlan.setServices(services);

        // Calling Service
        WebAppService webAppService = new WebAppService();
        //webAppService.createNewPlan(newPlan);

        webAppService.GetCookieFromLogin();
    }

}