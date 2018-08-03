package com.example.ceshi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 石磊 on 2018/7/22.
 */
@Controller
public class KongZhi {
    @RequestMapping("/nihao.com")
    public String say(){
        return "ceshi";
    }
    @RequestMapping("/fanhui.com")
    public String say2(){
        return "index";
    }
    @RequestMapping(value="/biaodan.com")
    public String say3(User user){
        System.out.println(user.getUsername()+","+user.getPassword());
        return "ceshi";
    }
}
