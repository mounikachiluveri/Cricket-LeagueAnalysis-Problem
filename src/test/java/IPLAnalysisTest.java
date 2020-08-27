import com.google.gson.Gson;

import cricketleagueanalysis.*;
import org.junit.Assert;
import org.junit.Test;

public class IPLAnalysisTest {
    private static IPLAnalyser iplAnalyzer;
    private String sortedData;
    private static final String IPL_BATSMAN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_BATSMAN_CSV_WRONG_FILE_PATH = "./src/resources/IPL2019FactsheetMostRuns.csv";


    @Test
    public void givenMostRunsDataFile_ReturnCorrectRecords() throws CSVBuilderException {
        IPLAnalyser iplAnalyzer = new IPLAnalyser();
        try {
            int numOfEnteries = iplAnalyzer.loadIPLData(IPL_BATSMAN_CSV_FILE_PATH);
            System.out.println(numOfEnteries);
            Assert.assertEquals(100, numOfEnteries);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLBatsman_WhenSortedOnAverage_ShouldReturnSortedResult() {
        try {
            iplAnalyzer.loadIPLData(IPL_BATSMAN_CSV_FILE_PATH);
            sortedData = iplAnalyzer.getSortedData(SortBy.AVG);
            MostRunsData[] statisticCSV = new Gson().fromJson(sortedData, MostRunsData[].class);
            Assert.assertEquals("MS Dhoni", statisticCSV[0].playerName);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLBatsman_WhenSortedOnStrikingRates_ShouldReturnSortedResult() {
        try {
            iplAnalyzer.loadIPLData(IPL_BATSMAN_CSV_FILE_PATH);
            sortedData = iplAnalyzer.getSortedData(SortBy.STRIKING_RATE);
            MostRunsData[] statisticCSV = new Gson().fromJson(sortedData, MostRunsData[].class);
            Assert.assertEquals("Ishant Sharma", statisticCSV[0].playerName);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLBatsman_WhenSortedOnFourAndSix_ShouldReturnSortedResult() {
        try {
            iplAnalyzer.loadIPLData(IPL_BATSMAN_CSV_FILE_PATH);
            sortedData = iplAnalyzer.getSortedData(SortBy.FOUR_AND_SIX);
            MostRunsData[] statisticCSV = new Gson().fromJson(sortedData, MostRunsData[].class);
            Assert.assertEquals("Andre Russell", statisticCSV[0].playerName);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }
    @Test
    public void givenIPLBatsman_WhenSortedOnFourAndSix_ShouldReturnStrikeRateResult(){
        try {
            iplAnalyzer.loadIPLData(IPL_BATSMAN_CSV_FILE_PATH);
            sortedData = iplAnalyzer.getSortedData(SortBy.FOUR_AND_SIX);
            MostRunsData[] statisticCSV = new Gson().fromJson(sortedData, MostRunsData[].class);
            Assert.assertEquals(204.81, statisticCSV[0].strikeRate,0.0);
        } catch ( IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }
}



