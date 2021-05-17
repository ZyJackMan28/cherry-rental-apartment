package cn.cheeryrental.dubbo.server.service.impl;

import cn.cheeryrental.dubbo.server.service.AdService;
import cn.cherryrental.dubbo.server.pojo.Ad;
import cn.cherryrental.dubbo.server.pojo.PageInfo;
import cn.cherryrental.dubbo.server.service.BaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdServiceImpl extends BaseServiceImpl<Ad> implements AdService {


    @Override
    public PageInfo<Ad> queryAdList(Ad ad, Integer page, Integer pageSize) {
        QueryWrapper<Ad> queryWrapper = new QueryWrapper<>();

        queryWrapper.orderByDesc("updated");
        queryWrapper.eq("type",ad.getType());
        IPage<Ad> iPage = super.queryPageList(queryWrapper, page, pageSize);
        return new PageInfo(Long.valueOf(iPage.getTotal()).intValue(),page,pageSize,iPage.getRecords());
    }
}
