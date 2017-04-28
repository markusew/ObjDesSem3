package se.kth.iv1350.inspectcar.integration;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.inspectcar.model.Vehicle;

public class DatabaseManagerTest {
    DatabaseManager instance;
    Vehicle vehicleToInspect;
    
    @Before
    public void setUp() {
        String existingRegNo = "ABC123";
        vehicleToInspect = new Vehicle(existingRegNo);
        instance = new DatabaseManager();
    }

    @After
    public void tearDown() {
        instance = null;
        vehicleToInspect = null;
    }

    @Test
    public void testNumberOfFoundInspections() {
        int expResult = 3;
        int result = instance.findInspectionsByVehicle(vehicleToInspect).size();
        assertEquals("Wrong number of inspection items", expResult, result);
    }
    
    @Test
    public void testCorrectInspectionsFound() {
        List<InspectionItem> expResult = new ArrayList<>();
        expResult.add(new InspectionItem("brakes", 10));
        expResult.add(new InspectionItem("suspension", 20));
        expResult.add(new InspectionItem("stearing", 30));

        List<InspectionItem> result = instance.findInspectionsByVehicle(vehicleToInspect);
        for (int i=0; i<expResult.size(); i++) {
            assertEquals(expResult.get(i), result.get(i));
        }
    }
}
