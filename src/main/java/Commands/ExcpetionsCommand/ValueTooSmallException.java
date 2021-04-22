package Commands.ExcpetionsCommand;

public class ValueTooSmallException extends RuntimeException {
    public ValueTooSmallException(String message) { super(message);}
}
