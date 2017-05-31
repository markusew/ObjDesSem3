package se.kth.iv1350.inspectcar.model;

import java.util.ArrayList;

/**
 * This class represents the results of the inspection
 */
public class InspectionResults {
    public ArrayList<String> results;
    /**
     * Creates a list containing inspection results
     * 
     * @param results are the results from the inspection
     */
    public InspectionResults(ArrayList<String> results){
        this.results = results;
    }
    public ArrayList<String> getInspectionResults(){
        return this.results;
    }
}
