import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        sumOfPrimeNumbers(x);
    }

    public static void sumOfPrimeNumbers(int x) {
        int sum = 1;
        if (x > 0) {
            for (int i = 1; i <= x; i++) {
                int y = 0;
                for (int a = 1; a <= i; a++) {
                    if (i % a == 0) {
                        y++;
                    }
                }
                if (y == 2) {
                    sum += i;
                }
            }
            System.out.println(sum);
        } else {
            System.out.println("Х должен быть больше нуля");
        }
    }
}
