package MODEL;

public class Account {
    private String accountID;
    private String accountRole;
    private String accountPass;

    public Account() {}

    public Account(String accountID, String accountRole, String accountPass) {
        this.accountID = accountID;
        this.accountRole = accountRole;
        this.accountPass = accountPass;
    }



    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(String accountRole) {
        this.accountRole = accountRole;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID='" + accountID + '\'' +
                ", accountRole='" + accountRole + '\'' +
                '}';
    }

    public String getAccountPass() {
        return accountPass;
    }

    public void setAccountPass(String accountPass) {
        this.accountPass = accountPass;
    }
}