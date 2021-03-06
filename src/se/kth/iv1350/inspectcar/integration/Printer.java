package se.kth.iv1350.inspectcar.integration;

import java.util.ArrayList;
import se.kth.iv1350.inspectcar.model.InspectionResults;
import se.kth.iv1350.inspectcar.model.Receipt;

/**
 *A printer that is used to print receipts from the payment and results
 * from the inspection
 */
public class Printer {
    String dummyReceipt;
    String dummyResults;
    
    /**
     * Returns the cost for the Inspection as a String
     * 
     * @param receipt is the receipt holds the information about the payment.
     * 
     * @return String containing payment information
     */
    public void printReceipt(Receipt receipt){
        dummyReceipt = "The receipt says that: " + receipt.cost + ", has been "
                     + "payed for the inspection";
        System.out.println(dummyReceipt);
    }
    
    /**
     * Return the ArrayList stored in InspectionResults
     * 
     * @param results holds the result in a ArrayList
     * 
     * @return the arrayList that was contained within the InspectionResults
     * object
     */
    public ArrayList<String> printResults(InspectionResults results){
        return results.results;
    }
}

