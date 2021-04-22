package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExcpetionsCommand.InappropriateArgForCommandException;

import java.io.IOException;

public class ReplaceIfGreater extends Command {
    public ReplaceIfGreater(){
        this.name = "replace_if_greater";
        this.info = "replace the value by key if the new value is greater than the old one";
    }
    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException, IOException {
        if(args.length>2||args.length==1){
            throw new InappropriateArgForCommandException("this command only accepts one number parameter\n");
        }else{
            commandHandle.executeReplaceIfGreater(args[1]);
        }

    }
}
