package se.kth.iv1350.inspectcar.model;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.inspectcar.integration.DatabaseManager;
import se.kth.iv1350.inspectcar.integration.InspectionItem;

/**
 * Represents an inspection of a vehicle.
 */
public class Inspection {
    private final Vehicle vehicle;
    private List<InspectionItem> inspections;
    private int inspectionNumber = 1;

    /**
     * Creates a new instance, representing an inspection of the specified vehicle.
     *
     * @param vehicle The vehicle that is inspected.
     * @param dbMgr   The database manager to use when searching for inspections for the specified
     *                vehicle.
     */
    public Inspection(Vehicle vehicle, DatabaseManager dbMgr) {
        this.vehicle = vehicle;
        this.inspections = dbMgr.findInspectionsByVehicle(vehicle);
    }

    /**
     * @return The cost of this inspection.
     */
    public int getCost() {
        int totalCost = 0;
        if (inspections == null) {
            return 0;
        }
        for (InspectionItem inspItem : inspections) {
            totalCost = totalCost + inspItem.getCost();
        }
        return totalCost;
    }
    /**
     * Returns that an inspection has been completed and 
     * 
     * @return 
     */
    public String inspectPart(){
        String noInspections = "No inspections were found for this vehicle";
        String noMoreInspections = "All inspections have been completed for "
                                 + "this vehicle";
        String inspectionComplete = "Inspection has been completed for "
                                  + "inspection # " + 
                                   Integer.toString(inspectionNumber);
        if(this.inspections == null){
           return noInspections;
        }
        else if (inspectionNumber > this.inspections.size()){
            return noMoreInspections;
        }
        else{
            inspectionNumber++;
        return inspectionComplete;
        }
        
    }
}
