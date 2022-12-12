package Labs.L03SetsAndMapsAdvanced;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> dataMap = new TreeMap<>();
        for (int i = 0; i < numberOfStudents; i++) {
            String input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            double grades = Double.parseDouble(input.split("\\s+")[1]);
            if (!dataMap.containsKey(name)) {
                dataMap.put(name, new ArrayList<>());
                dataMap.get(name).add(grades);
            } else {
                dataMap.get(name).add(grades);
            }
        }
        for (Map.Entry<String, List<Double>> name : dataMap.entrySet()) {
            System.out.printf("%s -> ", name.getKey());
            double average = 0;
            for (int i = 0; i < name.getValue().size(); i++) {
                System.out.printf("%.2f ", name.getValue().get(i));
                average += name.getValue().get(i);
            }
            average = average / name.getValue().size();
            System.out.printf("(avg: %.2f)", average);
            average = 0;
            System.out.println();
        }
    }
}
