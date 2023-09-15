package neo.ehsanodyssey.jackson.deserialization.jsoncreator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String name;

    @JsonCreator
    public User(@JsonProperty("userId") Long id, @JsonProperty("username") String name) {
        this.id = id;
        this.name = name;
    }
}
