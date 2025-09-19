// Account 類別：代表銀行帳戶
public class Account {
    // 帳號，識別每個帳戶
    private String accountNumber;
    // 帳戶餘額
    private double balance;

    // 建構子：初始化帳號與初始餘額
    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber; // 設定帳號
        this.balance = initialBalance;      // 設定初始餘額
    }

    // 取得帳號
    public String getAccountNumber() {
        return accountNumber;
    }

    // 取得帳戶餘額
    public double getBalance() {
        return balance;
    }

    // 存款方法：金額必須大於 0
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount; // 增加餘額
        } else {
            // 若金額不合法則丟出例外
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }

    // 提款方法：金額必須大於 0 且小於等於餘額
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount; // 減少餘額
        } else {
            // 若金額不合法則丟出例外
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }
    }

}
