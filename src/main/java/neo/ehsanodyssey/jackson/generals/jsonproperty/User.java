package neo.ehsanodyssey.jackson.generals.jsonproperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    @JsonProperty("user_id")
    private Long id;
    @JsonProperty("user_name")
    private String name;

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
