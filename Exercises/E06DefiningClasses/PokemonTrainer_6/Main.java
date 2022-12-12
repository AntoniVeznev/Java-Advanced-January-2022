package Exercises.E06DefiningClasses.PokemonTrainer_6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Trainer> trainerMap = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("Tournament")) {
            String[] data = input.split("\\s+");

            String trainerName = data[0];
            Pokemon pokemon = readPokemonData(data);

            if (!trainerMap.containsKey(trainerName)) {
                Trainer trainer = new Trainer(trainerName, 0);
                trainerMap.put(trainerName, trainer);
            }

            trainerMap.get(trainerName).addPokemonToCollection(pokemon);

            input = scan.nextLine();
        }

        input = scan.nextLine();

        while (!input.equals("End")) {
            for (Map.Entry<String, Trainer> entry : trainerMap.entrySet()) {
                if (entry.getValue().isElementInCollection(input)) {
                    entry.getValue().setNumberOfBadges(entry.getValue().getNumberOfBadges() + 1);
                } else {
                    entry.getValue().takeHealthFromCollection();
                }
            }

            input = scan.nextLine();
        }

        printOutput(trainerMap);
    }

    public static void printOutput(Map<String, Trainer> trainerMap) {
        Set<Trainer> trainers = new LinkedHashSet<>();

        for (Map.Entry<String, Trainer> entry : trainerMap.entrySet()) {
            trainers.add(entry.getValue());
        }

        trainers.stream()
                .sorted(Comparator.comparing(Trainer::getNumberOfBadges).reversed())
                .forEach(trainer -> System.out.println(trainer.getName() + " "
                        + trainer.getNumberOfBadges() + " "
                        + trainer.getPokemonCollection().size()));
    }

    public static Pokemon readPokemonData(String[] data) {
        String name = data[1];
        String element = data[2];
        int health = Integer.parseInt(data[3]);

        return new Pokemon(name, element, health);
    }
}
