

import com.google.gson.Gson;

import cricketleagueanalysis.IPLAnalyser;
import cricketleagueanalysis.IPLAnalyserException;
import cricketleagueanalysis.MostRunsData;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

public class IPLAnalysisTest {
    private static IPLAnalyser iplAnalyzer;
    private String sortedData;
    private static final String IPL_BATSMAN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";


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
}
