package cn.cherryrental.dubbo.api.controller;

import cn.cherryrental.dubbo.api.service.HouseResourceService;
import cn.cherryrental.dubbo.api.vo.TableResult;
import cn.cherryrental.dubbo.server.pojo.HouseResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("house/resources")
@CrossOrigin
public class HouseResourceController {

    @Autowired
    private HouseResourceService houseResourceService;

    @PutMapping
    @ResponseBody
    public ResponseEntity<Void> update(@RequestBody HouseResources houseResources) {
        try {
            boolean bool = this.houseResourceService.update(houseResources);
            if (bool) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     *  新增房源
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Void> save(@RequestBody HouseResources houseResources){
        try {
            boolean bool = this.houseResourceService.save(houseResources);
            if(bool){
                return ResponseEntity.status(HttpStatus.CREATED).build();
          }
      } catch (Exception e) {
        e.printStackTrace();
      }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     *  test
     */
    //@GetMapping
    //@ResponseBody
    //public ResponseEntity<String> get(){
      //  return  ResponseEntity.ok("ok");
    //}

        /**
         * 查询房源列表
         *
         * @param houseResources
         * @param currentPage
         * @param pageSize
         * @return
         */
      @GetMapping
      @ResponseBody
      public ResponseEntity<TableResult> list(HouseResources houseResources, @RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
            return ResponseEntity.ok(this.houseResourceService.queryList(houseResources, currentPage, pageSize));
     }

    /**
     *  更新房源数据
      * @param houseResources
     * @return
     */


}
