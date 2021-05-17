package cn.cherryrental.dubbo.api.graphql;

import cn.cherryrental.dubbo.api.service.HouseResourceService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HouseResourceListFetcher implements MyDataFetcher {
    @Autowired
    private HouseResourceService houseResourceService;
    @Override
    public String fieldName() {
        return "houseResourcesList";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment dataFetchingEnvironment) {
        Long id = dataFetchingEnvironment.getArgument("id");
        Integer page = dataFetchingEnvironment.getArgument("page");
        Integer pageSize = dataFetchingEnvironment.getArgument("pageSize");
        if (page==null || pageSize==null) {
            page = 1;
            pageSize = 5;
        }
        return this.houseResourceService.queryList(null,page,pageSize);
    }
}
