package neo.ehsanodyssey.jackson.deserialization.jacksoninject;

import com.fasterxml.jackson.annotation.JacksonInject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    @JacksonInject
    private Long id;
    private String name;

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
