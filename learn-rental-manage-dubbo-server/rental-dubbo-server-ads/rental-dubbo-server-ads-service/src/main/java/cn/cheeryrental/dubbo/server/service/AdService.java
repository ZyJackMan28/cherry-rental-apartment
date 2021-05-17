package cn.cheeryrental.dubbo.server.service;

import cn.cherryrental.dubbo.server.pojo.Ad;
import cn.cherryrental.dubbo.server.pojo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface AdService {


    public PageInfo<Ad> queryAdList(Ad ad, Integer page, Integer pageSize);
}
