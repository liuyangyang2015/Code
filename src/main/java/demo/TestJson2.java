package demo;

import com.banma.aloha.model.pojo.ObjectiveScoreParam;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.io.IOException;

/**
 * 描述：
 *
 * @author liuyangyang
 * @create 2018-08-27 16:47
 **/
public class TestJson2 {
    private TestJson2() { };

    public static void main(String[] args) throws Exception {
//        String str = getJsonSchema(ObjectiveListParam.class);
//        System.out.println(str);

        PodamFactory factory = new PodamFactoryImpl();
        ObjectiveScoreParam myPojo = factory.manufacturePojo(ObjectiveScoreParam.class);
        String str = new ObjectMapper().writeValueAsString(myPojo);
        System.out.println(str);
    }

    public static String getJsonSchema(Class clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
        JsonSchema schema = mapper.generateJsonSchema(clazz);
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema);
    }
}
