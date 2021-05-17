package cn.cherryrental.dubbo.api.controller;

import cn.cherryrental.dubbo.api.config.MockConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("mock")
@RestController
@CrossOrigin
public class MockController {
    @Autowired
    private MockConfig mockConfig;

    @GetMapping("index/menu")
    public String indexMenu(){
        return this.mockConfig.getIndexMenu();
    }

    @GetMapping("index/info")
    public String indexInfo(){
        return this.mockConfig.getIndexInfo();
    }

    @GetMapping("index/faq")
    public String indexFaq(){
        return this.mockConfig.getIndexFaq();
    }

    @GetMapping("index/house")
    public String indexHouse(){
        return this.mockConfig.getIndexHouse();
    }

     /**
          * 查询资讯
          *
          * @param type
          * @return
          */
    @GetMapping("infos/list")
    public String infosList(@RequestParam("type")Integer type) {
    switch (type){
            case 1:
                return this.mockConfig.getInfosList1();
            case 2:
                return this.mockConfig.getInfosList2();
            case 3:
            return this.mockConfig.getInfosList3();
          }
        return this.mockConfig.getInfosList1();
   }

    /**
      * 我的中心
      * @return
      */
    @GetMapping("my/info")
    public String myInfo() {
    return this.mockConfig.getMy();
    }
}
