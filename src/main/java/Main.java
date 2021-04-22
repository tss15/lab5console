import Commands.Command;
import Commands.CommandHandle;
import Commands.ExcpetionsCommand.*;
import Data.LabWorkCollection;
import Settings.ReadJson;
import Tools.StringTool;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        new LabWorkCollection().doInitialization();
        ReadJson rr = new ReadJson();
        rr.jsonRead(new LabWorkCollection().getLabWorks());
        System.out.println("Please print \"help\" command for the navigation.");
        while (true){
            boolean isCommandExist = false;
            CommandHandle commandHandle = new CommandHandle();
            Command command;
            Iterator<Command> iterator = commandHandle.getCommands().values().iterator();

            System.out.print(">>");
            String[] commands = StringTool.Input().split(" ");
            try {
                while(iterator.hasNext()) {
                    if((command = iterator.next()).getName().equalsIgnoreCase(commands[0])) {
                        command.execute(commandHandle, commands);
                        isCommandExist = true;
                    }
                }
                if(!isCommandExist) {
                    throw new UnknownCommandException("No such command, please enter another one");
                }
            }catch (UnknownCommandException | NullException | Initialization| NotInitialization|ValueTooSmallException|ValueTooBigException |InappropriateArgForCommandException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
