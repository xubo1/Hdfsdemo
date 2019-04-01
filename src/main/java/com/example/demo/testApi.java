package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import sun.misc.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.core.io.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/test")
public class testApi {

    @Value("classpath:static/app.json")
    Resource appJson;
    @RequestMapping("/api")
    public void test() throws IOException {
        String jsonStr;
        jsonStr = new String(IOUtils.readFully(appJson.getInputStream(), -1,true));
        JSONObject json = JSONObject.parseObject(jsonStr);
        json.getJSONArray("dimensions").add("事件");

    }
}

