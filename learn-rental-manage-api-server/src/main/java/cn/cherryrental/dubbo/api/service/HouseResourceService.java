package cn.cherryrental.dubbo.api.service;

import cn.cherryrental.dubbo.api.vo.TableResult;
import cn.cherryrental.dubbo.api.vo.Pagination;
import cn.cherryrental.dubbo.server.api.ApiHouseResourceServive;
import cn.cherryrental.dubbo.server.pojo.HouseResources;
import cn.cherryrental.dubbo.server.pojo.PageInfo;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
// api-service 是服务的消费方
@Service
public class HouseResourceService {
    @Reference(version = "1.0.0")
    private ApiHouseResourceServive apiHouseResourceServive;

    public boolean save(HouseResources houseResources){

        int result = this.apiHouseResourceServive.saveHouseResources(houseResources);
        return result == 1;
    }

    public TableResult queryList(HouseResources houseResources, Integer currentPage, Integer pageSize) {
        PageInfo<HouseResources> pageInfo = this.apiHouseResourceServive.queryHouseResourcesList(currentPage, pageSize, houseResources);
        //需要参考前端AntDesigner需要什么结果
        return new TableResult(pageInfo.getRecords(),new Pagination(currentPage,pageSize,pageInfo.getTotal()));
    }

    public HouseResources queryHouseResourcesById(Long id) {
        return this.apiHouseResourceServive.queryHouseResourcesById(id);
    }

    public boolean update(HouseResources houseResources) {
        return this.apiHouseResourceServive.updateHouseResources(houseResources);
    }
}
