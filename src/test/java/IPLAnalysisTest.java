import com.google.gson.Gson;

import cricketleagueanalysis.IPLAnalyser;
import cricketleagueanalysis.IPLAnalyserException;
import cricketleagueanalysis.MostRunsData;
import cricketleagueanalysis.SortBy;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class IPLAnalysisTest {
    private static IPLAnalyser iplAnalyzer;
    private String sortedData;
    private static final String IPL_BATSMAN_CSV_FILE_PATH =  "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_BATSMAN_CSV_WRONG_FILE_PATH = "./src/resources/IPL2019FactsheetMostRuns.csv";


    @Test
    public void givenIPLBatsmanCSVFile_ReturnCorrectRecords() {
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
    public void givenIPLBatsmanCSVWrongFile_ShouldThrowException() {
        IPLAnalyser iplAnalyzer = new IPLAnalyser();
        try {
            int numOfEnteries = iplAnalyzer.loadIPLData(IPL_BATSMAN_CSV_WRONG_FILE_PATH);
            Assert.assertEquals(100, numOfEnteries);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLBatsman_WhenSortedOnAverage_ShouldReturnSortedResult() {
        try {
            IPLAnalyser iplAnalyzer = new IPLAnalyser();
            iplAnalyzer.loadIPLData(IPL_BATSMAN_CSV_FILE_PATH);
            sortedData = iplAnalyzer.getSortedData(SortBy.AVG);
            MostRunsData[] statisticCSV = new Gson().fromJson(sortedData, MostRunsData[].class);
            System.out.println(statisticCSV[0].playerName);
            Assert.assertEquals("MS Dhoni", statisticCSV[0].playerName);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.WRONG_DELIMETER_WRONG_HEADER_FILE, e.type);
        }
    }
    @Test
    public void givenIPLBatsman_WhenSortedOnStrikingRates_ShouldReturnSortedResult() throws IPLAnalyserException {
        try {
            iplAnalyzer.loadIPLData(IPL_BATSMAN_CSV_FILE_PATH);
            sortedData = iplAnalyzer.getSortedData(SortBy.STRIKING_RATE);
            MostRunsData[] statisticCSV = new Gson().fromJson(sortedData, MostRunsData[].class);
            Assert.assertEquals("Ishant Sharma", statisticCSV[0].playerName);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }
}
