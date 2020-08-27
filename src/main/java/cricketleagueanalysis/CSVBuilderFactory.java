package cricketleagueanalysis;

public class CSVBuilderFactory {
    public static OpenCSVBuilder createCSVbuilder() {
        return new OpenCSVBuilder();
    }
}
