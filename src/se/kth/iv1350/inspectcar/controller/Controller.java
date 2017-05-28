package se.kth.iv1350.inspectcar.controller;

import java.util.ArrayList;
import se.kth.iv1350.garage.Garage;
import se.kth.iv1350.inspectcar.integration.DatabaseManager;
import se.kth.iv1350.inspectcar.integration.Printer;
import se.kth.iv1350.inspectcar.model.Inspection;
import se.kth.iv1350.inspectcar.model.InspectionResults;
import se.kth.iv1350.inspectcar.model.Receipt;
import se.kth.iv1350.inspectcar.model.Vehicle;
import se.kth.iv1350.payauth.CreditCard;
import se.kth.iv1350.payauth.PaymentAuthorization;

/**
 * This is the application's single controller. All calls to the model pass through here.
 */
public class Controller {
    private DatabaseManager dbMgr;
    private Garage garage;
    private Printer printer;
    private PaymentAuthorization payment;

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
    
    /**
     * Method that calls the garage class for when a new customer arrives.
     */
    public void newCustomer(){
        garage.nextCustomer();
        garage.closeDoor();
    }
    /**
     * Method that sends the receipt to the printer class so it is printer out.
     * 
     * @param receipt has information about the pruchase.
     */
    public void printReceipt(Receipt receipt){  
        printer.printReceipt(receipt);
    }
    
    /**
     * Method that confirms if a payment was successful or not
     * 
     * @param creditCard is the creditcard used for the purchase
     * @param cost is the cost for the inspection
     * 
     * @return Boolean that states if the purchase was completed or not
     */
    public boolean confirmPayment(CreditCard creditCard, int cost){
        return payment.authorizePayment(creditCard, cost);
    }
    /**
     * Method that sends the results to the printer
     * 
     * @param results are the results from the inspection
     * 
     * @return An arraylist containing the results. 
     */
    public ArrayList<String> printResults(InspectionResults results){
        return printer.printResults(results);
    }
    
    /**
     * Creates an Inspection object. 
     * 
     * @param vehicle is the vehicle up for inspection
     * 
     * @return returns the created object
     */
    public Inspection createInspection(Vehicle vehicle){
        Inspection inspection2 = new Inspection(vehicle, dbMgr);
        return inspection2;
    }   
}
