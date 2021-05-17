package cn.cheeryrental.dubbo.server.api;

import cn.cheeryrental.dubbo.server.service.AdService;
import cn.cherryrental.dubbo.server.api.ApiAdService;
import cn.cherryrental.dubbo.server.pojo.Ad;
import cn.cherryrental.dubbo.server.pojo.PageInfo;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class ApiAdServiceImpl implements ApiAdService {
 
    @Autowired
    private AdService adService;
 
    @Override
    public PageInfo<Ad> queryAdList(Integer type, Integer page, Integer pageSize) {
 
   Ad ad = new Ad();
   ad.setType(type);
 
   return this.adService.queryAdList(ad, page, pageSize);
   }
}