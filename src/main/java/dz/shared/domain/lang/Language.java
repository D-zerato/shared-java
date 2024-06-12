package dz.shared.domain.lang;

import lombok.Getter;

public enum Language {
    //
    Korean("ko"),
    English("en"),
    Chinese("zh");

    @Getter
    private String polyglotName;

    private Language(String polyglotName) {
        //
        this.polyglotName = polyglotName;
    }

    public static Language from(String value) {
        //
        for (Language each : Language.values()) {
            if (each.name().equalsIgnoreCase(value) || each.getPolyglotName().equalsIgnoreCase(value)) {
                return each;
            }
        }
        throw new UnsupportedOperationException ("Unsupported value for Language : " + value);
    }
}
