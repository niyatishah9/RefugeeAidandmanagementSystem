
package Business.WorkQueue;

/**
 *
 * @author shahla
 */
@SuppressWarnings("unchecked")
public class HelpCareMedicalRequest extends WorkRequest {
    private String NgoMedCampResult;
    private HousesMedicalCampRequest housereq = null;

    public HousesMedicalCampRequest getHmcwr() {
        return housereq;
    }

    public void setHmcwr(HousesMedicalCampRequest hmcwr) {
        this.housereq = hmcwr;
    }

    public String getTestResult() {
        return NgoMedCampResult;
    }

    public void setTestResult(String NgoMedCampResult) {
        this.NgoMedCampResult = NgoMedCampResult;
    }
}
