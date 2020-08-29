package cricketleagueanalysis;



import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

    public class SortBy{
        static Map<Field, Comparator> sortFieldComparator = new HashMap<>();
        public enum Field {
            AVERAGE_OF_BATSMAN,STRIKE_Rate,FOURS_SIXES_Rate;
        }

        public static Comparator getComparatorField(SortBy.Field field) {
            Comparator<IPLDAO> iplAverageBattingComparator = Comparator.comparing(census -> census.batsManAverage);
            Comparator<IPLDAO> iplStrikeRateComparator = Comparator.comparing(census -> census.strikeRate);
            Comparator<IPLDAO> iplfoursandsixesComparator = Comparator.comparing(census -> census.sixes*6 +census.fours*4);

            sortFieldComparator.put(Field.AVERAGE_OF_BATSMAN, iplAverageBattingComparator.reversed());
            sortFieldComparator.put(Field.STRIKE_Rate, iplStrikeRateComparator.reversed());
            sortFieldComparator.put(Field.FOURS_SIXES_Rate, iplfoursandsixesComparator.reversed());




            return (Comparator<IPLDAO>) sortFieldComparator.get(field);

        }
    }

