package Services.WebApp;

import Utility.requestBodyCreation;
import Objects.WebApp.Plan;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationFeature;
import net.projectmonkey.object.mapper.ObjectMapper;
import okhttp3.*;
import Utility.Credentials;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WebAppService {

    public Response createNewPlan(Plan newPlan) throws IOException, InterruptedException {
        //get cookie
        //System.out.println("------------------------------------------   Calling GetCookieFromLogin()");
        //String cookie = this.GetCookieFromLogin();
        //SeleniumAutomation.createFullPlan(newPlan, newPlan.getCompanyName());

        //System.out.println("COKKIE: " + cookie);


        String convertedPostBody = requestBodyCreation.createPostBodyFromPlan(newPlan);

        System.out.println("POST BODY:" + convertedPostBody);

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, convertedPostBody);
        Request request = new Request.Builder()
                .url("https://slingshot.workwave.dev/api/companies/"+newPlan.getCompanyId()+"/plans")
                .method("POST", body)
                .addHeader("Accept", "application/json, text/plain, */*")
                .addHeader("Accept-Language", "en-US,en;q=0.9")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "_workwave_prod_data_session=" + Credentials.cookie)
                .addHeader("Origin", "https://slingshot.workwave.dev")
                .addHeader("Referer", "https://slingshot.workwave.dev/companies/"+newPlan.getCompanyId()+"/plans/new")
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

    public static Response GetSpecificPlan(String planId, String companyId) throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        //RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://slingshot.workwave.dev/api/plans/"+planId)
                .addHeader("Accept", "application/json, text/plain, */*")
                .addHeader("Accept-Language", "en-US,en;q=0.9")
                .addHeader("Connection", "keep-alive")
                .addHeader("Cookie", "_workwave_prod_data_session=" + Credentials.cookie)
                .addHeader("Referer", "https://slingshot.workwave.dev/plans/" + planId)
                .addHeader("Sec-Fetch-Dest", "empty")
                .addHeader("Sec-Fetch-Mode", "cors")
                .addHeader("Sec-Fetch-Site", "same-origin")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                .addHeader("X-CSRF-Token", "nDPOASsObY8lbTyEef2ZM4RfUOo8ddkFWSTp2qgiawaLMgJkYVd4gj5HjyRG+6mV/50ggHCzVereeEJ1xy3ljg==")
                .addHeader("sec-ch-ua", "\"Google Chrome\";v=\"107\", \"Chromium\";v=\"107\", \"Not=A?Brand\";v=\"24\"")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("sec-ch-ua-platform", "\"Windows\"")
                .build();
        Response response = client.newCall(request).execute();

        //String jsonBody = response.body().string();
        //JSONObject jsonObject = new JSONObject(response.body().string());
        String path = "src/Plan_JSON_Files/"+companyId+"/"+planId+".json";
        //add response to json file to allow for price updates
        if (Files.exists(Path.of("src/Plan_JSON_Files/"+planId+"/"+planId))) {
            System.out.println("Found EXISTING company folder ...");
            //update file
            File file=new File("src/Plan_JSON_Files/"+companyId+"/"+planId);
            DataOutputStream outstream= new DataOutputStream(new FileOutputStream(file,false));
            String body = response.body().string();
            outstream.write(body.getBytes());
            outstream.close();
        } else {
            System.out.println("Creating NEW Directory");
            //create new file
            new File("src/Plan_JSON_Files/"+planId).mkdirs();
            File myObj = new File("src/Plan_JSON_Files/"+companyId+"/"+planId+".json");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                //JSONParser parser = new JSONParser();
                //JSONObject json = (JSONObject) parser.parse(response.toString())
                Files.writeString(Path.of(path), response.body().string());
            } else {
                System.out.println("File already exists.");
                DataOutputStream outstream= new DataOutputStream(new FileOutputStream(myObj,false));
                String body = response.body().string();
                outstream.write(body.getBytes());
                outstream.close();
            }
        }

        return response;
    }

    public static Response UpdatePlan(String planId, String companyId) throws IOException {
        //read json string from file
        String planUpdatedJson = FileUtils.readFileToString(new File("src/Plan_JSON_Files/"+companyId+"/"+planId+".json"), StandardCharsets.UTF_8);

        System.out.println("PLAN JSON STRING: " + planUpdatedJson);

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, planUpdatedJson);
        Request request = new Request.Builder()
                .url("https://slingshot.workwave.dev/api/plans/"+planId)
                .method("PUT", body)
                .addHeader("Accept", "application/json, text/plain, */*")
                .addHeader("Accept-Language", "en-US,en;q=0.9")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "_workwave_prod_data_session=" + Credentials.cookie)
                .addHeader("Origin", "https://slingshot.workwave.dev")
                .addHeader("Referer", "https://slingshot.workwave.dev/plans/"+planId+"/edit")
                .addHeader("Sec-Fetch-Dest", "empty")
                .addHeader("Sec-Fetch-Mode", "cors")
                .addHeader("Sec-Fetch-Site", "same-origin")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                .addHeader("X-CSRF-Token", "nDPOASsObY8lbTyEef2ZM4RfUOo8ddkFWSTp2qgiawaLMgJkYVd4gj5HjyRG+6mV/50ggHCzVereeEJ1xy3ljg==")
                .addHeader("sec-ch-ua", "\"Google Chrome\";v=\"107\", \"Chromium\";v=\"107\", \"Not=A?Brand\";v=\"24\"")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("sec-ch-ua-platform", "\"Windows\"")
                .build();
        Response response = client.newCall(request).execute();

        System.out.println(response);

        return response;
    }
}
