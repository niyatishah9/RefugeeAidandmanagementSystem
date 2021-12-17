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
public class MedicalCamp extends WorkRequest {
    private String campResult;
    private HousesMedicalCampRequest hmcwr = null;

    public HousesMedicalCampRequest getHmcwr() {
        return hmcwr;
    }

    public void setHmcwr(HousesMedicalCampRequest hmcwr) {
        this.hmcwr = hmcwr;
    }

    public String getTestResult() {
        return campResult;
    }

    public void setTestResult(String campResult) {
        this.campResult = campResult;
    }
}
