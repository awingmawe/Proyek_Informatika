package com.trains.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component // Beans nanti akan ditampung pada container
public class TemplateResponse {

    public Map<String, Object> templateSukses(Object objek){
        Map<String, Object> map = new HashMap<>();
        map.put("status", "200");
        map.put("train(s)", objek);
        return map;
    }
    
    public Map<String, String> templateNotFound() {
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        map.put("message", "train not found");
        return map;
    }

    public Map templateSuksesUpdate(Object objek){
        Map map = new HashMap();
        map.put("status", "200");
        map.put("message", objek);
        return map;
    }
    
    public Map templateSuksesInsert() {
    	Map map = new HashMap();
    	map.put("status", "201");
    	map.put("message", "new train added successfully");
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

    public Map<String, String> templateErrorEndpoint(){
        Map<String, String> map = new HashMap<>();
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
