package randomfuntraining.fantasySports;

public class Teams {
    private static int numberSequence = 0;
    private int number;
    private String teams;

    public Teams(String teams) {
        this.number = ++numberSequence;
        this.teams = teams;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return teams;
    }
}
