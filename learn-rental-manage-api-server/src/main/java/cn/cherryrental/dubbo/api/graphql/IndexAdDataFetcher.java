package cn.cherryrental.dubbo.api.graphql;

import cn.cherryrental.dubbo.api.service.AdService;
import cn.cherryrental.dubbo.api.service.HouseResourceService;
import cn.cherryrental.dubbo.api.vo.IndexAdResult;
import cn.cherryrental.dubbo.api.vo.IndexAdResultData;
import cn.cherryrental.dubbo.server.pojo.Ad;
import cn.cherryrental.dubbo.server.pojo.PageInfo;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class IndexAdDataFetcher implements MyDataFetcher {
    @Autowired
    private AdService adService;
    @Override
    public String fieldName() {
        return "indexAdList";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment dataFetchingEnvironment) {
        PageInfo<Ad> pageInfo = this.adService.queryAdList(1,1,3);
        List<Ad> ads = pageInfo.getRecords();
        List<IndexAdResultData> list = new ArrayList<>();

        List<Map<String,Object>> data = new ArrayList<>();
        for (Ad ad : ads) {
            list.add(new IndexAdResultData(ad.getUrl()));
        }
        return new IndexAdResult(list);
    }
}
