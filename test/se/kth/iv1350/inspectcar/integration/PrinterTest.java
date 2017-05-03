package se.kth.iv1350.inspectcar.integration;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.inspectcar.model.InspectionResults;
import se.kth.iv1350.inspectcar.model.Receipt;

public class PrinterTest {
    Printer instance;
    Receipt receipt;
    
    @Before
    public void setUp() {
        int cost = 150;
        instance = new Printer();
        receipt = new Receipt(cost);
        
    }
    
    @After
    public void tearDown() {
        instance = null;
        receipt = null;
    }
    
    @Test
    public void testPrintReceipt() {
        String expResult = "The receipt says that: " + 150 + ", has been "
                           + "payed for the inspection";
        String result = instance.printReceipt(receipt);
        assertEquals("The cost does not match with the receipt", expResult, result);
    }
    @Test
    public void testPrintResults() {
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Inspection has been completed for inspection # 1");
        expResult.add("Inspection has been completed for inspection # 2");
        expResult.add("Inspection has been completed for inspection # 3");
        expResult.add("Inspection has been completed for inspection # 4");
        expResult.add("All inspections have been completed for this vehicle");
        ArrayList<String> result = new ArrayList<String>();
        InspectionResults inspResults = new InspectionResults(expResult);
        result = instance.printResults(inspResults);
        assertEquals("The inspectionlist is wrong", expResult, result);
        
        
    }
    
}
