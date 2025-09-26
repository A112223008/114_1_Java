import java.util.Scanner;

// Account 類別：代表銀行帳戶
public class Account {
    // 帳號，識別每個帳戶
    private String accountNumber;
    // 帳戶餘額
    private double balance;

    /**
     * 建構子：初始化帳號與初始餘額
     * @param accountNumber 帳號
     * @param initialBalance 初始餘額
     */
    public Account(String accountNumber, double initialBalance) {
        this.setAccountNumber(accountNumber);
        try {
            this.setBalance(initialBalance);
        } catch (IllegalArgumentException e) {
            System.out.println("初始餘額錯誤: " + e.getMessage() + "，餘額設為 0");
            this.balance = 0; // 若初始餘額不合法，設為 0
        }
    }

    /**
     * 取得帳號
     * @return 帳號
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * 取得帳戶餘額
     * @return 帳戶餘額
     */
    public double getBalance() {
        return balance;
    }

    /**
     * 設定帳戶餘額
     * @param balance 新餘額
     * @throws IllegalArgumentException 餘額必須為正數
     * 若金額不合法，允許輸入三次，三次錯誤才丟出例外
     */
    public void setBalance(double balance) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        while (attempts < 3) {
            if (balance >= 0) {
                this.balance = balance;
                return;
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.print("餘額必須為正數，請重新輸入：");
                    balance = scanner.nextDouble();
                }
            }
        }
        throw new IllegalArgumentException("餘額必須為正數");
    }

    /**
     * 設定帳戶號碼
     * @param accountNumber 新帳號
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * 存款方法，將指定金額存入帳號
     * @param amount 存款金額，必須大於 0
     * @throws IllegalArgumentException 存款必須為正數
     * 若金額不合法，允許輸入三次，三次錯誤才丟出例外
     */
    public void deposit(double amount) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        while (attempts < 3) {
            if (amount > 0) {
                balance += amount;
                return;
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.print("存款必須為正數，請重新輸入：");
                    amount = scanner.nextDouble();
                }
            }
        }
        throw new IllegalArgumentException("存款必須為正數");
    }

    /**
     * 提款方法，將指定金額自帳號扣除
     * @param amount 提款金額，必須大於 0 且小於等於餘額
     * @throws IllegalArgumentException 提款金額不合法
     * 若金額不合法，允許輸入三次，三次錯誤才丟出例外
     */
    public void withdraw(double amount) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        while (attempts < 3) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return;
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.print("提款金額不合法，請重新輸入：");
                    amount = scanner.nextDouble();
                }
            }
        }
        throw new IllegalArgumentException("提款金額不合法");
    }

}
