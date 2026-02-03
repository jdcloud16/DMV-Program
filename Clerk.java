public class Clerk {

    private static int clerkCounter = 0;
    private boolean isFree;
    private int clerkIDNumber, totalDriversProcessedByClerk, timeRemainingForInterview;
    private Driver assignedDriver;

    // Constructor
    public Clerk() {
        setClerkIDNumber();
        setIsFree(true);
    }

    // Getter/Accessor Methods
    public boolean getIsFree() {
        return isFree;
    }

    public int getClerkIDNumber() {
        return clerkIDNumber;
    }

    public int getTotalDriversProcessedByClerk() {
        return totalDriversProcessedByClerk;
    }

    public int getTimeRemainingForInterview() {
        return timeRemainingForInterview;
    }

    public Driver getAssignedDriver() {
        return assignedDriver;
    }

    // Setters/Mutator Methods
    private void setClerkIDNumber() {
        clerkCounter++;
        this.clerkIDNumber = clerkCounter;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    public void setAssignedDriver(Driver driver) {
        this.assignedDriver = driver;
        setIsFree(false);
    }

    // remove assigned driver from the clerk
    public Driver removeAssignedDriver() {
        Driver tempDriver = this.assignedDriver;
        this.assignedDriver = null;
        setIsFree(true);
        totalDriversProcessedByClerk++;
        return tempDriver;
    }

    // sets the time remaining for the current interview
    public void setTimeRemainingForInterview(int time) {
        this.timeRemainingForInterview = time;
    }

    // decrements the time remaining for the interview
    public void decrementTimeRemainingForInterview() {
        this.timeRemainingForInterview--;
    }

    public String toString() {
        return "Clerk " + clerkIDNumber + " processes " + totalDriversProcessedByClerk + " drivers";
    }
}
