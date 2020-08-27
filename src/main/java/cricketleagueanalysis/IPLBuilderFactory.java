package cricketleagueanalysis;
public class IPLBuilderFactory {
    public static ICSVBuilder createCSVbuilder() {
        return new OpenCSVBuilder();
    }

}