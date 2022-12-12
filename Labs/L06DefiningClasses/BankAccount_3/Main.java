package Labs.L06DefiningClasses.BankAccount_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Integer, BankAccount> dataMap = new HashMap<>();
        while (!input.equals("End")) {
            String whatToPrint = "";
            String[] inputArr = input.split("\\s+");
            if (inputArr[0].equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                dataMap.put(bankAccount.getId(), bankAccount);
                whatToPrint = String.format("Account ID%d created", bankAccount.getId());
            } else if (inputArr[0].equals("Deposit")) {
                int id = Integer.parseInt(inputArr[1]);
                double amount = Double.parseDouble(inputArr[2]);
                if (dataMap.containsKey(id)) {
                    BankAccount bankAccountMap = dataMap.get(id);
                    bankAccountMap.deposit(amount);
                    dataMap.put(id, bankAccountMap);
                    whatToPrint = String.format("Deposited %.0f to ID%d", amount, id);
                } else {
                    whatToPrint = "Account does not exist";
                }
            } else if (inputArr[0].equals("SetInterest")) {
                double interest = Double.parseDouble(inputArr[1]);
                BankAccount.setInterestRate(interest);
            } else if (inputArr[0].equals("GetInterest")) {
                int ID = Integer.parseInt(inputArr[1]);
                int years = Integer.parseInt(inputArr[2]);
                if (dataMap.containsKey(ID)) {
                    BankAccount bankAccount1 = dataMap.get(ID);
                    bankAccount1.getInterest(years);
                    whatToPrint = String.format("%.2f", bankAccount1.getInterest(years));
                } else {
                    whatToPrint = "Account does not exist";
                }
            }
            if (!whatToPrint.isEmpty()) {
                System.out.println(whatToPrint);
            }
            input = scanner.nextLine();
        }
    }
}
