package cn.cherryrental.dubbo.api.controller;

import cn.cherryrental.dubbo.api.service.AdService;
import cn.cherryrental.dubbo.api.vo.WebResult;
import cn.cherryrental.dubbo.server.pojo.Ad;
import cn.cherryrental.dubbo.server.pojo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("ad")
@RestController
@CrossOrigin
public class AdController {

    @Autowired
    private AdService adService;

    @GetMapping
    public WebResult queryIndexAd() {
        PageInfo<Ad> pageInfo = this.adService.queryAdList(1,1,3);
        List<Ad> ads = pageInfo.getRecords();

        List<Map<String,Object>> data = new ArrayList<>();
        for (Ad ad : ads) {
            Map<String,Object> map = new HashMap<>();
            map.put("original",ad.getUrl());
            data.add(map);
        }
        return WebResult.ok(data);

    }
}
