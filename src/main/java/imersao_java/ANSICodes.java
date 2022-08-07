package imersao_java;

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
