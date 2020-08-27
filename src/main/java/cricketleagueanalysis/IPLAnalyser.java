package cricketleagueanalysis;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IPLAnalyser {
    List<MostRunsData> statisticList = null;

    public IPLAnalyser() {
        this.statisticList = new ArrayList<MostRunsData>();
    }

    public int loadIPLData(String csvFilePath) throws IPLAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVbuilder();
            statisticList = csvBuilder.getCSVFileList(reader, MostRunsData.class);

        }  catch (IOException e) {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.WRONG_DELIMETER_WRONG_HEADER_FILE);
        } catch (CSVBuilderException e) {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.UNABLE_TO_PARSE);
        }
        return statisticList.size();
    }

    public String getSortedData(SortBy avg){
        String sortedIPLDataJson = "";
        List<MostRunsData> list = new ArrayList<>();
        list = this.statisticList.stream().sorted((MostRunsData c1, MostRunsData c2) -> c2.average.compareTo(c1.average))
                .collect(Collectors.toList());
        sortedIPLDataJson = new Gson().toJson(list);
        return sortedIPLDataJson;

    }
}
