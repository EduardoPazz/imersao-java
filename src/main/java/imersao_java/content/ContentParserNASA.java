package imersao_java.content;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContentParserNASA extends ContentParser {
    @Override
    public List<? extends Content> parse(String rawContent)
            throws JsonProcessingException {

        return List.of(objectMapper.readValue(rawContent, NASA.class));
    }

    public record NASA(String title, String url) implements Content {
        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getImage() {
            return url;
        }
    }
}

