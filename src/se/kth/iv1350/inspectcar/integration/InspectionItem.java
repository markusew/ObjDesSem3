package se.kth.iv1350.inspectcar.integration;

/**
 * Represents an particular control of a vehicle, for example brakes or suspension.
 */
public class InspectionItem {
    private final String name;
    private final int cost;

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

    /**
     * @return True if the specified object is considered to represent the same inspection item as
     *         this object.
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof InspectionItem)) {
            return false;
        }
        InspectionItem otherInspItem = (InspectionItem) other;
        return otherInspItem.cost == this.cost && otherInspItem.name == this.name;
    }
}
