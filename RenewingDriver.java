public class RenewingDriver extends Driver{

    private String driverID;

    // Constructor
    public RenewingDriver(int arrivalTime, License licP) {
        super(arrivalTime);         // call superclass constructor
        setDriverType("Renewing");
        setLicense(licP);
        setDriverID();
    }

    @Override
    public void setDriverID() {
        idCounter++;
        // concatenation of "CAL", i.e CAL Renewing COMM114756
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
