import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class DMVOffice {
    private Random randy;
    private PriorityQueue<Driver> waitingQ;
    private ArrayList<Driver> processedDrivers = new ArrayList<>();
    private Clerk[] clerks;
    private String officeName;
    private int currentTime = 0;

    // Constructor
    public DMVOffice(String name, int seed, int numClerks) {
        officeName = name;
        waitingQ = new PriorityQueue<>(new DriverPriority());
        randy = new Random(seed);
        createClerks(numClerks);
    }

    // clerk array with a length equal to the number of clerks
    private void createClerks(int numClerks) {
        clerks = new Clerk[numClerks];
        for (int i = 0; i < numClerks; i++) {
            clerks[i] = new Clerk();
        }
    }

    // simulates early arriving Drivers
    public void openDMVOfficeLine() {
        for (currentTime = 0; currentTime < 5; currentTime++) {
            for (int i = 0; i < 12; i++) {
                int randomNumber = randy.nextInt(30) + 1;
                if (randomNumber < 4) {
                    waitingQ.add(new RenewingDriver(currentTime, new CommercialLicense()));
                } else if (randomNumber < 20) {
                    waitingQ.add(new RenewingDriver(currentTime, new StandardLicense()));
                } else if (randomNumber < 21) {
                    waitingQ.add(new SeniorDriver(currentTime, new CommercialLicense()));
                } else if (randomNumber < 24) {
                    waitingQ.add(new SeniorDriver(currentTime, new StandardLicense()));
                } else {
                    waitingQ.add(new FirstTimeDriver(currentTime, new StandardLicense()));
                }
            }
        }
    }

    // processing Drivers in the queue and working with Clerks
    public void operateDMVOffice(int durationForArriving) {
        int endArrivalsTime = currentTime + durationForArriving;
        Driver tempDriver;

        // main loop to process arriving Drivers and manage Clerks
        while (processedDrivers.size() != Driver.idCounter || currentTime < endArrivalsTime) {
            if (currentTime < endArrivalsTime) {

                // check on the busy clerks
                for (int i = 0; i < 8; i++) {
                    int randomNumber = randy.nextInt(30) + 1;
                    if (randomNumber < 4) {
                        waitingQ.add(new RenewingDriver(currentTime, new CommercialLicense()));
                    } else if (randomNumber < 16) {
                        waitingQ.add(new RenewingDriver(currentTime, new StandardLicense()));
                    } else if (randomNumber < 18) {
                        waitingQ.add(new SeniorDriver(currentTime, new CommercialLicense()));
                    } else if (randomNumber < 24) {
                        waitingQ.add(new SeniorDriver(currentTime, new StandardLicense()));
                    } else {
                        waitingQ.add(new FirstTimeDriver(currentTime, new StandardLicense()));
                    }
                }
            }

            // assign Drivers to free Clerks
            for (Clerk clerk : clerks) {
                if (!clerk.getIsFree()) {
                    clerk.decrementTimeRemainingForInterview();
                    if (clerk.getTimeRemainingForInterview() == 0) {
                        tempDriver = clerk.removeAssignedDriver();
                        processedDrivers.add(tempDriver);
                        tempDriver.setTotalTimeAtDMV(currentTime);
                    }
                }
            }

            for (Clerk clerk : clerks) {
                if (clerk.getIsFree() && !waitingQ.isEmpty()) {
                    tempDriver = waitingQ.poll();
                    tempDriver.setClerkStartTime(currentTime);
                    int interviewDuration = randy.nextInt(4) + 1;
                    tempDriver.setInterviewDuration(interviewDuration);
                    clerk.setAssignedDriver(tempDriver);
                    clerk.setTimeRemainingForInterview(interviewDuration);
                }
            }
            currentTime++;
        }
    }

    // generates results and writes them to a file
    public void generateDMVOfficeResults(String fileName) throws IOException {
        PrintWriter outputFile = new PrintWriter(new File(fileName));
        outputFile.printf("Results for %s\n", officeName);
        outputFile.printf("Total Number of Drivers Processed: %d\n", Driver.idCounter);

        int totalTime = 0;
        for (Driver driver : processedDrivers) {
            totalTime += driver.getTotalTimeAtDMV();
        }

        outputFile.printf("Average Time Spent by Drivers: %.2f\n", (double) totalTime / Driver.idCounter);

        outputFile.printf("Clerk results:\n");
        for (Clerk clerk : clerks) {
            outputFile.printf("%s\n", clerk.toString());
        }

        outputFile.close();
    }
}

