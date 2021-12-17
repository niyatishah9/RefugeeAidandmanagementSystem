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
public class FundsWorkRequest extends WorkRequest{
    private String fundResultstatus;
    private int prices;
    private int amountFundreceived;

    public int getAmountFunded() {
        return amountFundreceived;
    }

    public void setAmountFunded(int amountFunded) {
        this.amountFundreceived = amountFunded;
    }

    public String getFundResult() {
        return fundResultstatus;
    }

    public void setFundResult(String fundResult) {
        this.fundResultstatus = fundResult;
    }

    public int getAmount() {
        return prices;
    }

    public void setAmount(int amount) {
        this.prices = amount;
    }

    public String getTestResult() {
        return fundResultstatus;
    }

    public void setTestResult(String fundResult) {
        this.fundResultstatus = fundResult;
    }
}
