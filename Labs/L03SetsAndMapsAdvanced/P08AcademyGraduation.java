package Labs.L03SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        Map<String, Double[]> dataMap = new LinkedHashMap<>();

        for (int i = 0; i < numberOfStudents; i++) {

            String name = scanner.nextLine();
            String[] scores = scanner.nextLine().split("\\s+");
            Double[] array = new Double[scores.length];

            for (int j = 0; j < scores.length; j++) {
                double firstScore = Double.parseDouble(scores[j]);
                array[j] = firstScore;
            }
            dataMap.put(name, array);
        }

        for (Map.Entry<String, Double[]> entry : dataMap.entrySet()) {
            System.out.printf("%s is graduated with %n", entry.getKey());
        }

    }
}
