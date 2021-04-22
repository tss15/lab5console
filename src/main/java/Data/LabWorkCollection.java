package Data;

import Commands.ExcpetionsCommand.Initialization;

import java.time.LocalDate;
import java.util.HashMap;

public class LabWorkCollection {
    private static LocalDate InitializationTime;
    private static HashMap<Integer, LabWork> labWorks;
    public static boolean Initialization = false;

    public HashMap<Integer, LabWork> getLabWorks() throws Initialization {
        if (!Initialization){
            throw new Initialization("collection wasn't initialized");
        }else{
            return labWorks;
        }
    }

    public void doInitialization(){
        if (!Initialization){
            labWorks = new HashMap<>();
            InitializationTime = LocalDate.now();
            Initialization = true;
        }
    }

    public LocalDate getInitializationTime() {
        return InitializationTime;
    }
}
