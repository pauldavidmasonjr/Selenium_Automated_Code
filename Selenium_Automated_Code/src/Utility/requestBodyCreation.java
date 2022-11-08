package Utility;

import WebApp.Plan;

public class requestBodyCreation {
    public static String createPostBodyFromPlan(Plan newPlan)
    {
        //create post body string
        StringBuilder postBody=new StringBuilder();

        //postBody.append("\"");
        postBody.append("{");
        postBody.append("\"billing_frequency\":\""+newPlan.getBillingFrequency()+"\"");
        postBody.append(",");
        //postBody.append("\"billing_frequency_notes\":\""+newPlan.getBillingFrequencyNotes()+"\"");
        //postBody.append(",");
        postBody.append("\"company_id\":"+newPlan.getCompanyId());
        postBody.append(",");
        postBody.append("\"display_name\":\""+newPlan.getDisplayName()+"\"");
        postBody.append(",");
        postBody.append("\"end_day\":\""+newPlan.getEndDate()+"\"");
        postBody.append(",");
        postBody.append("\"frequency\":\""+newPlan.getServiceFrequency()+"\"");
        postBody.append(",");
        postBody.append("\"frequency_notes\":\"\"");
        postBody.append(",");
        postBody.append("\"id\":null");
        postBody.append(",");
        postBody.append("\"include_services_on_sidebar\":true");
        postBody.append(",");
        postBody.append("\"kind\":\""+newPlan.getPlanType()+"\"");
        postBody.append(",");
        postBody.append("\"measurement_unit\":\""+newPlan.getMeasurementUnit()+"\"");
        postBody.append(",");
        postBody.append("\"name\":\""+newPlan.getName()+"\"");
        postBody.append(",");
        postBody.append("\"pricing_rule\":\"always_apply\"");
        postBody.append(",");
        postBody.append("\"quotable_only\":false");
        postBody.append(",");
        postBody.append("\"start_day\":\""+newPlan.getStartDate()+"\"");
        postBody.append(",");
        postBody.append("\"recurring_charges_count\":\"\"");
        postBody.append(",");
        postBody.append("\"add_ons\":[]");
        postBody.append(",");
        postBody.append("\"available_add_ons\":[]");
        postBody.append(",");
        postBody.append("\"covered_property_types\":");

        postBody.append("[");

        System.out.println("bodyStringProgress: " + String.valueOf(postBody));
        //loop through covered property type
        for(int i = 0; i < newPlan.getCoveredPropertyTypes().size(); i++)
        {
            System.out.println("COVERED PROPERTY ID:" + newPlan.getCoveredPropertyTypes().get(i));
            postBody.append(newPlan.getCoveredPropertyTypes().get(i));

            if(i+1 != newPlan.getCoveredPropertyTypes().size())
            {
                System.out.println("COVERED PROPERTY - adding comma");
                postBody.append(",");
            }
        }
        postBody.append("],");

        postBody.append("\"options\":[]");
        postBody.append(",");
        postBody.append("\"plans\":[]");
        postBody.append(",");

        System.out.println("bodyStringProgress:" + String.valueOf(postBody));

        //pricing tiers
        postBody.append("\"pricing_tiers\":");
        postBody.append("[");
        for(int i = 0; i < newPlan.getPriceTiers().size(); i++)
        {
            postBody.append("{");

            postBody.append("\"measurement\":["+newPlan.getPriceTiers().get(i).getSqftMin()+","+newPlan.getPriceTiers().get(i).getSqftMax()+"],");
            postBody.append("\"initial_price\":["+newPlan.getPriceTiers().get(i).getInitialMin()+","+newPlan.getPriceTiers().get(i).getInitialMax()+"],");
            postBody.append("\"recurring_price\":["+newPlan.getPriceTiers().get(i).getRecurringMin()+","+newPlan.getPriceTiers().get(i).getRecurringMax()+"]");

            postBody.append("}");

            if(i+1 != newPlan.getPriceTiers().size())
            {
                System.out.println("PRICING TIER - adding comma");
                postBody.append(",");
            }

        }

        postBody.append("],");

        postBody.append("\"service_maps\":[],");

        System.out.println("\"bodyStringProgress\":" + String.valueOf(postBody));


        //Services
        postBody.append("\"services\":");
        postBody.append("[");
        for(int i = 0; i < newPlan.getServices().size(); i ++)
        {
            System.out.println("SERVICE SIZE:" + newPlan.getPriceTiers().size());
            //System.out.println("Servide idems: " + newPlan.get)
            System.out.println("Service INDEX:" + i);
            System.out.println("Service Name:" + newPlan.getServices().get(i).getServiceName());
            postBody.append("{");

            int serviceId = i+1;

            postBody.append("\"id\":"+serviceId+",");
            postBody.append("\"name\":\""+newPlan.getServices().get(i).getServiceName()+"\",");
            postBody.append("\"guaranteed\":"+newPlan.getServices().get(i).getGuaranteed()+"");

            postBody.append("}");

            if(i+1 != newPlan.getServices().size())
            {
                System.out.println("adding comma");
                postBody.append(",");
            }

        }

        postBody.append("]");

        postBody.append("}");

        //postBody.append("\"");

        return String.valueOf(postBody);
    }
}
