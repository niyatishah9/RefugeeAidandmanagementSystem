/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author shahla
 */
@SuppressWarnings("unchecked")
public class AmenitiesWorkRequest extends WorkRequest{
    private String amenitiesResult;
    private InventoryWorkRequest ir = null;

    public InventoryWorkRequest getIwr() {
        return ir;
    }

    public void setIwr(InventoryWorkRequest iwr) {
        this.ir = iwr;
    }

    public String getTestResult() {
        return amenitiesResult;
    }

    public void setTestResult(String amenitiesResult) {
        this.amenitiesResult = amenitiesResult;
    }
    
}
