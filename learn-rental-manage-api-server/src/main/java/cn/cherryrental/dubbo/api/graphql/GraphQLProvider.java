package cn.cherryrental.dubbo.api.graphql;

import cn.cherryrental.dubbo.api.service.HouseResourceService;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * 将GraphQL 托交给Spring容器管理
 */
@Component
public class GraphQLProvider {

    private GraphQL graphQL;
    //@Autowired
    //private HouseResourceService houseResourceService;
    @Autowired
    private List<MyDataFetcher> myDataFetchers;
    /**
     * 希望在spring作初始化时对graphql进行初始化
     */
    @PostConstruct
    public void init() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:cherry.graphql");

        this.graphQL = GraphQL.newGraphQL(buildGraphQLSchema(file)).build();
    }

    private RuntimeWiring buildWiring() {

        return RuntimeWiring.newRuntimeWiring()
                .type("HaokeQuery",builder -> {
                    for (MyDataFetcher myDataFetcher : myDataFetchers) {
                        builder.dataFetcher(myDataFetcher.fieldName(),
                                env -> myDataFetcher.dataFetcher(env));
                    }
                    return  builder;
                })
                .build();
        /*RuntimeWiring.newRuntimeWiring()
                .type("HaokeQuery", builder ->
                        builder.dataFetcher("houseResources", env -> {
                            Long id = env.getArgument("id");
                            return this.houseResourceService.queryHouseResourcesById(id);
                        })
                )
                .build();*/
    }

    private GraphQLSchema buildGraphQLSchema(File file) {
        TypeDefinitionRegistry registry = new SchemaParser().parse(file);

        return new SchemaGenerator().makeExecutableSchema(registry,buildWiring());
    }
    /**
     * 将对象载入到spring
     * @return
     */
    @Bean
    public GraphQL graphQL(){
        return this.graphQL;
    }
}
