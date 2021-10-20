package randomfuntraining.fantasySports.fantasySports;

import java.util.*;

public class FantasyGenerator {
    private final static String[] teams = new String[]{"Penetrate Down Low", "Barrett-tone A-Capela", "Rim Jobs", "Kawhi not Rubio On my Gasol",
            "All-STAR Ball handlers", "I Get Injured", "KAT in the Hat", "The Monstars", "Chitown BallHogs",
            "Hillbilly Hickdeads", "Dirty Pascal", "Men's Butts Drive Me Nuts"};
    private final static String[] draftOrder = FantasyGenerator.printDraftOrder(teams);
    private final static int[] number = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
    public static void main(String[] args){

        List<Teams> teamsList = getFantasyBasketballTeams();
        Collections.shuffle(teamsList);
        printTeamsList(teamsList);

//        Random random = new Random();
//
//        System.out.println("Pick #" + Arrays.toString(draftOrder) + " goes to " + Arrays.toString(printDraftOrder(teams)));

        System.out.println("Bud Division: \n" + teamsList.subList(0, 6));
        System.out.println("Miller Division: \n" + teamsList.subList(6, 12));
    }

    public static String[] printDraftOrder(String[] team) {
        // for string array name is null then return null
        if (team == null) return null;
        // for string array name length is zero then return an empty string array
        if (team.length == 0) return new String[0];
        // for single element in the array return the same array
        if (team.length == 1) return team;

        int teamLength = team.length;

        Boolean[] chosen = new Boolean[teamLength];
        Boolean[] drafter = new Boolean[teamLength];

        // initialize arrays with false
        Arrays.fill(chosen, false);
        Arrays.fill(drafter, false);

        Random rand = new Random();
        // final result array
        String[] result = new String[team.length];
        int position = 0;

        while (true) {
            int randomInt1 = rand.nextInt(teamLength);
            int randomInt2 = rand.nextInt(teamLength);

            // get random person
            String person1 = team[randomInt1];
            String person2 = team[randomInt2];

            if (person1 == person2) {
                // do nothing
            }
            // if two person name are not same
            if ((!person1.equals(person2)) && (drafter[randomInt1] == false)
                    && (chosen[randomInt2] == false)) {

                if (!person1.equals(team[position])) {
                    result[position] = person1;
                    position++;

                    drafter[randomInt1] = true;
                    chosen[randomInt2] = true;

                    if (isArrCompleted(drafter) && isArrCompleted(chosen)) break;
                }

            }
        }
        return result;
    }

    private static boolean isArrCompleted(Boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == false) {
                return false;
            }
        }
        return true;
    }

    public static void printTeamsList(List<Teams> teamsList) {
        for (int order = 0; order < teams.length; order++) {
            System.out.println("Pick #" + number[order] + " goes to " + draftOrder[order]);
            if (draftOrder[order].equals(teams[order]))
                System.out.println("ERROR: " + teams[order]);
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
