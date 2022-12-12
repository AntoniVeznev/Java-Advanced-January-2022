package Labs.L03SetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String whoHaveReservation = scanner.nextLine();
        Set<String> setVip = new HashSet<>();
        Set<String> setRegular = new HashSet<>();
        while (!whoHaveReservation.equals("PARTY")) {
            char[] array = whoHaveReservation.toCharArray();
            char symbol = array[0];
            if (Character.isDigit(symbol) && array.length == 8) {
                setVip.add(whoHaveReservation);
            } else if (Character.isLetter(symbol) && array.length == 8) {
                setRegular.add(whoHaveReservation);
            }
            whoHaveReservation = scanner.nextLine();
        }

        String startComing = scanner.nextLine();

        while (!startComing.equals("END")) {
            if (setVip.contains(startComing)) {
                setVip.remove(startComing);
            } else if (setRegular.contains(startComing)) {
                setRegular.remove(startComing);
            }
            startComing = scanner.nextLine();
        }

        if (setVip.isEmpty() && setRegular.isEmpty()) {
            System.out.println("0");
        } else {
            int whoDidntCome = setVip.size() + setRegular.size();
            System.out.println(whoDidntCome);
        }
        if (!setVip.isEmpty()) {
            for (String element : setVip) {
                System.out.println(element);
            }
        }
        if (!setRegular.isEmpty()) {
            for (String element : setRegular) {
                System.out.println(element);
            }
        }
    }
}
