package imersao_java;

import java.util.List;

public record Movies(List<Movie> items, String ErrorMessage) {
}

record Movie(String title, String imDbRating, String image) {
}



