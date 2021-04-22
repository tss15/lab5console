package Commands.ExcpetionsCommand;

public class NullException extends RuntimeException {
    public NullException(){super();}
    public NullException(String message){ super(message);}
}
