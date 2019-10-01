package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        HashMap myMap= new HashMap();
        myMap.put("wilson", 97);
        myMap.put("carol", 100);
        myMap.put("Purity", 99);
        myMap.put("Esther", 98);
if (myMap.containsKey("wilon")){
    System.out.println("WHAT A TALENTED PROGRAMMER WILSON IS");
}else{
    System.out.println("Painful that our talented programmer ain't around");
}

        Iterator it = myMap.entrySet().iterator();
while(it.hasNext()){
    Map.Entry pair=(Map.Entry) it.next();
    System.out.println("Key: " + pair.getKey() + " Value: " +pair.getValue() );
}

for (Object mymap :myMap.entrySet() ){
    System.out.println(mymap);
}
//        System.out.println(myMap.get("wilson"));
//        System.out.println(myMap.keySet());
//        System.out.println(myMap.values());
//        System.out.println("Entire set: "+ myMap.entrySet());
    }
}
