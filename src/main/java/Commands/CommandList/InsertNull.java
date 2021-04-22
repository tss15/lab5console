package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExcpetionsCommand.InappropriateArgForCommandException;
import Data.LabWork;

import java.io.IOException;

public class InsertNull extends Command {
    public InsertNull(){
        this.name = "insert";
        this.info = "adds new element with given key";
    }
    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException, IOException {
        if(args.length>2||args.length==1){
            throw new InappropriateArgForCommandException("this command only accepts one number parameter\n");
        }else{
            commandHandle.executeInsertNull(args[1],LabWork.LabWorkCreate());
        }

    }
}
