package imersao_java;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class App {
    public static void main(String[] args) throws Exception {
        Dotenv dotenv = Dotenv.load();
        String endpoint = "https://imdb-api.com/en/API/Top250Movies/" + dotenv.get("IMDB_KEY");
        URI uri = URI.create(endpoint);
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response =
                httpClient.send(request, BodyHandlers.ofString());
        String body = response.body();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Movies movies = objectMapper.readValue(body, Movies.class);

        movies.items().forEach(movie -> {
            System.out.println("Title: " + FormatPretty.format(movie.title(),
                    ANSICodes.BOLD));
            System.out.println("Poster: " + FormatPretty.format(movie.image(),
                    ANSICodes.BOLD));

            System.out.println(
                    FormatPretty.format("Rating: " + movie.imDbRating(),
                            ANSICodes.BACKGROUND_PINK));
            System.out.println("\u2B50".repeat(
                    (int) Math.round(Double.parseDouble(movie.imDbRating()))) + "\n");
        });
    }
}
