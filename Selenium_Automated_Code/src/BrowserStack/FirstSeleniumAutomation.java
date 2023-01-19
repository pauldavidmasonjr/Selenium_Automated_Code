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


        Integer companyId = 1501;
        String planName = "Test Plan Name";
        String displayName = "Test Display Name";
        String serFreq = ServiceFrequency.Custom;
        String billFreq = BillingFrequency.CustomBilling;
        String measureUnit = MeasurementUnit.DefaultSquareFootageHome;
        List<String> serviceAreas = Arrays.asList("");
        List<String> coverPropertyTypes = Arrays.asList(
                                            CoveredPropertyTypes.ApartmentId,
                                            CoveredPropertyTypes.CondoId,
                                            CoveredPropertyTypes.MobileHomeId,
                                            CoveredPropertyTypes.MultiUnitResidenceId
                                        );
        String startDateString = "2022-01-02";
        String endDateString = "2022-12-27";

        List<Service> services = new ArrayList<Service>();
        services.add(new Service("Fleas", true));
        services.add(new Service("Mosquitoes", true));

        List<PricingTier> pricingTierList = new ArrayList();
        pricingTierList.add(new PricingTier(1, 2000, 250, 250, 450, 450));
        pricingTierList.add(new PricingTier(2001, 4000, 350, 350, 550, 550));
        pricingTierList.add(new PricingTier(4001, 5000, 450, 450, 650, 650));



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
        webAppService.createNewPlan(newPlan);

        //webAppService.GetCookieFromLogin();
    }

}