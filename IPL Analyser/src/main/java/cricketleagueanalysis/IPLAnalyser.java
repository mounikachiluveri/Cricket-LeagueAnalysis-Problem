package cricketleagueanalysis;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toCollection;

public class IPLAnalyser {


    public enum PlayerType {BATSMAN, BOWLER}
    ;
    public static Map<String, IPLDAO> cricketLeagueMap = null;

    public IPLAnalyser() {
        cricketLeagueMap = new HashMap<String, IPLDAO>();
    }

    public static int loadIPLFactSheetData(PlayerType playerType, String... csvFilePath) throws IPLAnalyserException {
        cricketLeagueMap = new IPLDataLoader().loadIPLFactSheetData(playerType, csvFilePath);
        return cricketLeagueMap.size();
    }

    public static String getFieldWiseSortedPlayersData(PlayerType playerType, SortBy.Field... field) throws IPLAnalyserException {
        Comparator<IPLDAO> cricketComparator = null;
        if (cricketLeagueMap == null || cricketLeagueMap.size() == 0)
            throw new IPLAnalyserException("NO_PLAYER_DATA", IPLAnalyserException.ExceptionType.NO_PLAYER_DATA);

        cricketComparator = SortBy.getComparatorField(field[0]);
        ArrayList censusDTOS = cricketLeagueMap.values().stream()
                .sorted(cricketComparator)
                .map(cricketDAO -> cricketDAO.getCricketDTO(playerType))
                .collect(toCollection(ArrayList::new));

        return new Gson().toJson(censusDTOS);
    }
}

