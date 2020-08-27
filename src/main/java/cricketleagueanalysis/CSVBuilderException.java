package cricketleagueanalysis;

public class CSVBuilderException extends Exception {

    enum ExceptionType {
        IPL_FILE_PROBLEM,
        UNABLE_TO_PARSE;
    }

    ExceptionType type;

    public CSVBuilderException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public CSVBuilderException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }

    public CSVBuilderException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }
}