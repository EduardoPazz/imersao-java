package imersao_java;

import imersao_java.content.Content;
import imersao_java.content.ContentFetcher;
import imersao_java.content.ContentParser;
import imersao_java.content.ContentParserIMDB;
import imersao_java.content.ContentParserNASA;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class App {
	public static void main(String[] args) throws Exception {
		Dotenv dotenv = Dotenv.load();
		String endpoint;
		ContentParser contentParser;
		switch (args[0]) {
			case "nasa" -> {
				endpoint = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";
				contentParser = new ContentParserNASA();
			}
			case "imdb" -> {
				endpoint = "https://imdb-api.com/en/API/Top250Movies/" + dotenv.get(
						"IMDB_KEY");
				contentParser = new ContentParserIMDB();
			}
			default -> throw new RuntimeException("Invalid web service");
		}

		String rawContent = new ContentFetcher().fetch(endpoint);

		List<Content> contentList =
				(List<Content>) contentParser.parse(rawContent);

		contentList.stream().limit(3).forEach(content -> {
			try {
				StickerGenerator.gen(new URL(content.getImage()).openStream(),
						"TOPZERA", content.getTitle());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}
