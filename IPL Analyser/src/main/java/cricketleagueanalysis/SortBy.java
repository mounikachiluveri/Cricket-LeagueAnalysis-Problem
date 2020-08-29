package cricketleagueanalysis;



import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

    public class SortBy{
        static Map<Field, Comparator> sortFieldComparator = new HashMap<>();
        public enum Field {
            AVERAGE_OF_BATSMAN,STRIKE_RATE,FOURS_SIXES_RATE,FOURS_SIXES_WITH_STRIKE_RATE;
        }

        public static Comparator getComparatorField(SortBy.Field field) {
            Comparator<IPLDAO> iplAverageBattingComparator = Comparator.comparing(census -> census.batsManAverage);
            Comparator<IPLDAO> iplStrikeRateComparator = Comparator.comparing(census -> census.strikeRate);
            Comparator<IPLDAO> iplfoursandsixesComparator = Comparator.comparing(census -> census.sixes*6 +census.fours*4);

            sortFieldComparator.put(Field.AVERAGE_OF_BATSMAN, iplAverageBattingComparator.reversed());
            sortFieldComparator.put(Field.STRIKE_RATE, iplStrikeRateComparator.reversed());
            sortFieldComparator.put(Field.FOURS_SIXES_RATE, iplfoursandsixesComparator.reversed());
            sortFieldComparator.put(Field.FOURS_SIXES_WITH_STRIKE_RATE, iplfoursandsixesComparator.thenComparing(iplStrikeRateComparator).reversed());



            return (Comparator<IPLDAO>) sortFieldComparator.get(field);

        }
    }

