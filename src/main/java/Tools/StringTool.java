package Tools;

import Data.LabWork;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class StringTool {
    public static String Input(){
        return new Scanner(System.in).nextLine();
    }

    public void PrintLabWorkSet(HashMap<Integer, LabWork> hashMap){

        Iterator<LabWork> iterator = hashMap.values().iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next().toString());
        }



//        Iterator<Map.Entry> itr1 = Item_Id.entrySet().iterator();
//        while (itr1.hasNext()) {
//            Map.Entry pair = itr1.next();
//            String key = (String) pair.getKey();
//            String value = (String) pair.getValue();
//            System.out.println(pair.getKey() + " : " + pair.getValue());
//            map.put(key, value);
//        }
    }
}
