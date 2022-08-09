package imersao_java.content;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public abstract class ContentParser {
    ObjectMapper objectMapper;

    public ContentParser() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public abstract List<? extends Content> parse(String rawContent)
            throws JsonProcessingException;

}
