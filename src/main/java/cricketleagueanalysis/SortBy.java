package cricketleagueanalysis;

 import java.util.Comparator;
 import java.util.HashMap;
 import java.util.Map;

public enum SortBy {
    AVG,STRIKING_RATE;
    public static Map<SortBy, Comparator<MostRunsData>> sortMap = new HashMap<>();
    public static void initializeSortedMap(){
        sortMap.put(SortBy.AVG, Comparator.comparing(s -> s.average));
        sortMap.put(SortBy.STRIKING_RATE, Comparator.comparing(s -> s.strikeRate));
    }
}
