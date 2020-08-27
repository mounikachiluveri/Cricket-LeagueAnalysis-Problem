package cricketleagueanalysis;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class OpenCSVBuilder<E> implements ICSVBuilder {
        public Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws CSVBuilderException {
            try {
                CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder(reader);
                csvToBeanBuilder.withType(csvClass);
                csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
                CsvToBean<E> csvToBean = csvToBeanBuilder.build();
                return csvToBean.iterator();
            } catch (IllegalStateException e) {
                throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.UNABLE_TO_PARSE);
            }
        }

    @Override
    public List<MostRunsData> getCSVFileList(Reader reader, Class csvClass) throws CSVBuilderException {
        try {
            CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder(reader);
            csvToBeanBuilder.withType(csvClass);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<E> csvToBean = csvToBeanBuilder.build();
            return (List<MostRunsData>) csvToBean.parse();
        } catch (IllegalStateException e) {
            throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.UNABLE_TO_PARSE);
        }
    }
}

