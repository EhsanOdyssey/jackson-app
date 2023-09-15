package neo.ehsanodyssey.jackson.serialization.jsongetter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/getter")
public class GetterController {
    List<User> users = new ArrayList<>();

    {
        User user1 = new User(1L, "Ehsan", "@123");
        User user2 = new User(2L, "Mohammad", "@456");
        User user3 = new User(3L, "Arash", "@789");
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
