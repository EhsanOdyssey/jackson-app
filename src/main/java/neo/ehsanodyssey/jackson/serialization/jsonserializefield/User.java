package neo.ehsanodyssey.jackson.serialization.jsonserializefield;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    @JsonSerialize(using = DateSerializer.class)
    public LocalDateTime dateOfBirth;

    public User() {
    }

    public User(Long id, String name, LocalDateTime dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
}
