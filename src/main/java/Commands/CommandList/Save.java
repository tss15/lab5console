package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExcpetionsCommand.InappropriateArgForCommandException;

import java.io.IOException;

public class Save extends Command {
    public Save() {
        this.name = "save";
        this.info = "save collection to file";
    }

    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException, IOException {
        if (args.length > 1) {
            throw new InappropriateArgForCommandException("This command has no argument");
        } else {
            commandHandle.executeSave();

        }
    }
}
