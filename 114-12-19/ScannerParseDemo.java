import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ScannerParseDemo {
    public static void main(String[] args) {
        createTestFile();
        
        // 創建list來存放Student物件
        List<Student> students = new ArrayList<>();
        
        // 從文件讀取數據到list
        try (Scanner scanner = new Scanner(new File("scores.txt"))) {
            System.out.println("=== 讀取成績資料 ===");
            
            while (scanner.hasNext()) {
                String name = scanner.next();      // 讀取字串
                int score = scanner.nextInt();     // 讀取整數
                double gpa = scanner.nextDouble(); // 讀取浮點數
                
                students.add(new Student(name, score, gpa));
                System.out.printf("%s: %d 分, GPA: %.2f%n", name, score, gpa);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        // 將list數據輸出到文件
        outputStudentsToFile(students);
    }
    
    private static void createTestFile() {
        try (PrintWriter pw = new PrintWriter("scores.txt")) {
            pw.println("王小明 85 3.5");
            pw.println("李小華 92 4.0");
            pw.println("張小美 78 3.2");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private static void outputStudentsToFile(List<Student> students) {
        try (PrintWriter pw = new PrintWriter("student_output.txt")) {
            System.out.println("\n=== 輸出成績資料到文件 ===");
            pw.println("姓名\t分數\tGPA");
            pw.println("================");
            
            for (Student student : students) {
                String line = String.format("%s\t%d\t%.2f", student.getName(), student.getScore(), student.getGpa());
                pw.println(line);
                System.out.println(line);
            }
            System.out.println("數據已保存到 student_output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    // Student class定義
    static class Student {
        private String name;
        private int score;
        private double gpa;
        
        public Student(String name, int score, double gpa) {
            this.name = name;
            this.score = score;
            this.gpa = gpa;
        }
        
        public String getName() {
            return name;
        }
        
        public int getScore() {
            return score;
        }
        
        public double getGpa() {
            return gpa;
        }
    }
}
