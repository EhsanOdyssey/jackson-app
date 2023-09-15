package neo.ehsanodyssey.jackson.serialization.jsonanygetter;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private Map<String, String> properties;

    public User() {
    }

    public User(Long id, String name, Map<String, String> properties) {
        this.id = id;
        this.name = name;
        this.properties = properties;
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }
}
