import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Программа среди заданных строк находит строку с максимальным количеством различ-\n" +
                "ных символов. Если таких строк будет много, то выведет первую.");
        System.out.print("Введите количество строк:    ");
        int n = in.nextInt();
        if (n <= 0) {
            System.out.println("Ошибка! Количество строк должно быть положительным числом.");
            return;
        }

        String[] rows = new String[n];
        for (int i = 0; i < n; ++i) {
            System.out.print("Введите строку " + (i+1) + ": ");
            rows[i] = in.next();
        }

        int numRow = -1;
        int maxDiffSymbs = -1;
        for (int i = 0; i < n; ++i) {
            char[] chars = rows[i].toCharArray();
            Arrays.sort(chars);

            int cntDiffSymbs = 0;
            char lastDiffSymb = '\0';
            for (char c : chars) {
                if (lastDiffSymb != c) {
                    lastDiffSymb = c;
                    ++cntDiffSymbs;
                }
            }

            if (maxDiffSymbs < cntDiffSymbs) {
                maxDiffSymbs = cntDiffSymbs;
                numRow = i;
            }
        }
        if (-1 == numRow) {
            System.out.println("Соответствующих строк не найдено!");
            return;
        }

        System.out.println("Итоговая строка: " + rows[numRow]);
    }
}