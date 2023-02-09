package Services.MainFrameMenus;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {

    public static void displayMenu() throws IOException, ParseException, JSONException {
        System.out.println("-----------------------------------------------\n");
        System.out.println("Welcome to the Webbapp Main Frame Application\n");

        System.out.println("Select the task you wish to perform:\n\n" +
                                "\t\t[h]  Hello World \n" +
                                "\t\t[c]  Company Update \n" +
                                "\t\t[q]  QUIT PROGRAM"
        );

        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        // Reading data using readLine
        String menuSelection = reader.readLine();

        // Printing the read line
        //System.out.println(menuSelection);

        switch(menuSelection) {
            case "h":
                System.out.println("Hello World\n\n");
                displayMenu();
                break;
            case "c":
                System.out.println("Going to Company Menu ...\n\n");
                CompanyMenu.displayMenu();
                break;
            case "q":
                System.out.println("GOOD BYE ....\n\n");
                break;
            default:
                // code block
                System.out.println("That is not a valid option. Please select a different option ...");
                displayMenu();
        }

    }
}
