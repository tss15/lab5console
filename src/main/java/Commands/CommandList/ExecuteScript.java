package Commands.CommandList;

import Commands.Command;
import Commands.CommandHandle;
import Commands.ExcpetionsCommand.InappropriateArgForCommandException;

import java.io.IOException;

public class ExecuteScript extends Command {
    public ExecuteScript(){
        this.name = "execute_script";
        this.info = "read and execute script of a given file";
    }
    @Override
    public void execute(CommandHandle commandHandle, String[] args) throws InappropriateArgForCommandException, IOException {
        if(args.length>2||args.length==1){
            throw new InappropriateArgForCommandException("this command only accepts one number parameter\n");
        }else{
            commandHandle.executeScript(args[1],commandHandle);
        }

    }
}
