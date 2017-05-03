package se.kth.iv1350.inspectcar.controller;

import se.kth.iv1350.garage.Garage;
import se.kth.iv1350.inspectcar.integration.DatabaseManager;
import se.kth.iv1350.inspectcar.integration.Printer;
import se.kth.iv1350.inspectcar.model.Inspection;
import se.kth.iv1350.inspectcar.model.Vehicle;
import se.kth.iv1350.payauth.PaymentAuthorization;

/**
 * This is the application's single controller. All calls to the model pass through here.
 */
public class Controller {
    public DatabaseManager dbMgr;
    public Garage garage;
    public Printer printer;
    public PaymentAuthorization payment;

    /**
     * Creates a new instance using the specified database manager, garage, 
     * printer and payment authorization system.
     *
     * @param dbMgr The database manager used for all database calls.
     * @param garage is used to open and close the garage.
     * @param printer is used to print receipts and result from inspection.
     * @param payment This is the PaymentAuthorization system used to verify
     * credit card payments.
     */
    public Controller(DatabaseManager dbMgr, Garage garage, Printer printer, PaymentAuthorization payment) {
        this.dbMgr = dbMgr;
        this.garage = garage;
        this.printer = printer;
        this.payment = payment;
    }

    /**
     * Verifies that there are inspections to perform for the vehicle with the specified
     * registration number. If there are inspections, returns the total cost for the inspections.
     * Returns 0 if there are no inspections to perform. This will instead be indicated with an
     * exception in a future version.
     *
     * @param regNo The registration number of the vehicle to inspect.
     * @return The total cost for the inspections, or 0 if there are no inspections to perform.
     */
    public int enterRegNo(String regNo) {
        Vehicle vehicle = new Vehicle(regNo);
        Inspection inspection = new Inspection(vehicle, dbMgr);
        return inspection.getCost();
    }
}
