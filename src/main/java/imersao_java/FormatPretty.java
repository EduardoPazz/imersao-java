package imersao_java;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FormatPretty {
    public static String format(String content, ANSICodes... codes) {
        return Stream.concat(Stream.of(codes).map(ANSICodes::getCode),
                             Stream.of(content, ANSICodes.RESET.getCode()))
                     .collect(Collectors.joining());
    }

}
