public abstract class Driver implements Comparable<Driver> {

    protected static int idCounter = 0; // will be implemented/needed in Driver subclasses
    private int arrivalTimeAtDMV, clerkStartTime, waitTime, interviewDuration, totalTimeAtDMV;
    private String driverType;
    private License license;

    // Constructor
    public Driver(int arrivalTime) {
        setArrivalTimeAtDMV(arrivalTime);
    }

    // Getter/Accessor methods
    public int getArrivalTimeAtDMV() {
        return arrivalTimeAtDMV;
    }

    public int getClerkStartTime() {
        return clerkStartTime;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public int getInterviewDuration() {
        return interviewDuration;
    }

    public int getTotalTimeAtDMV() {
        return totalTimeAtDMV;
    }

    public String getDriverType() {
        return driverType;
    }

    public License getLicense() {
        return license;
    }

    // Setters/Mutator Methods
    public void setArrivalTimeAtDMV(int arrivalTimeAtDMV) {
        this.arrivalTimeAtDMV = arrivalTimeAtDMV;
    }

    public void setInterviewDuration(int interviewDuration) {
        this.interviewDuration = interviewDuration;
    }

    public void setClerkStartTime(int clerkStartTime) {
        this.clerkStartTime = clerkStartTime;
        this.waitTime = clerkStartTime - arrivalTimeAtDMV;
    }

    public void setTotalTimeAtDMV(int endTime) {
        this.totalTimeAtDMV = endTime - arrivalTimeAtDMV;
    }

    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    // abstract methods
    public abstract void setDriverID();     // sets driver's ID

    public abstract String getDriverID();   // returns driver's ID

    public abstract int compareTo(Driver otherDriver);  // compareTo method, comparing drivers
}
