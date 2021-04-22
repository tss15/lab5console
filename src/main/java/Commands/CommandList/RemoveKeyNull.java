package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExcpetionsCommand.InappropriateArgForCommandException;

import java.io.IOException;

public class RemoveKeyNull extends Command {
    public RemoveKeyNull(){
        this.name = "remove_key_null";
        this.info = "remove an item from the collection by its key";
    }
    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException, IOException {
        if(args.length>2||args.length==1){
            throw new InappropriateArgForCommandException("this command only accepts one number parameter\n");
        }else{
            commandHandle.executeRemoveKeyNull(Integer.valueOf(args[1]));
        }
    }
}
