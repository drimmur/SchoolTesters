import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Cash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
       int many = scanner.nextInt();
        getChange(sum, many);
    }

    public static void getChange(int sum, int many) {
        LinkedHashMap<Integer, Integer> change = new LinkedHashMap<>();
        if (many > sum || many == sum) {
            if (many > 0 && sum > 0) {
                many = many - sum;
                if (many != 0) {
                    while (many > 0) {
                        if (many - 5000 >= 0) {
                            many -= 5000;
                            if (change.containsKey(5000)) {
                                change.replace(5000, change.get(5000) + 1);
                                continue;
                            }
                            change.put(5000, 1);
                            continue;
                        }
                        if (many - 2000 >= 0) {
                            many -= 2000;
                            if (change.containsKey(2000)) {
                                change.replace(2000, change.get(2000) + 1);
                                continue;
                            }
                            change.put(2000, 1);
                            continue;
                        }
                        if (many - 1000 >= 0) {
                            many -= 1000;
                            if (change.containsKey(1000)) {
                                change.replace(1000, change.get(1000) + 1);
                                continue;
                            }
                            change.put(1000, 1);
                            continue;
                        }
                        if (many - 500 >= 0) {
                            many -= 500;
                            if (change.containsKey(500)) {
                                change.replace(500, change.get(500) + 1);
                                continue;
                            }
                            change.put(500, 1);
                            continue;
                        }
                        if (many - 200 >= 0) {
                            many -= 200;
                            if (change.containsKey(200)) {
                                change.replace(200, change.get(200) + 1);
                                continue;
                            }
                            change.put(200, 1);
                            continue;
                        }
                        if (many - 100 >= 0) {
                            many -= 100;
                            if (change.containsKey(100)) {
                                change.replace(100, change.get(100) + 1);
                                continue;
                            }
                            change.put(100, 1);
                            continue;
                        }
                        if (many - 50 >= 0) {
                            many -= 50;
                            if (change.containsKey(50)) {
                                change.replace(50, change.get(50) + 1);
                                continue;
                            }
                            change.put(50, 1);
                            continue;
                        }
                        if (many - 10 >= 0) {
                            many -= 10;
                            if (change.containsKey(10)) {
                                change.replace(10, change.get(10) + 1);
                                continue;
                            }
                            change.put(10, 1);
                            continue;
                        }
                        if (many - 5 >= 0) {
                            many -= 5;
                            if (change.containsKey(5)) {
                                change.replace(5, change.get(5) + 1);
                                continue;
                            }
                            change.put(5, 1);
                            continue;
                        }
                        if (many - 2 >= 0) {
                            many -= 2;
                            if (change.containsKey(2)) {
                                change.replace(2, change.get(2) + 1);
                                continue;
                            }
                            change.put(2, 1);
                            continue;
                        }
                        if (many - 1 >= 0) {
                            many -= 1;
                            if (change.containsKey(1)) {
                                change.replace(1, change.get(1) + 1);
                                continue;
                            }
                            change.put(1, 1);
                        }
                    }
                }else {
                    System.out.println("Сдачи нет");
                    return;
                }
            }
        }else {
            System.out.println("Мало денег");
            return;
        }
        String text = "";
        for (Map.Entry<Integer, Integer> entry : change.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            text += key + " руб: " + value + " шт., ";
        }
        System.out.print(text.substring(0, text.length()-2));
    }

}
