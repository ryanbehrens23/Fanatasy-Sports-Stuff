package com.deere.JavaTraining.randomfuntraining.fantasySports;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FantasyGenerator {
    private final static int[] draftOrder = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private final static String[] teams = new String[]{"Penetrate Down Low", "Barrett-tone A-Capela", "Rim Jobs", "Kawhi not Rubio On my Gasol",
            "All-STAR Ball handlers", "I Get Injured", "KAT in the Hat", "The Monstars", "Chitown BallHogs",
            "Hillbilly Hickdeads", "Dirty Pascal", "Men's Butts Drive Me Nuts"};
    public static void main(String[] args){

        List<Teams> teamsList = getFantasyBasketballTeams();
        Collections.shuffle(teamsList);
        printTeamsList(teamsList);

        Random random = new Random();

        printDraftOrder(teams[random.nextInt(teams.length)]);

        System.out.println("Bud Division: \n" + teamsList.subList(0, 6));
        System.out.println("Miller Division: \n" + teamsList.subList(6, 12));
    }

    public static void printDraftOrder(String team) {
        Random random = new Random();
        String team1 = teams[teams.length];
        String team2 = teams[teams.length];
        for (int i = 1; i < draftOrder.length; i++){
            System.out.println("Pick #" + draftOrder[i] + " goes to " + teams[random.nextInt(teams.length)]);
        }
    }

    public static void printTeamsList(List<Teams> teamsList) {
        for (Teams teams : teamsList){
            for (int order = 0; order <=12; order++)
                System.out.println("Pick #" + draftOrder[] teams);
        }
    }

    public static List<Teams> getFantasyBasketballTeams() {
        List<Teams> teamsList = new ArrayList<>();

        Teams ryan = new Teams("Penetrate Down Low");
        teamsList.add(ryan);
        Teams randy = new Teams("Barrett-tone A-Capela");
        teamsList.add(randy);
        Teams kate = new Teams("Rim Jobs");
        teamsList.add(kate);
        Teams aj = new Teams("Kawhi not Rubio On my Gasol");
        teamsList.add(aj);
        Teams cam = new Teams("All-STAR Ball handlers");
        teamsList.add(cam);
        Teams nick = new Teams("I Get Injured");
        teamsList.add(nick);
        Teams tony = new Teams("KAT in the Hat");
        teamsList.add(tony);
        Teams jake = new Teams("The Monstars");
        teamsList.add(jake);
        Teams opi = new Teams("Chitown BallHogs");
        teamsList.add(opi);
        Teams kevin = new Teams("Hillbilly Hickdeads");
        teamsList.add(kevin);
        Teams mike = new Teams("Dirty Pascal");
        teamsList.add(mike);
        Teams dennis = new Teams("Men's Butts Drive Me Nuts");
        teamsList.add(dennis);
        return teamsList;
    }
}
