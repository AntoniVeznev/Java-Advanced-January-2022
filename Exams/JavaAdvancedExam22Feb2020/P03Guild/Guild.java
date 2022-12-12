package Exams.JavaAdvancedExam22Feb2020.P03Guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {

    public String getName() {
        return name;
    }

    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (capacity > roster.size()) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                roster.remove(player);
                return true;
            }
        }
        return false;
    }


    public int count() {
        return roster.size();
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                String currentRank = player.getRank();
                if (!currentRank.equals("Member")) {
                    player.setRank("Member");
                    break;
                }
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                String currentRank = player.getRank();
                if (!currentRank.equals("Trial")) {
                    player.setRank("Trial");
                    break;
                }
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> listWithRemovedPlayers = new ArrayList<>();
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
                listWithRemovedPlayers.add(player);
            }
        }
        Player[] removedArr = new Player[listWithRemovedPlayers.size()];
        for (int i = 0; i < listWithRemovedPlayers.size(); i++) {
            removedArr[i] = listWithRemovedPlayers.get(i);
            roster.remove(listWithRemovedPlayers.get(i));
        }
        return removedArr;
    }


    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Players in the guild: %s:", name)).append(System.lineSeparator());
        for (Player player : roster) {
            builder.append(player).append(System.lineSeparator());
        }
        return builder.toString();
    }
}


