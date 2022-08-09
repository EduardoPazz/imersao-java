package imersao_java;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FormatPretty {
	public static String format(String content, ANSICodes... codes) {
		return Stream.concat(Stream.of(codes).map(ANSICodes::getCode),
						Stream.of(content, ANSICodes.RESET.getCode()))
				.collect(Collectors.joining());
	}

	public enum ANSICodes {
		BACKGROUND_PINK("\u001b[45m"),
		BOLD("\u001b[1m"),
		RESET("\u001b[0m");

		private final String code;

		ANSICodes(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}
	}
}
