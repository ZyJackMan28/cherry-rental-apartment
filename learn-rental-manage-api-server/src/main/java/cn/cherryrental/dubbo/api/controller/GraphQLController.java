package cn.cherryrental.dubbo.api.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.bcel.internal.generic.NEW;
import graphql.ExecutionInput;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("graphql")
@Controller
@CrossOrigin
public class GraphQLController {

    @Autowired
    private GraphQL graphQL;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @GetMapping
    @ResponseBody
    public Map<String,Object> query(@RequestParam("query") String query, @RequestParam(value = "variables",required = false)
                                    String varJson, @RequestParam(value = "operationName", required = false) String operationName) {
        try {
            Map varibles = MAPPER.readValue(varJson,MAPPER.getTypeFactory().constructMapType(HashMap.class,String.class,Object.class));
            ExecutionInput executionInput = ExecutionInput.newExecutionInput()
                    .query(query)
                    .operationName(operationName)
                    .variables(varibles)
                    .build();
            return this.graphQL.execute(executionInput).toSpecification();
            //return  this.graphQL.execute(query).toSpecification();
        }catch (IOException e){
            Map<String,Object> error = new HashMap<>();
            error.put("status",500);
            error.put("message","失败了");
            return error;
        }

    }

    @PostMapping
    @ResponseBody
    public Map<String,Object> postQuery(@RequestBody Map<String,Object> map) throws IOException {
        /*JsonNode jsonNode = MAPPER.readTree(json);
        if (jsonNode.has("query")) {
            String query = jsonNode.get("query").asText();
            return this.graphQL.execute(query).toSpecification();*/
        try {
            String query = (String) map.get("query");
            if(null == query){
                query = "";
            }
            String operationName = (String) map.get("operationName");
            Map varibles = (Map) map.get("variables");
            if (varibles == null){
                varibles = Collections.EMPTY_MAP;
            }
            return this.executeGraphqlQuery(query,operationName,varibles);
        }
        catch (Exception e){
            Map<String,Object> error = new HashMap<>();
            error.put("status",500);
            error.put("message","失败了");
            return error;
        }

    }

    private Map<String, Object> executeGraphqlQuery(String query, String operationName, Map varibles) {
        ExecutionInput executionInput = ExecutionInput.newExecutionInput()
                .query(query)
                .operationName(operationName)
                .variables(varibles)
                .build();
        return this.graphQL.execute(executionInput).toSpecification();
    }
}
