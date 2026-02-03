public class SeniorDriver extends Driver{

    private String driverID;

    // Constructor
    public SeniorDriver(int arrivalTime, License licP) {
        super(arrivalTime);         // call superclass constructor
        setDriverType("Senior");
        setLicense(licP);
        setDriverID();
    }

    @Override
    public String getDriverID() {
        return driverID;
    }

    @Override
    public void setDriverID() {
        idCounter++;
        // concatenation of "CAL", i.e CAL Senior STD3036
        driverID = "CAL " + getDriverType() + getLicense().getLicenseID() + idCounter;
    }

    @Override
    public int compareTo(Driver otherDriver) {
        // Compare drivers based on driverType in reverse order
        return otherDriver.getDriverType().compareTo(getDriverType());
    }
}
