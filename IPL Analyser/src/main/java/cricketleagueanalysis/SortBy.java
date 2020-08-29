package cricketleagueanalysis;



import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

    public class SortBy{
        static Map<Field, Comparator> sortFieldComparator = new HashMap<>();
        public enum Field {
            AVERAGE_OF_BATSMAN,STRIKE_Rate;
        }

        public static Comparator getComparatorField(SortBy.Field field) {
            Comparator<IPLDAO> iplAverageBattingComparator = Comparator.comparing(census -> census.batsManAverage);
            Comparator<IPLDAO> iplStrikeRateComparator = Comparator.comparing(census -> census.strikeRate);

            sortFieldComparator.put(Field.AVERAGE_OF_BATSMAN, iplAverageBattingComparator.reversed());
            sortFieldComparator.put(Field.STRIKE_Rate, iplStrikeRateComparator.reversed());


            return (Comparator<IPLDAO>) sortFieldComparator.get(field);

        }
    }

