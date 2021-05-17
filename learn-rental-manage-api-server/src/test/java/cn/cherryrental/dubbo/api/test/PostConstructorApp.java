package cn.cherryrental.dubbo.api.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

@Component
@RunWith(SpringRunner.class)
public class PostConstructorApp {

    @Test
    //@PostConstruct
    public void testPostConstructor()
    {
        System.out.println("----------bbbb");
    }
}
