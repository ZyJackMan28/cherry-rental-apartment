package cn.cherryrental.dubbo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
public class DubboApiApplication {

    public static void main(String[] args) {
        //System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(DubboApiApplication.class, args);
 }

}
