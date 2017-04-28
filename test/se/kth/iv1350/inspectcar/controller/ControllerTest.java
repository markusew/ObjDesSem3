package se.kth.iv1350.inspectcar.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.inspectcar.integration.DatabaseManager;

public class ControllerTest {
    private DatabaseManager dbMgr;
    private Controller instance;

    @Before
    public void setUp() {
        dbMgr = new DatabaseManager();
        instance = new Controller(dbMgr);
    }

    @After
    public void tearDown() {
        dbMgr = null;
        instance = null;
    }

    @Test
    public void testCostWhenThereAreInspections() {
        String existingRegNo = "ABC123";
        int expResult = 60;
        int result = instance.enterRegNo(existingRegNo);
        assertEquals("Wrong cost when inspections were found", expResult, result);
    }

    @Test
    public void testCostWhenThereAreNoInspections() {
        String nonExistingRegNo = "ABC124";
        int expResult = 0;
        int result = instance.enterRegNo(nonExistingRegNo);
        assertEquals("Wrong cost when there were no inspections.", expResult, result);
    }
}
