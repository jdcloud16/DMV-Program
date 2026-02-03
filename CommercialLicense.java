public class CommercialLicense extends License{

    private static int commercialCounter  = 0;
    private String licenseID;
    private final double commLicenseCost = 125.75;

    // Constructor
    public CommercialLicense() {
        super("Commercial");        // call the superclass constructor
        setLicenseID();
    }

    @Override
    public void setLicenseID() {
        commercialCounter++;
        this.licenseID = "COMM" + commercialCounter;    // set licenseID to the concatenation of "COMM" and comericalCounter
    }

    @Override
    public String getLicenseID() {
        return licenseID;
    }

    @Override
    public double getLicenseCost() {
        return commLicenseCost;
    }
}
