package cricketleagueanalysis;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

    public class IPLDataLoader {
        public <E> Map<String,IPLDAO> loadIPLFactSheetData(IPLAnalyser.PlayerType playerType, String... csvFilePath) throws IPLAnalyserException{
            if (playerType.equals(IPLAnalyser.PlayerType.BATSMAN))
                return this.loadIPLFactSheetData(MostRunsData.class, csvFilePath);
            else if (playerType.equals(IPLAnalyser.PlayerType.BOWLER))
                return this.loadIPLFactSheetData(MostWicketsData.class, csvFilePath);
            else throw new IPLAnalyserException("Incorrect player type", IPLAnalyserException.ExceptionType.INVALID_PLAYER);
        }
        private <E> Map<String, IPLDAO> loadIPLFactSheetData(Class<E> cricketCSVClass, String... csvFilePath) throws IPLAnalyserException {
            Map<String, IPLDAO> cricketLeagueMap = new HashMap<>();
            try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath[0]))) {
                ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
                Iterator<E> cricketCSVIterator = csvBuilder.getCSVFileIterator(reader, cricketCSVClass);
                Iterable<E> cricketCSVIterable = () -> cricketCSVIterator;
                if(cricketCSVClass.getName().equals("cricketleagueanalysis.MostRunsData")){
                    StreamSupport.stream(cricketCSVIterable.spliterator(), false)
                            .map(MostRunsData.class::cast)
                            .forEach(cricketCSV -> cricketLeagueMap.put(cricketCSV.player, new IPLDAO(cricketCSV)));
                }else if (cricketCSVClass.getName().equals("cricketleagueanalysis.MostWicketsData")){
                    StreamSupport.stream(cricketCSVIterable.spliterator(), false)
                            .map(MostWicketsData.class::cast)
                            .forEach(cricketCSV -> cricketLeagueMap.put(cricketCSV.player, new IPLDAO(cricketCSV)));
                }

                return cricketLeagueMap;
            } catch (IOException e) {
                throw new IPLAnalyserException(e.getMessage(), IPLAnalyserException.ExceptionType.INPUT_FILE_PROBLEM);
            } catch (RuntimeException e) {
                throw new IPLAnalyserException(e.getMessage(), IPLAnalyserException.ExceptionType.INCORRECT_DATA_PROBLEM);
            } catch (CSVBuilderException e) {
                throw new IPLAnalyserException(e.getMessage(), e.type.name());
            }
        }

    }
