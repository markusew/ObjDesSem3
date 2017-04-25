package se.kth.iv1350.inspectcar.model;

import se.kth.iv1350.inspectcar.integration.DatabaseManager;

/**
 * Represents an inspection of a vehicle.
 */
public class Inspection {
    private final Vehicle vehicle;
    private final DatabaseManager dbMgr;

    /**
     * Creates a new instance, representing an inspection of the specified vehicle.
     *
     * @param vehicle The vehicle that is inspected.
     * @param dbMgr   The database manager to use when searching for inspections for the specified
     *                vehicle.
     */
    public Inspection(Vehicle vehicle, DatabaseManager dbMgr) {
        this.vehicle = vehicle;
        this.dbMgr = dbMgr;
    }
}
