package fr.webnet.test.exposition.language.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"language", "description"})
public class LanguageDTO implements Serializable {

    @JsonProperty("language")
    public String value;
    public String description;

    public LanguageDTO() {
    }

    public LanguageDTO(String value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanguageDTO that = (LanguageDTO) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, description);
    }
}
