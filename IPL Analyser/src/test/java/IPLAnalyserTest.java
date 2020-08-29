import com.google.gson.Gson;
import cricketleagueanalysis.IPLAnalyser;
import cricketleagueanalysis.IPLAnalyserException;
import cricketleagueanalysis.MostRunsData;
import cricketleagueanalysis.SortBy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IPLAnalyserTest {

    private static final String IPL_BATSMAN_CSV_FILE_PATH = "./src/test/resources/IPLBat.csv";
    private static final String IPL_BATSMAN_CSV_WRONG_FILE_PATH = "./src/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WRONG_CSV_FILE_type = "./src/main/resources/IPL2019FactsheetMostRuns.txt";

    @Test
    public void givenIPLFactSheetMostRunsFile_whenProper_shouldReturnCorrectRecordCount() throws IPLAnalyserException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        int numOfRecords = iplAnalyser.loadIPLFactSheetData(IPLAnalyser.PlayerType.BATSMAN, IPL_BATSMAN_CSV_FILE_PATH);
        Assert.assertEquals(100, numOfRecords);
        System.out.println(numOfRecords);

    }

    @Test
    public void givenIPLFactSheetMostRunsDatafile_whenNotProper_shouldReturnInCorrectRecordCount() throws IPLAnalyserException {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(IPLAnalyserException.class);
            int numOfRecords = iplAnalyser.loadIPLFactSheetData(IPLAnalyser.PlayerType.BATSMAN, IPL_BATSMAN_CSV_FILE_PATH);
            Assert.assertNotEquals(99, numOfRecords);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLFactSheetMostRunsDatafile_whenFileNotProper_shouldThrowCustomException() throws IPLAnalyserException {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(IPLAnalyserException.class);
            iplAnalyser.loadIPLFactSheetData(IPLAnalyser.PlayerType.BATSMAN, WRONG_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.INPUT_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLFactSheetMostRunsDatafile_whenFileWrongFileType_shouldThrowCustomException() throws IPLAnalyserException {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(IPLAnalyserException.class);
            iplAnalyser.loadIPLFactSheetData(IPLAnalyser.PlayerType.BATSMAN, WRONG_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.INPUT_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLFactSheetMostRunsFile_whenSortedOnBattingAverage_shouldReturnSortedResult() throws IPLAnalyserException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        IPLAnalyser.loadIPLFactSheetData(IPLAnalyser.PlayerType.BATSMAN, IPL_BATSMAN_CSV_FILE_PATH);
        String playerWiseSortedData = IPLAnalyser.getFieldWiseSortedPlayersData(IPLAnalyser.PlayerType.BATSMAN, SortBy.Field.AVERAGE_OF_BATSMAN);
        MostRunsData[] cricketCSV = new Gson().fromJson(playerWiseSortedData, MostRunsData[].class);
        Assert.assertEquals("MS Dhoni", cricketCSV[0].player);
    }

    @Test
    public void givenIPLFactSheetMostRunsFile_whenSortedOnStrikeRateReturnSortedResult() throws IPLAnalyserException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        IPLAnalyser.loadIPLFactSheetData(IPLAnalyser.PlayerType.BATSMAN, IPL_BATSMAN_CSV_FILE_PATH);
        String playerWiseSortedData = IPLAnalyser.getFieldWiseSortedPlayersData(IPLAnalyser.PlayerType.BATSMAN, SortBy.Field.STRIKE_RATE);
        MostRunsData[] cricketCSV = new Gson().fromJson(playerWiseSortedData, MostRunsData[].class);
        Assert.assertEquals("Ishant Sharma", cricketCSV[0].player);

    }

    @Test
    public void givenIPLFactSheetMostRunsFile_whenSortedOnMaximumFourandSix_shouldReturnSortedResult() throws IPLAnalyserException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        IPLAnalyser.loadIPLFactSheetData(IPLAnalyser.PlayerType.BATSMAN, IPL_BATSMAN_CSV_FILE_PATH);
        String playerWiseSortedData = IPLAnalyser.getFieldWiseSortedPlayersData(IPLAnalyser.PlayerType.BATSMAN, SortBy.Field.FOURS_SIXES_RATE);
        MostRunsData[] cricketCSV = new Gson().fromJson(playerWiseSortedData, MostRunsData[].class);
        Assert.assertEquals("Andre Russell", cricketCSV[0].player);
    }

    @Test
    public void givenIPLFactSheetMostRunsFile_whenSortedOnMaximumFourandSixWithStrikeRate_shouldReturnSortedResult() throws IPLAnalyserException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        IPLAnalyser.loadIPLFactSheetData(IPLAnalyser.PlayerType.BATSMAN, IPL_BATSMAN_CSV_FILE_PATH);
        String playerWiseSortedData = IPLAnalyser.getFieldWiseSortedPlayersData(IPLAnalyser.PlayerType.BATSMAN, SortBy.Field.FOURS_SIXES_WITH_STRIKE_RATE);
        MostRunsData[] cricketCSV = new Gson().fromJson(playerWiseSortedData, MostRunsData[].class);
        Assert.assertEquals("Andre Russell", cricketCSV[0].player);

    }
    @Test
    public void givenIPLFactSheetMostRunsFile_whenSortedOnAverageWithStrikeRate_shouldReturnSortedResult() throws IPLAnalyserException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        IPLAnalyser.loadIPLFactSheetData(IPLAnalyser.PlayerType.BATSMAN, IPL_BATSMAN_CSV_FILE_PATH);
        String playerWiseSortedData = IPLAnalyser.getFieldWiseSortedPlayersData(IPLAnalyser.PlayerType.BATSMAN, SortBy.Field.AVERAGE_OF_BATSMAN_WITH_STRIKE_RATE);
        MostRunsData[] cricketCSV = new Gson().fromJson(playerWiseSortedData, MostRunsData[].class);
        Assert.assertEquals("Ishant Sharma", cricketCSV[0].player);

    }
}



