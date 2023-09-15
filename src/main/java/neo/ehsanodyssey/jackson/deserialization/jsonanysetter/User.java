package neo.ehsanodyssey.jackson.deserialization.jsonanysetter;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private Map<String, String> properties = new HashMap<>();

    public User() {
    }

    public User(Long id, String name, Map<String, String> properties) {
        this.id = id;
        this.name = name;
        this.properties = properties;
    }

    @JsonAnySetter
    public void setProperties(String key, String value) {
        this.properties.put(key, value);
    }
}
