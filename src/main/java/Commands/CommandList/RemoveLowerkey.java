package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExcpetionsCommand.InappropriateArgForCommandException;

import java.io.IOException;

public class RemoveLowerkey extends Command {
    public RemoveLowerkey(){
        this.name = "remove_lower_key";
        this.info = "remove from the collection all elements whose key is less than the given one";
    }

    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException, IOException {
        if(args.length>2||args.length==1){
            throw new InappropriateArgForCommandException("this command only accepts one number parameter\n");
        }else{
            commandHandle.executeRemoveLowerkey(Integer.valueOf(args[1]));
        }

    }
}
