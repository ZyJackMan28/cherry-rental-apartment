package cn.cherryrental.dubbo.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@PropertySource("classpath:mockdata.properties")
@ConfigurationProperties(prefix = "mock")
@Data
public class MockConfig {
 
private String indexMenu;
private String indexInfo;
private String indexFaq;
private String indexHouse;
private String infosList1;
private String infosList2;
private String infosList3;
private String my;
 
}