package neo.ehsanodyssey.jackson.deserialization.jsondeserializefield;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    @JsonDeserialize(using = DateDeserializer.class)
    public LocalDateTime dateOfBirth;

    public User() {
    }

    public User(Long id, String name, LocalDateTime dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
}
