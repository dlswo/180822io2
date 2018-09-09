package org.Yaby.io2;

import java.util.HashMap;
import java.util.Map;

public class HanSotMaker implements MsgMaker {

    Map<String,String[]> stringMap;

    public HanSotMaker() {
        stringMap = new HashMap<>();
        stringMap.put("월",new String[]{"AAA","ABB","ACC"});
        stringMap.put("화",new String[]{"BAA","BBB","BCC"});
        stringMap.put("수",new String[]{"CAA","CBB","CCC"});
        stringMap.put("목",new String[]{"DAA","DBB","DCC"});
        stringMap.put("금",new String[]{"EAA","EBB","ECC"});
        stringMap.put("토",new String[]{"FAA","FBB","FCC"});
    }

    @Override
    public String[] getMsg(String key) {
        return stringMap.get(key);
    }
}
