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
public class HousesMedicalCampRequest extends WorkRequest{
    private String hosMedCampResult;
    private HelpCareMedicalRequest nmcwr = null;

    public HelpCareMedicalRequest getNmcwr() {
        return nmcwr;
    }

    public void setNmcwr(HelpCareMedicalRequest nmcwr) {
        this.nmcwr = nmcwr;
    }

    public String getTestResult() {
        return hosMedCampResult;
    }

    public void setTestResult(String hosMedCampResult) {
        this.hosMedCampResult = hosMedCampResult;
    }
}
