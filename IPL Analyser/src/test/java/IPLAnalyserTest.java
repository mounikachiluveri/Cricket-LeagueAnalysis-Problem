import cricketleagueanalysis.IPLAnalyser;
import cricketleagueanalysis.IPLAnalyserException;
import org.junit.Assert;
import org.junit.Test;

    public class IPLAnalyserTest {

        private static final String IPL_BATSMAN_CSV_FILE_PATH = "./src/test/resources/IPLBat.csv";
        private static final String IPL_BATSMAN_CSV_WRONG_FILE_PATH = "./src/resources/IPL2019FactsheetMostRuns.csv";


        @Test
        public void givenIPLFactSheetMostRunsFile_whenProper_shouldReturnCorrectRecordCount() throws IPLAnalyserException {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            int numOfRecords = iplAnalyser.loadIPLFactSheetData(IPLAnalyser.PlayerType.BATSMAN, IPL_BATSMAN_CSV_FILE_PATH);
            Assert.assertEquals(100, numOfRecords);
            System.out.println(numOfRecords);
        }
    }

