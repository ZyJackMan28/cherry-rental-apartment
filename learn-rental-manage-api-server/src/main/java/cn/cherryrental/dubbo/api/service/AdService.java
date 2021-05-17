package cn.cherryrental.dubbo.api.service;

import cn.cherryrental.dubbo.api.vo.WebResult;
import cn.cherryrental.dubbo.server.api.ApiAdService;
import cn.cherryrental.dubbo.server.pojo.Ad;
import cn.cherryrental.dubbo.server.pojo.PageInfo;
import com.alibaba.dubbo.config.annotation.Reference;


import org.springframework.stereotype.Service;

@Service
public class AdService {

    @Reference(version = "1.0.0")
    private ApiAdService apiAdService;

    public PageInfo<Ad> queryAdList(Integer type, Integer page, Integer pageSize) {
        PageInfo<Ad> adPageInfo = this.apiAdService.queryAdList(type,page,pageSize);
        return adPageInfo;
    }


}
