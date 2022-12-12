package Labs.L06DefiningClasses.CarInfo_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> dataList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            Car car = new Car();
            car.setBrand(inputArr[0]);
            car.setModel(inputArr[1]);
            car.setHorsePower(Integer.parseInt(inputArr[2]));
            dataList.add(car);
        }
        dataList.forEach(element -> System.out.println(element.carInfo()));
    }
}
