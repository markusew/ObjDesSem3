package se.kth.iv1350.inspectcar.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.inspectcar.model.Vehicle;

/**
 * This class is responsible for database calls. This is the only place the database is called.
 */
public class DatabaseManager {
    private List<InspectionItem> dummyInspectionList;

    /**
     * Creates a new instance, which uses a hard coded list of inspections instead of calling a
     * database.
     */
    public DatabaseManager() {
        createDummyInspections();
    }

    /**
     * Searches the database for inspections to be performed on the specified vehicle. This dummy
     * implementation return the same, hard coded, inspections for all vehicles.
     *
     * @param vehicle The vehicle to inspect.
     * @return A list of <code>InspectionItem</code>s, where each element describes one particular
     *         control.
     */
    public List<InspectionItem> findInspectionsByVehicle(Vehicle vehicle) {
        return dummyInspectionList;
    }

    private void createDummyInspections() {
        dummyInspectionList = new ArrayList<>();
        dummyInspectionList.add(new InspectionItem("brakes", 10));
        dummyInspectionList.add(new InspectionItem("suspension", 20));
        dummyInspectionList.add(new InspectionItem("stearing", 30));
    }

}
