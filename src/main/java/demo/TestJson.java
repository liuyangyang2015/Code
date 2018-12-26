package demo;

import com.banma.aloha.model.pojo.ObjectiveListParam;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.schema.JsonSchema;
import org.mockito.Mockito;

import java.io.IOException;

/**
 * 描述：
 *
 * @author liuyangyang
 * @create 2018-08-27 16:41
 **/
public class TestJson {
    private static String getJsonSchema(Class clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //There are other configuration options you can set.  This is the one I needed.
        mapper.configure(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING, true);

        JsonSchema schema = mapper.generateJsonSchema(clazz);

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema);
    }

    public static void main(String[] args) throws IOException {
//        String str = getJsonSchema(ObjectiveListParam.class);
//        System.out.println(str);

        ObjectiveListParam objectiveListParam= Mockito.mock(ObjectiveListParam.class);
        String str = new ObjectMapper().writeValueAsString(objectiveListParam);
        System.out.println(str);
    }

}
