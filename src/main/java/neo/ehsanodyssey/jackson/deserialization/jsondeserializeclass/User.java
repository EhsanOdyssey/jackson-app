package neo.ehsanodyssey.jackson.deserialization.jsondeserializeclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String password;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
