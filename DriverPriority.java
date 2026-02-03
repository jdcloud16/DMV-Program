import java.util.Comparator;

public class DriverPriority implements Comparator<Driver> {
    @Override
    // compare the driver types of two drivers
    public int compare(Driver d1, Driver d2) {
        int driverTypeComparison = d1.getDriverType().compareTo(d2.getDriverType());

        if(driverTypeComparison == 0) {
            // return a negative, 0, or positive value based on the difference in arrival times
            // meaning earlier driver has higher priority
            return d1.getTotalTimeAtDMV() - d2.getArrivalTimeAtDMV();
        } else {
            // otherwise, return the result of the driver type comparison
            return driverTypeComparison;
        }
    }
}
