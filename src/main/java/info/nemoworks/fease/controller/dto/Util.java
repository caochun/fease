package info.nemoworks.fease.controller.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

public class Util {

    public static JSONObject convertJson(Object object){
        int disableDecimalFeature = JSON.DEFAULT_PARSER_FEATURE & ~Feature.UseBigDecimal.getMask();
        String contentStr = JSON.toJSONString(object);
        JSONObject newObject = JSON.parseObject(contentStr,JSONObject.class,disableDecimalFeature);
        return newObject;
    }

}
