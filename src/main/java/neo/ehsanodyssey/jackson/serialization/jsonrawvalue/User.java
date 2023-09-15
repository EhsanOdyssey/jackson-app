package neo.ehsanodyssey.jackson.serialization.jsonrawvalue;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    @JsonRawValue
    public String address;

    public User() {
    }

    public User(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
