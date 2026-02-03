public abstract class License {
    private String licenseType;

    // Default constructor w/ single parameter for license type
    public License(String licenseType) {
        setLicenseType(licenseType);
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    // abstract methods, will later be implemented in subclasses
    public abstract void setLicenseID();        // set license ID

    public abstract String getLicenseID();      // get license ID

    public abstract double getLicenseCost();    // get the license cost

}
