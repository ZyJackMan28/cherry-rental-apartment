package cn.cherryrental.dubbo.api.service;

import cn.cherryrental.dubbo.api.vo.HouseData;
import cn.cherryrental.dubbo.api.vo.SearchResult;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.ReflectUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class SearchService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public static final Integer ROWS =10;

    public SearchResult search(String keyWord, Integer page) {
        PageRequest pageRequest = PageRequest.of(page-1,ROWS);

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.multiMatchQuery(keyWord,"title","title.pinyin").operator(Operator.AND))
                .withPageable(pageRequest)
                .withHighlightFields(new HighlightBuilder.Field("title"))
                .build();


        AggregatedPage<HouseData> housePage = this.elasticsearchTemplate.queryForPage(searchQuery, HouseData.class, new SearchResultMapper() {
            @SneakyThrows
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> clazz, Pageable pageable) {
                //除了高亮的字段其他字段也需要自己写
                List<T> list = new ArrayList();
                if (searchResponse.getHits().totalHits == 0){
                    return new AggregatedPageImpl<>(Collections.emptyList(),pageable,0L);
                }
                for (SearchHit searchHit: searchResponse.getHits()){
                    //通过反射写入到数据对象中
                    T obj = (T) ReflectUtils.newInstance(clazz);
                    Map<String, Object> sourceAsMap = searchHit.getSourceAsMap();
                    try {
                        //写入id
                        FieldUtils.writeField(obj, "id", searchHit.getId(), true);

                        //非高亮字段写入
                        for (Map.Entry<String, Object> entry : sourceAsMap.entrySet()) {
                            Field field = FieldUtils.getField(clazz, entry.getKey(), true);
                            if (null == field){
                                continue;
                            }
                            FieldUtils.writeField(obj,entry.getKey(),entry.getValue(),true);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    for (Map.Entry<String, HighlightField> stringHighlightFieldEntry : searchHit.getHighlightFields().entrySet()) {
                        Text[] fragments = stringHighlightFieldEntry.getValue().fragments();
                        StringBuilder sb = new StringBuilder();
                        for (Text fragment : fragments) {
                            sb.append(fragment.toString());
                        }
                        //写入高亮
                        FieldUtils.writeField(obj,stringHighlightFieldEntry.getKey(),sb.toString(),true);

                    }
                    list.add(obj);
                }


                return new AggregatedPageImpl<>(list,pageable,searchResponse.getHits().totalHits);
            }
        });

        return new SearchResult(housePage.getTotalPages(),housePage.getContent(),null);
    }
}
