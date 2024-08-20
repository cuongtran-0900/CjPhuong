package MODEL;

public class Account {
    private String accountID;
    private String accountRole;

    public Account() {}

    public Account(String accountID, String accountRole) {
        this.accountID = accountID;
        this.accountRole = accountRole;
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
}