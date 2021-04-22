package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExcpetionsCommand.InappropriateArgForCommandException;

import java.io.IOException;

public class PrintField extends Command {
    public PrintField() {
        this.name = "print_field_descending_author";
        this.info = "print the values of the author field of all elements in descending order";
    }

    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException, IOException {
        if (args.length > 1) {
            throw new InappropriateArgForCommandException("This command has no argument");
        } else {
            commandHandle.executePrintField();

        }
    }
}
