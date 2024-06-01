package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class sample {

    public static void main(String[] arges){

        String param = "Kamal Indika";
            String maxCountChar;
        char[] tmp = param.toCharArray();
        HashMap<String, Integer> count =new HashMap<String, Integer>();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<tmp.length;i++){
            String mapKey = String.valueOf(tmp[i]);

            if(count.containsKey(mapKey)){
                count.put((mapKey), count.get(mapKey) + 1);

            }else{
                count.put((mapKey), 1);
            }


        }

//        for(int i=0;i<tmp.length;i++){
//            String mapKey = new String(String.valueOf(tmp[i]));
//            list.add(count.get(mapKey));
//        }
//        list.stream().max(Integer::compareTo);
//
//        param.toCharArray()
//
//               List<String> temList = Arrays.asList("A", "S");
//        temList.stream()

        System.out.println(count);




    }
}
