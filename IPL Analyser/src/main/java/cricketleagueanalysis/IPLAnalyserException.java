package cricketleagueanalysis;

public class IPLAnalyserException extends Throwable {

    public enum ExceptionType {
        INPUT_FILE_PROBLEM,
        INCORRECT_DATA_PROBLEM,
        INVALID_PLAYER,
        NO_PLAYER_DATA,
        INCORRECT_FILE_FORMAT;
    }

    public ExceptionType type;

    public IPLAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public IPLAnalyserException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }
}

