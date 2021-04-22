package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExcpetionsCommand.InappropriateArgForCommandException;

import java.io.IOException;

public class Show extends Command {
    public Show() {
        this.name = "show";
        this.info = "print to standard output all elements of the collection in string representation";
    }

    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException, IOException {
        if (args.length > 1) {
            throw new InappropriateArgForCommandException("This command has no argument");
        } else {
            commandHandle.executeShow();

        }
    }
}
