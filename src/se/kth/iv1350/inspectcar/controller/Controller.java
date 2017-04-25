package se.kth.iv1350.inspectcar.controller;

import se.kth.iv1350.inspectcar.integration.DatabaseManager;
import se.kth.iv1350.inspectcar.model.Inspection;
import se.kth.iv1350.inspectcar.model.Vehicle;

/**
 * This is the application's single controller. All calls to the model pass through here.
 */
public class Controller {
    private DatabaseManager dbMgr;

    /**
     * Creates a new instance using the specified database manager.
     *
     * @param dbMgr The database manager used for all database calls.
     */
    public Controller(DatabaseManager dbMgr) {
        this.dbMgr = dbMgr;
    }

    /**
     * Verifies that there are inspections to perform for the vehicle with the specified
     * registration number. If there are inspections, returns the total cost for the inspections.
     * Returns null if there are no inspections to perform.
     *
     * @param regNo The registration number of the vehicle to inspect.
     * @return The total cost for the inspections, or null if there are no inspections to perform.
     */
    public int enterRegNo(String regNo) {
        Vehicle vehicle = new Vehicle(regNo);
        Inspection inspection = new Inspection(vehicle, dbMgr);
        return inspection.getCost();
    }

}
