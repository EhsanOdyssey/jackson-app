package neo.ehsanodyssey.jackson.serialization.jsonserializefield;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/serialize_field")
public class SerializeFieldController {
    List<User> users = new ArrayList<>();

    {
        LocalDateTime date = LocalDateTime.now();
        User user1 = new User(1L, "Ehsan", date.minusYears(37L));
        User user2 = new User(2L, "Mohammad", date.minusYears(33L));
        User user3 = new User(3L, "Arash", date.minusYears(29L));
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    @GetMapping
    public ResponseEntity getUsers() {
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        return ResponseEntity.ok(users.stream().filter(u -> u.getId() == id).findAny().orElse(null));
    }
}
