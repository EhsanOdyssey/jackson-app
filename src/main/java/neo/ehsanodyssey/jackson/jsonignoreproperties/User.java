package neo.ehsanodyssey.jackson.jsonignoreproperties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties({"password","address"})
public class User {
    private Long id;
    private String name;
    private String password;
    private String address;

    public User() {
    }

    public User(Long id, String name, String password, String address) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
    }
}
