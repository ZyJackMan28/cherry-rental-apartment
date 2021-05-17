package cn.cherryrental.dubbo.api.controller;


import cn.cherryrental.dubbo.api.service.SearchService;
import cn.cherryrental.dubbo.api.vo.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("search")
@RestController
@CrossOrigin
public class SearchController {
 
    @Autowired
    private SearchService searchService;
    @Autowired
    private RedisTemplate redisTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);
 
    @GetMapping
    public SearchResult search(@RequestParam("keyWord") String keyWord, @RequestParam(value = "page", defaultValue = "1") Integer page) {
       if(page > 100){ //防止爬虫抓取过多的数据
          page = 1;
   }
        SearchResult search = this.searchService.search(keyWord, page);
        String redisKey = "cherryRental_hot_word";
        if (search.getTotalPage() <=1){
            //按照得分进行排序，获取前5条数据
            Set<String> set = this.redisTemplate.opsForZSet().reverseRange(redisKey,0,4);
            search.setHotWord(set);

        }
        ////热词处理
       Integer count =  ((Math.max(search.getTotalPage(), 1) - 1) * SearchService.ROWS) + search.getList().size();
       this.redisTemplate.opsForZSet().add(redisKey,keyWord,count);

        LOGGER.info("[search]搜索关键字: " + keyWord + ",结果数量为:" + count);

        return search;


 
   }
 
}