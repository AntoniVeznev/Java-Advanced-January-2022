package Labs.L03SetsAndMapsAdvanced;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> dataMap = new LinkedHashMap<>();
        for (int i = 0; i < number; i++) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            String continents = inputArr[0];
            String countries = inputArr[1];
            String cities = inputArr[2];
            if (!dataMap.containsKey(continents)) {
                dataMap.put(continents, new LinkedHashMap<>());
                dataMap.get(continents).put(countries, new ArrayList<>());
                dataMap.get(continents).get(countries).add(cities);
            } else {
                if (!dataMap.get(continents).containsKey(countries)) {
                    dataMap.get(continents).put(countries, new ArrayList<>());
                    dataMap.get(continents).get(countries).add(cities);
                } else {
                    dataMap.get(continents).get(countries).add(cities);
                }
            }
        }
        for (Map.Entry<String, Map<String, List<String>>> element : dataMap.entrySet()) {
            System.out.printf("%s:%n", element.getKey());
            for (Map.Entry<String, List<String>> elementNext : element.getValue().entrySet()) {
                System.out.printf("%s -> ", elementNext.getKey());
                System.out.println(String.join(", ", elementNext.getValue()));
            }
        }
    }
}
