public class StandardLicense extends License{

    private static int standardCounter = 0;
    private String licenseID;
    private final double stdLicenseCost = 32.50;

    // Constructor
    public StandardLicense() {
        super("Standard");      // call the superclass constructor
        setLicenseID();
    }

    @Override
    public void setLicenseID() {
        standardCounter++;
        this.licenseID = "STD" + standardCounter;   // set licenseID to the concatenation of "STD" and standardCounter
    }

    @Override
    public String getLicenseID() {
        return licenseID;
    }

    @Override
    public double getLicenseCost() {
        return stdLicenseCost;
    }
}
