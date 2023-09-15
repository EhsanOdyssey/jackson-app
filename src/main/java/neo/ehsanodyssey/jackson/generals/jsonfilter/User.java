package neo.ehsanodyssey.jackson.generals.jsonfilter;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonFilter("userFilter")
public class User {
    private Long id;
    private String name;
    private String gender;

    public User() {
    }

    public User(Long id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
}
