import java.util.*;

public class Lenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> x = new ArrayList<>();
        System.out.println("Введите количество циклопов");
        int ciklops = scanner.nextInt();
        System.out.println("Введите диоптрии линз");
        for (int i = 0; i<= ciklops-1; i++) {
            x.add(scanner.nextInt());
        }
        minValueLenses(x);
    }

    public static void minValueLenses(ArrayList<Integer> x) {
        LinkedHashMap<Integer, Integer> listLenses = new LinkedHashMap<>();
        int minValue = 0;
        Collections.sort(x);

        for (int i = 0; i < x.size() - 1; i++) {
            for (int a = i + 1; a <= x.size() - 1; a++) {
                if (x.get(i).equals(x.get(a))) {
                    if (listLenses.containsKey(x.get(i))) {
                        listLenses.replace(x.get(i), listLenses.get(x.get(i)) + 1);
                        minValue++;
                        x.remove(a);
                        continue;
                    }
                    listLenses.put(x.get(i), 1);
                    x.remove(a);
                    x.remove(i);
                    minValue++;
                }
            }
        }

        for (int i = 0; i <= x.size() - 1; i++) {
            if (x.size() - 1 == i) {
                if (listLenses.containsKey(x.get(i))) {
                    listLenses.replace(x.get(i), listLenses.get(x.get(i)) + 1);
                    minValue++;
                    break;
                }
                listLenses.put(x.get(i), 1);
                minValue++;
                break;
            }
            if (x.get(i) - 1 == x.get(i + 1) || x.get(i) + 1 == x.get(i + 1) || x.get(i).equals(x.get(i + 1))) {
                minValue++;

                if (listLenses.containsKey(x.get(i))) {
                    listLenses.replace(x.get(i), listLenses.get(x.get(i)) + 1);
                    continue;
                }
                listLenses.put(x.get(i), 1);
                i++;

            } else if (x.get(i) + 2 == x.get(i + 1)) {
                minValue++;
                if (x.get(i) <= 0) {
                    if (listLenses.containsKey(x.get(i) + 1)) {
                        listLenses.replace(x.get(i) + 1, listLenses.get(x.get(i) + 1) + 1);
                        continue;
                    }
                    listLenses.put(x.get(i) + 1, 1);
                }
                if (x.get(i) > 0) {
                    if (listLenses.containsKey(x.get(i) - 1)) {
                        listLenses.replace(x.get(i) - 1, listLenses.get(x.get(i) - 1) + 1);
                        continue;
                    }
                    listLenses.put(x.get(i) - 1, 1);
                }
                i++;
            } else {
                if (listLenses.containsKey(x.get(i))) {
                    listLenses.replace(x.get(i), listLenses.get(x.get(i)) + 1);
                    continue;
                }
                listLenses.put(x.get(i), 1);
                minValue++;
            }
        }
        String text = "";
        for (Map.Entry<Integer, Integer> entry : listLenses.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            text += key + " диоптрий: " + value + " пара " + "\n";
        }
        System.out.println("Минимальное количество линз:" + minValue + "\n" + text);
    }
}

