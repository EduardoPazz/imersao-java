package imersao_java.content;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;

public class ContentParserIMDB extends ContentParser {
    @Override
    public List<? extends Content> parse(String rawContent)
            throws JsonProcessingException {

        return objectMapper.readValue(rawContent, IMDBResponse.class).items();
    }

    public record IMDBResponse(ArrayList<IMDB> items) {
    }

    public record IMDB(String title, String image) implements Content {
        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getImage() {
            return image;
        }
    }
}

