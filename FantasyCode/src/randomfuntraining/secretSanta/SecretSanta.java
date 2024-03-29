package randomfuntraining.secretSanta;

import java.util.Arrays;
import java.util.Random;

public class SecretSanta {
    public static void main(String[] args) {
        final String[] participants = new String[] {"Ryan", "Kate", "Jeff", "Jodie", "Kayla",
                                                    "Greg", "Randy", "Debbie", "Dave", "Diane", "AJ"};
        final String[] assignments = new SecretSanta().generateAssignments(participants);

        for (int i = 0; i < assignments.length; i++) {
            System.out.println(assignments[i] + " is " +  participants[i] + "'s Secret Santa! :)");
            if (assignments[i].equals(participants[i]))
                System.out.println("ERROR : " + assignments[i]);
        }
    }
    public String[] generateAssignments(String[] names) {
        // for string array name is null then return null
        if (names == null) return null;
        // for string array name length is zero then return an empty string array
        if (names.length == 0) return new String[0];
        // for single element in the array return the same array
        if (names.length == 1) return names;

        int nameslength = names.length;

        Boolean[] chosen = new Boolean[nameslength];
        Boolean[] santa = new Boolean[nameslength];

        // initialize arrays with false
        Arrays.fill(chosen, false);
        Arrays.fill(santa, false);

        Random rand = new Random();
        // final result array
        String[] result = new String[names.length];
        int position = 0;

        while (true) {
            int randomInt1 = rand.nextInt(nameslength);
            int randomInt2 = rand.nextInt(nameslength);

            // get random person
            String person1 = names[randomInt1];
            String person2 = names[randomInt2];

            if (person1 == person2) {
                // do nothing
            }
            // if two person name are not same
            if ((!person1.equals(person2)) && (santa[randomInt1] == false)
                    && (chosen[randomInt2] == false)) {

                if (!person1.equals(names[position])) {
                    result[position] = person1;
                    position++;

                    santa[randomInt1] = true;
                    chosen[randomInt2] = true;

                    if (isArrCompleted(santa) && isArrCompleted(chosen)) break;
                }

            }
        }
        return result;
    }

    /**
     * checks if the array execution is completed.
     *
     * //@param boolarray the arr
     * //@return true, if successful
     */
    private boolean isArrCompleted(Boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == false) {
                return false;
            }
        }
        return true;
    }


    /**
     * The main method.
     *
     * @param args the arguments
     */

}
