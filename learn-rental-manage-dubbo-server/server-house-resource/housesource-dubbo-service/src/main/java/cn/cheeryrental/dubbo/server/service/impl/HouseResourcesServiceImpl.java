package cn.cheeryrental.dubbo.server.service.impl;

import cn.cheeryrental.dubbo.server.service.HouseResourcesService;
import cn.cherryrental.dubbo.server.pojo.HouseResources;
import cn.cherryrental.dubbo.server.pojo.PageInfo;
import cn.cherryrental.dubbo.server.service.BaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HouseResourcesServiceImpl extends BaseServiceImpl<HouseResources>
        implements HouseResourcesService {

    /**
         *
         * @param houseResources
         *
         * @return -1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
         */
    //新增房源
    @Override
    public int saveHouseResources(HouseResources houseResources) {
        if(StringUtils.isBlank(houseResources.getTitle())){
            //不符合要求
            return -1;
        }
        return super.save(houseResources);
    }

    @Override
    public PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition) {
        // mybatisPlus 分页
        QueryWrapper<HouseResources> queryWrapper = new QueryWrapper<>(queryCondition);
        //对查询列表最新显示在最前
        queryWrapper.orderByDesc("updated");
        IPage<HouseResources> iPage = super.queryPageList(queryWrapper,page,pageSize);

        return new PageInfo<HouseResources>(Long.valueOf(iPage.getTotal()).intValue(),page,pageSize,iPage.getRecords());
    }

    @Override
    public HouseResources queryHouseResourcesById(Long id) {
        return super.queryById(id);
    }

    @Override
    public boolean updateHouseResources(HouseResources houseResources) {
        return super.update(houseResources) == 1;
    }
}
