public class Account {
    // 帳號，識別每個帳戶
    private String accountNumber;
    // 帳戶餘額（以新台幣 TWD 為單位）
    private double balance;

    /**
     * 建構子：初始化帳號與初始餘額
     * @param accountNumber 帳號
     * @param initialBalance 初始餘額（若不合法則會拋出例外並在呼叫端處理）
     */
    public Account(String accountNumber, double initialBalance) {
        this.setAccountNumber(accountNumber);
        try {
            this.setBalance(initialBalance);
        } catch (IllegalArgumentException e) {
            // 若初始餘額不合法，印出錯誤並將餘額設為 0
            System.out.println("初始餘額錯誤: " + e.getMessage() + "，餘額設為 0");
            this.balance = 0; // 若初始餘額不合法，設為 0
        }
    }

    public Account() {
        this("000000", 0.0);
    }
    public Account(String accountNumber) {
        this(accountNumber, 0.0);
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
     * @return 帳戶餘額（TWD）
     */
    public double getBalance() {
        return balance;
    }

    /**
     * 設定帳戶餘額
     * @param balance 新餘額（必須 >= 0）
     * @throws IllegalArgumentException 餘額不得為負數
     */
    public void setBalance(double balance) {
        // 直接驗證數值是否為合法的非負數
        if (balance >= 0) {
            this.balance = balance;
        } else {
            // 傳入負數時透過例外告知呼叫者
            throw new IllegalArgumentException("餘額必須為正數");
        }
    }

    /**
     * 設定帳戶號碼
     * @param accountNumber 新帳號
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * 存款方法，將指定金額存入帳號（單一金額）
     * @param amount 存款金額，必須大於 0
     * @throws IllegalArgumentException 存款金額不合法時拋出
     */
    public void deposit(double amount) {
        // 僅接受正數存款，避免負值或 0
        if (amount > 0) {
            balance += amount; // 增加餘額
        } else {
            // 若金額不合法則丟出例外
            throw new IllegalArgumentException("存款必須為正數");
        }
    }

    /**
     * 存款（含貨幣轉換）
     * 支援 USD、EUR、JPY；其他則使用預設匯率 1.0（或顯示不支援訊息）
     * @param amount 指定貨幣的金額
     * @param currency 貨幣代號（大小寫皆可）
     */
    public void deposit(double amount, String currency) {
        double exchangeRate = 1.0; // 預設為 1（TWD）
        switch(currency.toUpperCase()) {
            case "USD":
                exchangeRate = 30.0; // 範例匯率：1 USD = 30 TWD
                break;
            case "EUR":
                exchangeRate = 35.0; // 範例匯率：1 EUR = 35 TWD
                break;
            case "JPY":
                exchangeRate = 0.25; // 範例匯率：1 JPY = 0.25 TWD
                break;
            default:
                // 若不支援的貨幣，印出提示並以預設匯率處理
                System.out.println("不支援的貨幣，請使用 TWD、USD、EUR 或 JPY");
        }
        // 轉換為 TWD 後呼叫單一金額的 deposit
        double amountInTWD = amount * exchangeRate;
        this.deposit(amountInTWD);
    }

    /**
     * 可變參數存款：將多個金額逐一存入帳號
     * @param amounts 多個存款金額，皆必須大於 0
     */
    public void deposit(double... amounts) {
        // 對於每一筆金額皆呼叫單筆 deposit，會重複套用金額驗證
        for (double amount : amounts) {
            if (amount > 0) {
                this.deposit(amount);
            } else {
                throw new IllegalArgumentException("存款必須為正數");
            }
        }
    }

    /**
     * 提款方法，將指定金額自帳號扣除
     * @param amount 提款金額，必須大於 0 且小於等於餘額
     * @throws IllegalArgumentException 提款金額不合法時拋出
     */
    public void withdraw(double amount) {
        // 檢查提款是否在可接受範圍內（>0 且 <= 餘額）
        if (!(amount > 0 && amount <= balance)) {
            throw new IllegalArgumentException("提款金額不合法");
        }
        balance -= amount; // 扣除餘額
    }
}
