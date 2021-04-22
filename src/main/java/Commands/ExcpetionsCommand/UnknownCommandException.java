package Commands.ExcpetionsCommand;

public class UnknownCommandException extends RuntimeException{
    public UnknownCommandException(String message) {super(message);}
}
