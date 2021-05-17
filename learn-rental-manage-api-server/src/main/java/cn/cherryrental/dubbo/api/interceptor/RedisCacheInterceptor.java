package cn.cherryrental.dubbo.api.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
@Component
public class RedisCacheInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    private static ObjectMapper mapper = new ObjectMapper();
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

         // 判断请求方式，get还是post还是其他。。。
         /**
          * 错误分析：由于在拦截器中读取了输入流的数据，在request中的输入流只能读取一次，请求进去Controller时，输
          * 入流中已经没有数据了，导致获取不到数据。
          */
         if(StringUtils.equalsIgnoreCase(request.getMethod(), "OPTIONS")){
            return true;
          }
         if (!StringUtils.equalsIgnoreCase(request.getMethod(), "GET")) {
             // 非get请求，如果不是graphql请求，放行
             if (!StringUtils.equalsIgnoreCase(request.getRequestURI(), "/graphql")) {
                 return true;
             }
         }
        //我们对get请求进行拦截
        /*if (!StringUtils.equalsIgnoreCase(request.getMethod(),"get")){
            //非get请求，如果不是/graphql 放行
            if (!StringUtils.equalsIgnoreCase(request.getRequestURI(),"/graphql")){
                return true;
            }
        }*/
        //缓存数据
        String data =  this.redisTemplate.opsForValue().get(createRedisKey(request));
        if (StringUtils.isEmpty(data)){
            //缓存未命中放行去进行查询数据库
            return true;
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

         // 支持跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Token");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.getWriter().write(data);
        //有数据就命中缓存
        return false;
    }

    public static String createRedisKey(HttpServletRequest request) throws Exception {
        String uri = request.getRequestURI();

        Map<String, String[]> parameterMap = request.getParameterMap();
        //是否有请求参数
        if (parameterMap.isEmpty()){
            //缓存命中， 直接查询Redis, 约定 redisKey 组成 md5(请求uri + 请求参数)
            //错误分析：由于在拦截器中读取了输入流的数据，在request中的输入流只能读取一次，请求进去Controller时，输
            // 入流中已经没有数据了，导致获取不到数据。需要包装request
            uri += IOUtils.toString(request.getInputStream(),"UTF-8");
        }else {
            //有数据直接反序列化
            uri+=mapper.writeValueAsString(request.getParameterMap());
        }
        String redisKey = "WEB_DATA_" + DigestUtils.md5Hex(uri);
        return redisKey;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
