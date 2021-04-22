package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExcpetionsCommand.InappropriateArgForCommandException;

import java.io.IOException;

public class UpdateID extends Command {
    public UpdateID(){
        this.name = "update id";
        this.info = "update the value of the collection element whose id is equal to the given";
    }

    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException, IOException {
        if(args.length>2||args.length==1){
            throw new InappropriateArgForCommandException("this command only accepts one number parameter\n");
        }else{
            commandHandle.executeUpdateID(args[1]);
        }

    }
}
