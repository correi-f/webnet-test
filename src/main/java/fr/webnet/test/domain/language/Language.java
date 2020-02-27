package fr.webnet.test.domain.language;

public class Language {

    private final String value;
    private final String description;

    public Language(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String value() {
        return value;
    }

    public String description() {
        return description;
    }

    @Override
    public String toString() {
        return "Language{" +
                "value='" + value + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
