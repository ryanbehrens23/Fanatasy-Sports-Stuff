package randomfuntraining.fantasySports;

import java.util.Comparator;

public class SortDraftOrder implements Comparator<Teams> {
    @Override
    public int compare(Teams o1, Teams o2) {
        return (int) (o1.getNumber() - o2.getNumber());
    }
}
