package se.kth.iv1350.inspectcar.integration;

/**
 * Represents an particular control of a vehicle, for example brakes or suspension.
 */
public class InspectionItem {
    private String name;
    private int cost;
    
    /**
     * Creates new instance representing the specified control.
     * 
     * @param name The name of this control.
     * @param cost The cost of this control.
     */
    InspectionItem(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    /**
     * @return The cost of this control.
     */
    public int getCost() {
        return cost;
    }

}
