package Commands;


import Commands.CommandList.*;
import Commands.ExcpetionsCommand.*;
import Data.*;
import Tools.StringTool;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class CommandHandle {
    public CommandHandle(){
        commands.put(1, new Clear());
        commands.put(2, new CountByDifficulty());
        commands.put(3, new ExecuteScript());
        commands.put(4, new Exit());
        commands.put(5, new Help());
        commands.put(6, new Info());
        commands.put(7, new InsertNull());
        commands.put(8, new PrintField());
        commands.put(9, new RemoveDifficulty());
        commands.put(10, new RemoveKeyNull());
        commands.put(11, new RemoveLowerkey());
        commands.put(12, new ReplaceIfGreater());
        commands.put(13, new ReplaceIfLower());
        commands.put(14, new Save());
        commands.put(15, new Show());
        commands.put(16, new UpdateID());

    }

    HashMap<Integer, Command> commands = new HashMap<>();

//    public HashMap getCommands() {return.this.commands};


    public HashMap<Integer, Command> getCommands() {
        return commands;
    }

    public void executeHelp() {
        Iterator<Command> iterator = commands.values().iterator();
        while (iterator.hasNext()) {
            Command A = iterator.next();
            System.out.print(A.getName() + ": "+A.getInfo() + "\n");
        }

    }

    public void executeClear() throws IOException {
        File file = new File ("ScriptFile/file.json");
        FileWriter fwOb = new FileWriter(file,false);
        PrintWriter pwOb = new PrintWriter(fwOb,false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
        new LabWorkCollection().getLabWorks().clear();

    }

    public void executeInsertNull(String num, LabWork labwork) throws ValueTooBigException, ValueTooSmallException, NullException {
        new LabWorkCollection().doInitialization();
        new LabWorkCollection().getLabWorks().put(Integer.parseInt(num), labwork);
    }

    public void executeShow(){
        if (new LabWorkCollection().getLabWorks().size()==0){
            throw new NullException("collection still empty\n");
        }
        new StringTool().PrintLabWorkSet(new LabWorkCollection().getLabWorks());
    }

    public void executeInfo(){
        if (!LabWorkCollection.Initialization){
            throw new NotInitialization("collection wasn't initialized");
        }else {
            System.out.print("the date of initialization "+ new LabWorkCollection().getInitializationTime()+"\n");
        }
        System.out.print("the amount of elements "+ new LabWorkCollection().getLabWorks().size()+ "\n");
        System.out.print("the type of collection is "+ new LabWorkCollection().getLabWorks().getClass() +"\n");
    }

    public void executeSave() throws IOException{
        HashMap<Integer,LabWork> hashMap = new LabWorkCollection().getLabWorks();
        File file = new File("ScriptFile/file.json");
        PrintWriter writer = new PrintWriter(file);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(hashMap);
        writer.write(json);
        writer.close();
    }

    public void executeExit() {
        System.out.print("exit program");
        System.exit(0);
    }

    public void executeScript(String name, CommandHandle commandHandle) throws IOException, InappropriateArgForCommandException {
        String folder = System.getenv("IN_PATH");
        System.out.println(folder);
        if(folder == null){
            System.out.println("Environment Variable is not set, argument will be used");
            File text = new File("ScriptFile/"+name);
            Scanner s = new Scanner(text);
            try {
                while (s.hasNextLine()) {
                    String line = s.nextLine();
                    String[] split = line.split(" ");
                    Command command = findCommand(split[0]);

                    if (command != null && !(command.getName().equals("insert"))) {
                        command.execute(commandHandle, split);
                    } else {
                        insertToScript(s, command, split);
                    }
                }
            }catch (InappropriateArgForCommandException | IOException e){
                System.out.println(e.getMessage());
            }
        }else {
            System.out.println("Environment Variable is successfully used");
            File text = new File(folder + name);
            Scanner s = new Scanner(text);
            try {
                while (s.hasNextLine()) {
                    String line = s.nextLine();
                    String[] split = line.split(" ");
                    Command command = findCommand(split[0]);

                    if (command != null && !(command.getName().equals("insert"))) {
                        command.execute(commandHandle, split);
                    } else {
                        insertToScript(s, command, split);
                    }
                }
            } catch (InappropriateArgForCommandException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Command findCommand(String name) {
        Command A = null;
        Command B;
        new LabWorkCollection().doInitialization();
        Iterator<Command> iterator = commands.values().iterator();
        while(iterator.hasNext()){
            if ((B = iterator.next()).getName().equalsIgnoreCase(name)){
                A = B;
            }
        }
        return A;
    }

    public LabWork insertToScript(Scanner s, Command command, String[] num) {
        String sx, sy,sminimalPoint, sdifficulty, spweight, seyeColor, shairColor, snationality, slx,sly;
        Long x;
        double y;
        String name;
        double minimalPoint;
        Difficulty difficulty;
        String pname;
        Double pweight;
        Color eyeColor;
        hairColor hairColor;
        Country nationality;
        LabWork labWork = null;
        Long lx;
        double ly;
        String lname;
        String labName;
        while (s.hasNext()) {
            String line1 = s.nextLine();
            Scanner scn = new Scanner(line1);
            scn.useDelimiter("#");
            labName = scn.next();
            sx = scn.next();
            x = Long.valueOf(sx);
            sy = scn.next();
            y = Double.valueOf(sy);
            sminimalPoint = scn.next();
            minimalPoint = Double.valueOf(sminimalPoint);
            sdifficulty = scn.next();
            pname = scn.next();
            spweight = scn.next();
            pweight = Double.valueOf(spweight);
            seyeColor = scn.next();
            shairColor = scn.next();
            snationality = scn.next();
            slx = scn.next();
            lx = Long.valueOf(slx);
            sly = scn.next();
            ly = Double.valueOf(sly);
            lname = scn.next();

            difficulty = Difficulty.valueOf(sdifficulty.toUpperCase());
            eyeColor = Color.valueOf(seyeColor.toUpperCase());
            hairColor = Data.hairColor.valueOf(shairColor.toUpperCase());
            nationality = Country.valueOf(snationality.toUpperCase());

            Coordinates coordinates = new Coordinates(x, y);
            Location location = new Location(lx, ly, lname);
            Person author = new Person(pname, pweight,eyeColor, hairColor, nationality, location);

            new LabWorkCollection().doInitialization();
            labWork = new LabWorkCollection().getLabWorks().put(Integer.valueOf(num[1]), new LabWork(labName, coordinates, minimalPoint, difficulty, author));
            if (command != null) {break;}
        }
        return labWork;
    }

    public void executeUpdateID(String in) {
        Integer id = Integer.valueOf(in);
        LabWork labWork;
        Iterator<LabWork> iterator = new LabWorkCollection().getLabWorks().values().iterator();
        while (iterator.hasNext()) {
            if ((labWork = iterator.next()).getId().equals(id)) {
                LabWork insert = LabWork.LabWorkCreate();
                insert.changeId(id);
                new LabWorkCollection().getLabWorks().replace(id,insert);
            }
        }
    }

    public void executeCountByDifficulty(String option){
        new LabWorkCollection().doInitialization();
        HashMap<Integer, LabWork> labWorkHashMap = new HashMap<Integer, LabWork>();
        LabWorkCollection collection = new LabWorkCollection();
        for(Map.Entry<Integer, LabWork> labWork : collection.getLabWorks().entrySet()){
            if (labWork.getValue().getDifficulty().toString().equalsIgnoreCase(option)){
                labWorkHashMap.put(labWork.getKey(),labWork.getValue());
                System.out.println(labWorkHashMap.toString());
            }
        }
        if (labWorkHashMap.isEmpty()){
            System.out.println("No such difficulty found");
        }
    }

    public void executePrintField(){
        PersonComparator compareAuthor = new PersonComparator();
        new LabWorkCollection().doInitialization();
        List<LabWork> labWorkSorted = new ArrayList<>(new LabWorkCollection().getLabWorks().values());
        labWorkSorted.sort(Collections.reverseOrder(compareAuthor));
        System.out.println(labWorkSorted);
    }

    public void executeRemoveDifficulty(String option){
        new LabWorkCollection().doInitialization();
        HashMap<Integer, LabWork> labWorkHashMap = new HashMap<>();
        LabWorkCollection collection = new LabWorkCollection();
        for(Map.Entry<Integer, LabWork> labWork : collection.getLabWorks().entrySet()){
            if (labWork.getValue().getDifficulty().toString().equalsIgnoreCase(option)){
                labWorkHashMap.remove(labWork.getKey(), labWork.getValue());
                System.out.println(labWorkHashMap.toString());
            }
        }
        if (labWorkHashMap.isEmpty()){
            System.out.println("There is no labwork with such difficulty");
        }
    }

    public void executeRemoveKeyNull(Integer key){
        new LabWorkCollection().doInitialization();
        new LabWorkCollection().getLabWorks().remove(key);
    }

    public void executeRemoveLowerkey(Integer key){
        new LabWorkCollection().doInitialization();
        new LabWorkCollection().getLabWorks().entrySet().removeIf(entry -> entry.getKey()< key);
    }

    public void executeReplaceIfGreater(String in){
        new LabWorkCollection().doInitialization();
        Integer id = Integer.valueOf(in);
        Iterator<LabWork> iterator = new LabWorkCollection().getLabWorks().values().iterator();
            LabWork insert = LabWork.LabWorkCreate();
            if (new LabWorkCollection().getLabWorks().entrySet().iterator().next().getValue().getMinimalPoint()<insert.getMinimalPoint()){
                new LabWorkCollection().getLabWorks().replace(id,insert);
            }else {
                System.out.println("wasn't added because the value was lower");
            }
    }

    public void executeReplaceIfLower(String in){
        new LabWorkCollection().doInitialization();
        Integer id = Integer.valueOf(in);
        Iterator<LabWork> iterator = new LabWorkCollection().getLabWorks().values().iterator();
        LabWork insert = LabWork.LabWorkCreate();
        if (new LabWorkCollection().getLabWorks().entrySet().iterator().next().getValue().getMinimalPoint()>insert.getMinimalPoint()){
            new LabWorkCollection().getLabWorks().replace(id,insert);
        }else {
            System.out.println("wasn't added because the value was greater");
        }
    }
}

