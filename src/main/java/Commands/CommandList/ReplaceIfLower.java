package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExcpetionsCommand.InappropriateArgForCommandException;

import java.io.IOException;

public class ReplaceIfLower extends Command {
    public ReplaceIfLower(){
        this.name = "replace_if_lower";
        this.info = "replace the value by key if the new value is less than the old one";
    }

    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException, IOException {
        if(args.length>2||args.length==1){
            throw new InappropriateArgForCommandException("this command only accepts one number parameter\n");
        }else{
            commandHandle.executeReplaceIfLower(args[1]);
        }

    }
}
