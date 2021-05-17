package cn.cherryrental.dubbo.api.graphql;

import cn.cherryrental.dubbo.api.service.HouseResourceService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HouseResourceFetcher implements MyDataFetcher {
    @Autowired
    private HouseResourceService houseResourceService;
    @Override
    public String fieldName() {
        return "houseResources";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment dataFetchingEnvironment) {
        Long id = dataFetchingEnvironment.getArgument("id");
        return this.houseResourceService.queryHouseResourcesById(id);
    }
}
