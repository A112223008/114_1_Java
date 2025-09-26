import java.security.SecureRandom;

public class RollDice {
    public static void main(String[] args) {
        // 建立安全隨機數生成器
        SecureRandom randomNumbers = new SecureRandom();

        // 建立一個陣列用來記錄每個點數出現的次數（索引1~6）
        int[] frequency = new int[7]; // Array to hold frequency of dice rolls (1-6)

        // 擲骰子6000萬次
        for (int roll = 0; roll < 60000000; roll++) {
            // 產生1~6的隨機點數
            int face = 1 + randomNumbers.nextInt(6); // Roll the dice (1-6)
            // 將該點數的出現次數加1
            frequency[face]++; // Increment the frequency for the rolled face
        }

        // 輸出表頭
        System.out.printf("%s%10s%n", "點數", "出現次數");
        // 輸出每個點數出現的次數
        for (int face = 1; face < frequency.length; face++) {
            System.out.printf("%4d%10d%n", face, frequency[face]);
        }
    }
}
