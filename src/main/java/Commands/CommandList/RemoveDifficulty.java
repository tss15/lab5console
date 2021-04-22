package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExcpetionsCommand.InappropriateArgForCommandException;

import java.io.IOException;

public class RemoveDifficulty extends Command {
    public RemoveDifficulty(){
        this.name = "remove_any_by_difficulty";
        this.info = "remove from the collection one element whose difficulty field value is equivalent to the specified one";
    }
    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException, IOException {
        if(args.length>2||args.length==1){
            throw new InappropriateArgForCommandException("this command only accepts one number parameter\n");
        }else{
            commandHandle.executeRemoveDifficulty(args[1]);
        }

    }
}
