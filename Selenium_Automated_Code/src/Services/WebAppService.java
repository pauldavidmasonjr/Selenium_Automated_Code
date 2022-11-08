package Services;

import AutomatedTasks.SeleniumAutomation;
import Utility.requestBodyCreation;
import WebApp.Plan;
import okhttp3.*;

import java.io.IOException;
import java.util.List;

public class WebAppService {

    public Response createNewPlan(Plan newPlan) throws IOException, InterruptedException {
        //get cookie
        System.out.println("------------------------------------------   Calling GetCookieFromLogin()");
        String cookie = this.GetCookieFromLogin();
        //SeleniumAutomation.createFullPlan(newPlan, newPlan.getCompanyName());

        //System.out.println("COKKIE: " + cookie);


        String convertedPostBody = requestBodyCreation.createPostBodyFromPlan(newPlan);

        System.out.println("POST BODY:" + convertedPostBody);

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, convertedPostBody);
        //RequestBody body = RequestBody.create(mediaType, "{\"billing_frequency\":\"per_service\",\"company_id\":1501,\"display_name\":\"Fully working solution display name\",\"end_day\":\"0000-12-31\",\"frequency\":\"custom\",\"frequency_notes\":\"\",\"id\":null,\"include_services_on_sidebar\":true,\"kind\":\"plan\",\"measurement_unit\":\"Default\",\"name\":\"Fully working solution\",\"pricing_rule\":\"always_apply\",\"quotable_only\":false,\"start_day\":\"0000-02-02\",\"recurring_charges_count\":\"\",\"add_ons\":[],\"available_add_ons\":[],\"covered_property_types\":[4,3,5,7],\"options\":[],\"plans\":[],\"pricing_tiers\":[{\"measurement\":[1,2000],\"initial_price\":[250,250],\"recurring_price\":[450,450]},{\"measurement\":[2001,4000],\"initial_price\":[350,350],\"recurring_price\":[550,550]},{\"measurement\":[4001,5000],\"initial_price\":[450,450],\"recurring_price\":[650,650]}],\"service_maps\":[],\"services\":[{\"id\":1,\"name\":\"Fleas\",\"guaranteed\":true},{\"id\":2,\"name\":\"Mosquitoes\",\"guaranteed\":true}]}\n");
        Request request = new Request.Builder()
                .url("https://slingshot.workwave.dev/api/companies/1501/plans")
                .method("POST", body)
                .addHeader("Accept", "application/json, text/plain, */*")
                .addHeader("Accept-Language", "en-US,en;q=0.9")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "_workwave_prod_data_session=T0JxVURuTThJTUQvWktMNWtaYUFWRy9HTm5tVXp1QjU5b3RUOEJVMTA5SWk0YldJeDc1VWpReUJFdUFXOVZHTkZoakZJTkxEZjY1eWpBK082WVhSRHYvMVZ0NEd5SVZJREpXQkp0MEg5WGlFNkowblFkaUxseGY1Y09LNDVXbndja2pKRU9sRDBVbi9USVNYeVN5cDlxR1BkbVNzVUI1V3VGcDVNS0NDdUE3M214MXFRN01lQzNwMU5PbkxRSzJ4Z05mTUJONHNvTGdzSTRmU2dEOE9aWXFOd2NrYTdkR0gwaUR2dXlVQitzdUxSdVZtcFp3QnBrc2tYVVZRZkRKbVRYSUJCd281cTl0V3VaZU5XMGgvakg0TlJBM1Y1SjFlVnJFbXZFT3AvMnIwSXUyWGxpTDRwOWNlMEVZNmFHT2dETHJaOUhBWkl4ZnRDckl2UUFrSm1xaWswVmVnUmFVOEZJcFY0VnVqTzFXQTRHcEVZRkU3QTlRNlh3aWRZaDM5cXBCUHhObytMNUZEb3lPL2M5M0VXeXovNTdqMDdMdEsyNFo1dzZhSDNEVzB1ZEY0cDNNQ09NTVhrazIwUVVaTTRpbEhSV3RtYzhTSmJlVDNBOUl5Skx4dEQ0Rmw3V2s2OWV2TWhCdythWmhvQ3l6WWl4am1aRHk0NW9lSjhYRGlrUWpGaDI3VkRCcU5JVzJwWDJNUWJpbkJFaGtudDNRd3dEWXhWeWRNMzRSQkUyRENlZFFodGx5SlB6S3V5NVdaLS1XWEJyS050dmZiRGxhRGE5Nm1teWNRPT0%3D--3de2fefc96a7a85373c75a586d28e20f611538ff")
                .addHeader("Origin", "https://slingshot.workwave.dev")
                .addHeader("Referer", "https://slingshot.workwave.dev/companies/1501/plans/new")
                .addHeader("Sec-Fetch-Dest", "empty")
                .addHeader("Sec-Fetch-Mode", "cors")
                .addHeader("Sec-Fetch-Site", "same-origin")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36")
                .addHeader("X-CSRF-Token", "5vJLAdIiaJIsqw1+xFKgQraO3heBgPsWDSBeQU1e/u2sMqJ/rc1VTbTQj0K5Xkf5VZGj5LlsB8qzMSvDc+QedQ==")
                .addHeader("sec-ch-ua", "\"Chromium\";v=\"106\", \"Google Chrome\";v=\"106\", \"Not;A=Brand\";v=\"99\"")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("sec-ch-ua-platform", "\"Windows\"")
                .build();
        Response response = client.newCall(request).execute();

        System.out.println("createNewPlan api call response: " + response);

        return response;
    }

    public String GetCookieFromLogin() throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().followRedirects(false).build();
        //OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "utf8=✓&authenticity_token=f1M2iVJ2g/WIreQbckxBuJraIO0rvokCGQS5QuaTkRimRNn1W1z19viQ2RpEq9bfgAq4bDN58+X0AmAtsCG4bw==&user[email]=paul.masonjr@workwave.com&user[password]=Hudson27Brooks26Knox11!&commit=Log+In&user[remember_me]=0");
        Request request = new Request.Builder()
                .url("http://slingshot.workwave.dev/login")
                .method("POST", body)
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .addHeader("Accept-Language", "en-US,en;q=0.9")
                .addHeader("Cache-Control", "max-age=0")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Cookie", "_workwave_prod_data_session=c2lOSENqWG1wTjRsR0Z1L3BwU3Z6RVB3SlZsRlNvMk1POGs4V1ZIMTgycllUNGNDdVZDc2dHN2UwUldITEExVGtMMVQrSis2V01hVTNwdjI4aXE2dDBWeDJwRGpkaFRjU1k5LzdRem9OYkhPcXdXdWhKR2VPS2I5UEpZeUpxa1owbERnUzhOS2JtRng4a0xHT2JwSXB4UDc3RDcvd0hnUkhKd1Q2N2FWZ1QxR3I1eWdyL2tENU53bjRrZTg2U3pTMUVTVU9waGJZVVppVjc3SUZUK1VmVWVieityeW1kMXJ3Qk4rb2FSejk5TlMvVXU0T0JMd1REZGNjdWFrcTR5MUJlU3k0eWMrc2NleU9GbzZqN1k4ZlJ5ZlFLMzFPZVc1QlRvbWlFL3BKcGs9LS1LRGxPdHppeGdKOWFmb09RcUo0cGJRPT0%3D--884a0d59288992c77e5ca223e3d1b642438f0881; _workwave_prod_data_session=d2VsK3FkbzBQZHFQNFhtQ3ZWNEl4a0tJR0Zza3R3VkpiSjJqSWtKVUhQd1AvangzUmpDV0tMNEhINVd2MDl0RWZydGlXOTBUR3ZpYVR5MXpVK2pqVEg1enQ5SG5nK1Q5TjdpdUZLSGlJVVdqSm1MMFhOK1E4S2hmTndIUmcvWEs3YnRFZ2FlcnVkSG9sZFhBbzNtVTgwNk1hdWYrRERNclZ4Y00vOG1UaVdVWHM0YVkvVDAyRStPK1hXUWk3M0dBOUo3SnlnN1BKR0xmK25rUmJMQldXVjY2aTQ0UVA4V21TTDQ3RlFyams5VkZBK2o0OU1pWmlrdFV5M1hwQkUyUlNvekluUWhFVHMzTVpHOUl6MXZ4VytPWFhtWkx2alYvYVVlVmMweSt0enJmQzFxa2R6N2JMRENXNnFyNko2M2ZXdlI3Qk9jVUZEK1R2M3BFbG0xb3hBPT0tLUdoRUNIcHBsRUEyNmdOclQxdWY2OVE9PQ%3D%3D--6bb091ac5775a33ab217bafed3d83a9593c40f58")
                .addHeader("Origin", "http://slingshot.workwave.dev")
                .addHeader("Referer", "http://slingshot.workwave.dev/login")
                .addHeader("Sec-Fetch-Dest", "document")
                .addHeader("Sec-Fetch-Mode", "navigate")
                .addHeader("Sec-Fetch-Site", "same-origin")
                .addHeader("Sec-Fetch-User", "?1")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                .addHeader("sec-ch-ua", "\"Google Chrome\";v=\"107\", \"Chromium\";v=\"107\", \"Not=A?Brand\";v=\"24\"")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("sec-ch-ua-platform", "\"Windows\"")
                .build();
        Response response = client.newCall(request).execute();

        System.out.println(response);
        System.out.println("GET COOKIE RESPONSE:  " + response.headers());

        List<String> Cookielist = response.headers().values("Set-Cookie");
        //String cookie = (Cookielist .get(0).split(";"))[0];

        return "test";
    }


}
