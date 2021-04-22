package Commands;

import Commands.ExcpetionsCommand.InappropriateArgForCommandException;

import java.io.IOException;

public abstract class Command {
    protected String name;
    protected String info;

    public String getName() {
        return name;
    }


    public String getInfo() {
        return info;
    }

    abstract public void execute(CommandHandle commandHandle, String args[]) throws InappropriateArgForCommandException, IOException;

}
