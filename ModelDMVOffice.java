import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class ModelDMVOffice {

    // This was not in the prompt, but I wanted to test and see if it would print out when adding
    // into the file. This method prints the contents
    public static void printFileContents(String fileName) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.printf(line);
            }
        }
    }

    // main
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);

        // Request and read in the officeName
        System.out.printf("Enter the name of the DMV Office: ");
        String officeName = keyboard.nextLine();

        // Request and read in the seed value
        System.out.printf("Enter a seed value as an int: ");
        int seed = keyboard.nextInt();

        // Request and read in the number of clerks
        System.out.printf("Enter the number of clerks as an int: ");
        int numClerks = keyboard.nextInt();

        // Create a newDMVOffice with the given values
        DMVOffice dmvOffice = new DMVOffice(officeName, seed, numClerks);
        dmvOffice.openDMVOfficeLine();      // call openDMVOfficeLine for the created DMVOffice

        // Request and read in the duration for arriving
        System.out.printf("Enter the number of minutes to keep entrance open after the office opens: ");
        int durationForArriving = keyboard.nextInt();

        dmvOffice.operateDMVOffice(durationForArriving);
        System.out.printf("Enter the name of the output file for DMV Office results: ");
        keyboard.nextLine();
        String outputFile = keyboard.nextLine();
        dmvOffice.generateDMVOfficeResults(outputFile);
        printFileContents(outputFile);
    }
}
