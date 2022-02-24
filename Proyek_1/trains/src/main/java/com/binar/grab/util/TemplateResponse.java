package com.binar.grab.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component // Beans nanti akan ditampung pada container
public class TemplateResponse {

    public Map templateSukses(Object objek){
        Map map = new HashMap();
        map.put("status", "200");
        map.put("train", objek);
        return map;
    }

    public Map templateSuksesUpdate(Object objek){
        Map map = new HashMap();
        map.put("status", "200");
        map.put("message", objek);
        return map;
    }

    public Map templateError(Object objek){
        Map map = new HashMap();
        map.put("status", "400");
        map.put("message", objek);
        return map;
    }

    public Map templateErrorNotFound(Object objek){
        Map map = new HashMap();
        map.put("status", "404");
        map.put("message", objek);
        return map;
    }

    public Map templateErrorEndpoint(){
        Map map = new HashMap();
        map.put("status", "405");
        map.put("message", "invalid endpoint");
        return map;
    }

    public boolean checkNull(Object obj){
        if (obj == null){
            return true;
        }
        return false;
    }
}
