package cn.cherryrental.dubbo.api.test;

import cn.cherryrental.dubbo.api.vo.PicUploadResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestLocalOSS {
    private static final String[] IMAGE_TYPE = new String[]{".bmp",".jpg",".jpeg",".gif",".png"};

    @Test
    public void testLocalOss() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        List<String> lines = FileUtils.readLines(new File("F:\\code\\data.json"),"utf-8");

        //新图片的地址

        for (String line : lines){
            JsonNode jsonNode = mapper.readTree(line);
            String image = jsonNode.get("image").asText();
            //原先图片位置
            File orig = new File("F:\\code\\images\\" + image + ".jpg");
            //生成新图片文件位置写入到磁盘
            File file = new File("F:\\ffmep\\pic\\" + image + ".jpg");
            InputStream inputStream = new FileInputStream(orig);
            OutputStream outputStream = new FileOutputStream(file,true);

            try {
                byte[] arr = new byte[1024];
                //循环读取,读到末尾会返回-1
                int n = 0;
                while((n=inputStream.read(arr)) !=-1) {
                    //将读取的内容写入到输出流当中
                    outputStream.write(arr, 0, n);

                }
            }catch (Exception e){

            }finally {
                outputStream.flush();
                inputStream.close();
                outputStream.close();
            }

            //生成新的文职





        }
    }
}
