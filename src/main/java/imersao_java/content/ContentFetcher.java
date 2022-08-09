package imersao_java.content;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ContentFetcher {
    private final HttpClient httpClient = HttpClient.newHttpClient();

    public String fetch(String endpoint)
            throws IOException, InterruptedException {
        URI uri = URI.create(endpoint);
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response =
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}
