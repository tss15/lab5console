package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExcpetionsCommand.InappropriateArgForCommandException;

import java.io.IOException;

public class Help extends Command {
    public Help() {
        this.name = "help";
        this.info = "lists the available commands";
    }

    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException, IOException {
        if (args.length > 1) {
            throw new InappropriateArgForCommandException("This command has no argument");
        } else {
            commandHandle.executeHelp();

        }
    }
}
