package cn.cherryrental.dubbo.api.graphql;

import cn.cherryrental.dubbo.api.service.MongoHouseService;
import cn.cherryrental.dubbo.api.vo.MapHouseDataResult;
import cn.cherryrental.dubbo.api.vo.MapHouseXY;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapHouseDataFetcher implements MyDataFetcher {

    @Autowired
    private MongoHouseService mongoHouseService;
    @Override
    public String fieldName() {
        return "mapHouseData";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment dataFetchingEnvironment) {
        //List<MapHouseXY> list = new ArrayList<>();

        Float lng = ((Double)dataFetchingEnvironment.getArgument("lng")).floatValue();
        Float lat = ((Double) dataFetchingEnvironment.getArgument("lat")).floatValue();
        Integer zoom = dataFetchingEnvironment.getArgument("zoom");
        System.out.println("lng-->" + lng + "--lat--" + lat + "--zoom--:" + zoom);
        /*System.out.println("lng-->" + lng + "--lat--" + lat + "--zoom--:" + zoom);
        list.add(new MapHouseXY(116.43244f,39.929986f));
        list.add(new MapHouseXY(116.424355f,39.92982f));
        list.add(new MapHouseXY(116.423349f,39.935214f));
        list.add(new MapHouseXY(116.350444f,39.931645f));
        list.add(new MapHouseXY(116.351684f,39.91867f));
        list.add(new MapHouseXY(116.353983f,39.913855f));
        list.add(new MapHouseXY(116.357253f,39.923152f));
        list.add(new MapHouseXY(116.349168f,39.923152f));
        list.add(new MapHouseXY(116.36232f,39.938339f));
        list.add(new MapHouseXY(116.374249f,39.94625f));
        list.add(new MapHouseXY(116.380178f,39.953053f));*/
        return  this.mongoHouseService.queryHouseData(lng,lat,zoom);

    }
}
