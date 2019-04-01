package com.example.demo;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/cloud")
public class cloudController {
    @GetMapping("/getdata")
    public JSONArray getLog(){
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("发生时间","2019 - 01 - 12 00: 05: 45");
        jsonObject.put("服务器IP","101.227.180.62");
        jsonObject.put("客户端IP","207.46.13.36");
        jsonObject.put("事件","爬虫");
        jsonObject.put("威胁","低");
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("发生时间","2019 - 01 - 13 00: 05: 45");
        jsonObject1.put("服务器IP","101.227.180.62");
        jsonObject1.put("客户端IP","207.46.13.36");
        jsonObject1.put("事件","跨域式攻击");
        jsonObject1.put("威胁","高");
        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject1);
        return jsonArray;
    }
    @GetMapping("/getlog")
    public JSONArray getLogs(){
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("标签","爬虫");
        jsonObject.put("服务器IP","101.227.180.62");
        jsonObject.put("客户端IP","207.46.13.36");
        jsonObject.put("事件","爬虫");
        jsonObject.put("威胁","低");
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("发生时间","2019 - 01 - 13 00: 05: 45");
        jsonObject1.put("服务器IP","101.227.180.62");
        jsonObject1.put("客户端IP","207.46.13.36");
        jsonObject1.put("事件","跨域式攻击");
        jsonObject1.put("威胁","高");
        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject1);
        return jsonArray;
    }

}
