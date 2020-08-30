package cricketleagueanalysis;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortBy {
    static Map<Field, Comparator> sortFieldComparator = new HashMap<>();

    public enum Field {
        AVERAGE_OF_BATSMAN,
        STRIKE_RATE,
        FOURS_SIXES_RATE,
        FOURS_SIXES_WITH_STRIKE_RATE,
        AVERAGE_OF_BATSMAN_WITH_STRIKE_RATE,
        RUNS_WITH_AVERAGE,
        BOWLING_AVERAGE,
        BOWLER_STRIKERATE,
        BEST_ECONOMY,
        STRIKINGRATE_FIVEW_FOURW,
        BOWLER_AVERAGE_WITH_STRIKERATE;
    }

    public static Comparator getComparatorField(SortBy.Field field) {
        Comparator<IPLDAO> iplAverageBattingComparator = Comparator.comparing(census -> census.batsManAverage);
        Comparator<IPLDAO> iplStrikeRateComparator = Comparator.comparing(census -> census.strikeRate);
        Comparator<IPLDAO> iplfoursandsixesComparator = Comparator.comparing(census -> census.sixes * 6 + census.fours * 4);
        Comparator<IPLDAO> iplrunsComparator = Comparator.comparing(census -> census.runs);
        Comparator<IPLDAO> iplbowlingComparator = Comparator.comparing(census -> census.bowlingAverage);
        Comparator<IPLDAO> iplStrikingRateBowlerComparator = Comparator.comparing(census -> census.bowlerstrikeRate);
        Comparator<IPLDAO> ipleconomyBowlerComparator = Comparator.comparing(census -> census.economy);
        Comparator<IPLDAO> iplStrikerateWithFivewandFourWBowlerComparator = Comparator.comparing(census -> census.fiveWicket + census.fourWkt);

        sortFieldComparator.put(Field.AVERAGE_OF_BATSMAN, iplAverageBattingComparator.reversed());
        sortFieldComparator.put(Field.STRIKE_RATE, iplStrikeRateComparator.reversed());
        sortFieldComparator.put(Field.FOURS_SIXES_RATE, iplfoursandsixesComparator.reversed());
        sortFieldComparator.put(Field.FOURS_SIXES_WITH_STRIKE_RATE, iplfoursandsixesComparator.thenComparing(iplStrikeRateComparator).reversed());
        sortFieldComparator.put(Field.AVERAGE_OF_BATSMAN_WITH_STRIKE_RATE, iplStrikeRateComparator.thenComparing(iplAverageBattingComparator).reversed());
        sortFieldComparator.put(Field.RUNS_WITH_AVERAGE, iplrunsComparator.thenComparing(iplAverageBattingComparator).reversed());
        sortFieldComparator.put(Field.BOWLING_AVERAGE, iplbowlingComparator.reversed());
        sortFieldComparator.put(Field.BOWLER_STRIKERATE, iplStrikingRateBowlerComparator.reversed());
        sortFieldComparator.put(Field.BEST_ECONOMY, ipleconomyBowlerComparator.reversed());
        sortFieldComparator.put(Field.STRIKINGRATE_FIVEW_FOURW, iplStrikerateWithFivewandFourWBowlerComparator.thenComparing(iplStrikingRateBowlerComparator).reversed());
        sortFieldComparator.put(Field.BOWLER_AVERAGE_WITH_STRIKERATE, iplbowlingComparator.thenComparing(iplStrikingRateBowlerComparator).reversed());
        return (Comparator<IPLDAO>) sortFieldComparator.get(field);
    }
}

