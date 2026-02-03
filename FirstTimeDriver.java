public class FirstTimeDriver extends Driver {
    private String driverID;

    public FirstTimeDriver(int arrivalTime, License licP) {
        super(arrivalTime);             // call superclass constructor
        setDriverType("FirstTime ");
        setLicense(licP);
        setDriverID();
    }

    @Override
    public void setDriverID() {
        idCounter++;
        // concatenation of "CAL", i.e CAL FirstTime STD353401
        driverID = "CAL " + getDriverType() + getLicense().getLicenseID() + idCounter;
    }

    @Override
    public String getDriverID() {
        return driverID;
    }

    @Override
    public int compareTo(Driver otherDriver) {
        return otherDriver.getDriverType().compareTo(getDriverType());
    }
}
