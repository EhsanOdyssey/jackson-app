package neo.ehsanodyssey.jackson.serialization.jsonrootname.solution2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@CustomRootName(plural = "eUsers", singular = "eUser")
public class User {
    private Long id;
    private String name;

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
