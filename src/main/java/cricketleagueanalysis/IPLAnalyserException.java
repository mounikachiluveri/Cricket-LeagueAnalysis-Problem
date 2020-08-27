package cricketleagueanalysis;
public class IPLAnalyserException extends Exception{
    public enum ExceptionType {
        IPL_FILE_PROBLEM, INCORRECT_CSV_INPUT, INVALID_COUNTRY;
    }

    public ExceptionType type;

    public IPLAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }


}