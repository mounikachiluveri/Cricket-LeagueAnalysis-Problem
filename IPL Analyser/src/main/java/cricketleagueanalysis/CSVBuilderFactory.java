package cricketleagueanalysis;

public class CSVBuilderFactory {

        public static ICSVBuilder createCSVBuilder() {
            return new OpenCSVBuilder();
        }
    }

