package cn.cherryrental.dubbo.api.test;

import com.aliyun.oss.OSSClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class TestOSS {

 @Test
 public void testOss() throws Exception {
  ObjectMapper mapper = new ObjectMapper();
  String endpoint = "http://oss-cn-qingdao.aliyuncs.com";
  String accessKeyId = "LTAIfC7fUsPj7Rfq";
  String accessKeySecret = "c2Vo3q1AmivtY8lxFnfsCfkO2c2HCk";
  String bucketName = "itcast-haoke";
  String urlPrefix = "http://itcast-haoke.oss-cn-qingdao.aliyuncs.com/";

  OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

  List<String> lines = FileUtils.readLines(new File("F:\\code\\data.json"), "UTF-8");
  for (String line : lines) {
   JsonNode jsonNode = mapper.readTree(line);
   String image = jsonNode.get("image").asText();

   ossClient.putObject(bucketName, "lj/" + image, new File("F:\\code\\images\\" + image));
   System.out.println(image);
  }

 }
}