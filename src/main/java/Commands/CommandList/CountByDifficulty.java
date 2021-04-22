package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExcpetionsCommand.InappropriateArgForCommandException;

import java.io.IOException;

public class CountByDifficulty extends Command {
    public CountByDifficulty(){
        this.name = "counts_by_difficulty";
        this.info = "counts elements by given difficulty";
    }
    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException, IOException {
        if(args.length>2||args.length==1){
            throw new InappropriateArgForCommandException("this command only accepts one number parameter\n");
        }else{
            commandHandle.executeCountByDifficulty(args[1]);
        }

    }
}
