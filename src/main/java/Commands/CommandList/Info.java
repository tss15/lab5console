package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExcpetionsCommand.InappropriateArgForCommandException;

import java.io.IOException;

public class Info extends Command {
    public Info() {
        this.name = "info";
        this.info = "print collection information to standard output";
    }

    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException, IOException {
        if (args.length > 1) {
            throw new InappropriateArgForCommandException("This command has no argument");
        } else {
            commandHandle.executeInfo();
        }
    }
}
