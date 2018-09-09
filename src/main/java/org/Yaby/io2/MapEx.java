package org.Yaby.io2;

import java.util.HashMap;
import java.util.Map;

public class MapEx {

    public static void main(String[] args) {


        Map<String,String[]> wordmap = new HashMap<>();
        wordmap.put("월",new String[]{"점심"});
        wordmap.put("화",new String[]{"aa"});
        wordmap.put("수",new String[]{"bb"});

        System.out.println(wordmap.get("cat"));


    }
}
