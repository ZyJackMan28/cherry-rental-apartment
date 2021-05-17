package cn.cherryrental.dubbo.api.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("wx")
@RestController
public class WxLoginController {


    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @PostMapping("login")
    public Map<String,Object> wxLogin(@RequestParam("code") String code){
        Map<String,Object> res = new HashMap<>();
        String appid = "wx6e512960f1ffe11f";
        String secret = "53f626a1273173681bcffe76c859ad32";
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx6e512960f1ffe11f&secret=53f626a1273173681bcffe76c859ad32&js_code="
              +  code+ "&grant_type=authorization_code";

        String json = this.restTemplate.getForObject(url, String.class);
        if (StringUtils.contains(json,"errcode")){
            res.put("status",500);
            res.put("msg","登陆失败");

            return res;
        }
        //需要将appid, openid 关联自己的服务---保存在redis
        String ticket = "Rental_" + DigestUtils.md5Hex(json);
        String redisKey = "Wx_Login_" + ticket;
        this.redisTemplate.opsForValue().set(redisKey,json, Duration.ofHours(1));

        res.put("ticket",ticket);
        res.put("status",200);
        return res;

    }
}
