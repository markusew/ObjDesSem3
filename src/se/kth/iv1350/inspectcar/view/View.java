package se.kth.iv1350.inspectcar.view;

import java.time.YearMonth;
import java.util.ArrayList;
import se.kth.iv1350.garage.Garage;
import se.kth.iv1350.inspectcar.controller.Controller;
import se.kth.iv1350.inspectcar.model.Receipt;
import se.kth.iv1350.payauth.*;
import se.kth.iv1350.inspectcar.integration.Printer;
import se.kth.iv1350.inspectcar.model.Inspection;
import se.kth.iv1350.inspectcar.model.InspectionResults;
import se.kth.iv1350.inspectcar.model.Vehicle;

/**
 * This class is a placeholder for the view.
 */
public class View {
    private Controller contr;
    
    /**
     * Creates a new instance that will use the specified controller for all system operations.
     * 
     * @param contr The controller to use for system operations.
     */
    public View(Controller contr) {
        this.contr = contr;
        //this.garage = garage;
    }
    
    /**
     * Calls all system operations and prints the result to <code>System.out</code>.
     */
    public void sampleExecution() {
        
        //Testing the nextCustomer and close door command
        contr.garage.nextCustomer();
        contr.garage.closeDoor();
        System.out.println("The door was opened, the display incremented by one"
                         + " and the door was closed successfully.");
        
        System.out.println("");
        
        //Testing the registration of a vehicle and the cost for the inspection 
        String regNoOfVehicleToInspect = "ABC123";
        int cost = contr.enterRegNo(regNoOfVehicleToInspect);
        System.out.println("The cost for the inspection is: " + cost);
        
        System.out.println("");
        
        //Hard Coded customer
        int pin = 1234;
        String number = "5555 6666 7777 8888";
        String holder = "Ben Bensson";
        YearMonth expiryDate = YearMonth.now();
        int CVC = 987;
        
        //Testing the payment authorization (always returns true)
        CreditCard creditCard = new CreditCard(pin, number, holder, expiryDate, CVC);
        System.out.println("The payment sucessfully went through: " + contr.payment.authorizePayment(creditCard, cost));
        
        System.out.println("");
        
        //Printing a dummy receipt
        Receipt receipt = new Receipt(cost);
        System.out.println(contr.printer.printReceipt(receipt));
        
        System.out.println("");
        
        //Adding inspection results to a list and printing out results
        ArrayList<String> results = new ArrayList<String>(); 
        Vehicle vehicle = new Vehicle(regNoOfVehicleToInspect);
        Inspection inspection = new Inspection(vehicle, contr.dbMgr);
        for (int i = 0; i < 5; i++){
            results.add(inspection.inspectPart());
        }
        for ( String inspections : results){
            System.out.println(inspections);
        }
        
        System.out.println("");
        
        //Printing results from inspection
        InspectionResults inspResults = new InspectionResults(results);
        ArrayList<String> printResults = new ArrayList<String>();
        printResults = contr.printer.printResults(inspResults);
        for ( String inspections : printResults){
            System.out.println(inspections);
        }
        
        
        
        
    }
}
