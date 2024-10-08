package MODEL;

import java.sql.Timestamp;
import java.util.List;

public class Bill {
    private String billID;
    private int billTotalAmount;
    private List<BillDetail> billDetailList;
    private String billNote;
    private String accountID;
    private Timestamp createDate;
    private int billpayment;
    private int billStatus;

    public Bill() {}

    public Bill(String billID, int billTotalAmount, List<BillDetail> billDetailList, String billNote, String accountID, Timestamp createDate, int billpayment, int billStatus) {
        this.billID = billID;
        this.billTotalAmount = billTotalAmount;
        this.billDetailList = billDetailList;
        this.billNote = billNote;
        this.accountID = accountID;
        this.createDate = createDate;
        this.billpayment = billpayment;
        this.billStatus = billStatus;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public int getBillTotalAmount() {
        return billTotalAmount;
    }

    public void setBillTotalAmount(int billTotalAmount) {
        this.billTotalAmount = billTotalAmount;
    }

    public List<BillDetail> getBillDetailList() {
        return billDetailList;
    }

    public void setBillDetailList(List<BillDetail> billDetailList) {
        this.billDetailList = billDetailList;
    }

    public String getBillNote() {
        return billNote;
    }

    public void setBillNote(String billNote) {
        this.billNote = billNote;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }


    @Override
    public String toString() {
        return "Bill{" +
                "billID='" + billID + '\'' +
                ", billTotalAmount=" + billTotalAmount +
                ", billDetailList=" + billDetailList +
                ", billNote='" + billNote + '\'' +
                ", accountID='" + accountID + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public int getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(int billStatus) {
        this.billStatus = billStatus;
    }

    public int getBillpayment() {
        return billpayment;
    }

    public void setBillpayment(int billpayment) {
        this.billpayment = billpayment;
    }
}