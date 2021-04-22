package Commands.ExcpetionsCommand;

public class InappropriateArgForCommandException extends RuntimeException {
    public InappropriateArgForCommandException(String message) { super(message);}
}
