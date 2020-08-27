package cricketleagueanalysis;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

    public class IPLAnalyser {
        public int loadIPLData(String csvFilePath) throws IPLAnalyserException, CSVBuilderException {
            List<MostRunsData> iplBatsmanCSVList = new ArrayList<MostRunsData>();
            int  noOfRecords = 0;
            try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
                Iterator<MostRunsData> CSVIterator = IPLBuilderFactory.createCSVbuilder().getCSVFileIterator(reader, MostRunsData.class);
                Iterable<MostRunsData> csvIterable = () -> CSVIterator;
                noOfRecords = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return noOfRecords;
        }
    }


