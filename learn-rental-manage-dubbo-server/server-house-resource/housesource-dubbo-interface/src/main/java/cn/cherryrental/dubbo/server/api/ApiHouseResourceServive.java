package cn.cherryrental.dubbo.server.api;

import cn.cherryrental.dubbo.server.pojo.HouseResources;
import cn.cherryrental.dubbo.server.pojo.PageInfo;

public interface ApiHouseResourceServive {

         /**
         *
         * @param houseResources
         *
         * @return -1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
         */
         int saveHouseResources(HouseResources houseResources);


    /**
     *  房源列表
     */
    PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize,
                                                     HouseResources queryCondition);

    /**
         * 根据id查找房源数据
         * 整合Springboot GraphQL
         * @param id
         * @return
         */
    HouseResources queryHouseResourcesById(Long id);

    boolean updateHouseResources(HouseResources houseResources);
}
