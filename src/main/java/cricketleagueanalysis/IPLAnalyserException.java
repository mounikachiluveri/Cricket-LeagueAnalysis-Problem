package cricketleagueanalysis;
public class IPLAnalyserException extends Exception{
    public enum ExceptionType {
        IPL_FILE_PROBLEM,FILE_PROBLEM,WRONG_DELIMETER_WRONG_HEADER_FILE,UNABLE_TO_PARSE,NO_CENSUS_DATA,INCORRECT_DATA_PROBLEM ;
    }

    public ExceptionType type;

    public IPLAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }


}