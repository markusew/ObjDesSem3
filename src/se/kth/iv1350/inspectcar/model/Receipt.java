package se.kth.iv1350.inspectcar.model;

/**
 *This class represents the Receipt that is given from each payment.
 */
public class Receipt {
    public int cost;
    /**
     * Creates a receipt containing the cost from the inspection.
     * 
     * @param cost is the total cost from the inspection
     */
    public Receipt(int cost){
        this.cost = cost;
    }
    //public Receipt()
    
}
