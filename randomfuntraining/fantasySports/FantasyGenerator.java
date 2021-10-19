package randomfuntraining.fantasySports.fantasySports;

import java.util.*;

public class fantasyGenerator {
    private final static String[] teams = new String[]{""};
    private final static String[] draftOrder = new fantasyGenerator().printDraftOrder(teams);
    private final static int[] number = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
    private final static String[] bud = new String[]{""};
    private final static String[] miller = new String[]{""};
    public static void main(String[] args){

//        List<Teams> teamsList = getFantasyBasketballTeams();
//        Collections.shuffle(teamsList);
//        printTeamsList(teamsList);

//        Random random = new Random();
//
//        System.out.println("Pick #" + Arrays.toString(draftOrder) + " goes to " + Arrays.toString(printDraftOrder(teams)));

//        System.out.println("Bud Division: \n" + teamsList.subList(0, 6));
//        System.out.println("Miller Division: \n" + teamsList.subList(6, 12));
//        getBudVsMillerH2H();
    }

    public static void getBudVsMillerH2H() {
        Collections.shuffle(Arrays.asList(bud));
        Collections.shuffle(Arrays.asList(miller));
        Boolean[] budChosen = new Boolean[bud.length];
        Boolean[] millerChosen = new Boolean[miller.length];
        Arrays.fill(budChosen, false);
        Arrays.fill(millerChosen, false);
        int position = 0;
        while (true) {
            Random rand = new Random();
            int randomInt1 = rand.nextInt(bud.length);
            int randomInt2 = rand.nextInt(miller.length);
            // get random person
            String person1 = bud[randomInt1];
            String person2 = miller[randomInt2];
            if (!person1.equals(randomInt1) && !person2.equals(randomInt2) && budChosen[randomInt1] == false && millerChosen[randomInt2] == false) {
                if (!person1.equals(bud[position]) && !person1.equals(miller[position])) {
                    System.out.println(bud[position] + " vs " + miller[position]);
                    position++;
                    budChosen[randomInt1] = true;
                    millerChosen[randomInt2] = true;
                }
                if (isArrCompleted(budChosen) && isArrCompleted(millerChosen)) break;
            }
        }
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

        Teams one = new Teams("");
        teamsList.add(one);
        Teams two = new Teams("");
        teamsList.add(two);
        Teams three = new Teams("");
        teamsList.add(three);
        Teams four = new Teams("l");
        teamsList.add(four);
        Teams five = new Teams("");
        teamsList.add(five);
        Teams six = new Teams("");
        teamsList.add(six);
        Teams seven = new Teams("");
        teamsList.add(seven);
        Teams eight = new Teams("");
        teamsList.add(eight);
        Teams nine = new Teams("");
        teamsList.add(nine);
        Teams ten = new Teams("");
        teamsList.add(ten);
        Teams eleven = new Teams("");
        teamsList.add(eleven);
        Teams tweleve = new Teams("");
        teamsList.add(tweleve);
        return teamsList;
    }
}
