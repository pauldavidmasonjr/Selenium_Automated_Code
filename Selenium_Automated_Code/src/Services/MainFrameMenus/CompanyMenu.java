package Services.MainFrameMenus;

import Services.WebApp.WebAppService;
import Services.WebApp.WebAppService;
import org.json.JSONException;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompanyMenu {

    public static void displayMenu() throws IOException, JSONException, ParseException {
        System.out.println("-----------------------------------------------\n");
        System.out.println("---- Company Menu ----\n");

        System.out.println("Select the task you wish to perform:\n\n" +
                "\t\t[p]  Price Update \n" +
                "\t\t[s]  Service Update \n" +
                "\t\t[b]  Back to Main Menu\n"
        );

        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        // Reading data using readLine
        String menuSelection = reader.readLine();

        // Printing the read line
        System.out.println(menuSelection);

        switch(menuSelection) {
            case "p":
                System.out.println("Running Price Update Program ...\n\n");
                System.out.println("Company ID:");
                String companyID = reader.readLine();
                System.out.println("Plan ID:");
                String planID = reader.readLine();
                System.out.println("Comany ID: " + companyID + "   Plan ID: " + planID);
                WebAppService.GetSpecificPlan(planID, companyID);
                displayMenu();
                break;
            case "s":
                System.out.println("Running Service Update Program ...\n\n");
                displayMenu();
                break;
            case "b":
                System.out.println("Returning to Main Menu ...\n\n");
                MainMenu.displayMenu();
                break;
            default:
                // code block
                System.out.println("That is not a valid option. Please select a different option ...");
                displayMenu();
        }
    }
}
