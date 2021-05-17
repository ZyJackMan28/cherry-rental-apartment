package cn.cheeryrental.dubbo.server.api;

import cn.cheeryrental.dubbo.server.service.HouseResourcesService;
import cn.cherryrental.dubbo.server.api.ApiHouseResourceServive;
import cn.cherryrental.dubbo.server.pojo.HouseResources;

import cn.cherryrental.dubbo.server.pojo.PageInfo;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class ApiHouseResourcesServiceImpl implements ApiHouseResourceServive {

    @Autowired
    private HouseResourcesService houseResourcesService;

    @Override
    public int saveHouseResources(HouseResources houseResources) {

        return this.houseResourcesService.saveHouseResources(houseResources);
    }

    @Override
    public PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition) {

        return this.houseResourcesService.queryHouseResourcesList(page,pageSize,queryCondition);
    }

    @Override
    public HouseResources queryHouseResourcesById(Long id) {
        return this.houseResourcesService.queryHouseResourcesById(id);
    }

    @Override
    public boolean updateHouseResources(HouseResources houseResources) {
        return this.houseResourcesService.updateHouseResources(houseResources);
    }
}
