package neo.ehsanodyssey.jackson.generals.jsonfilter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filter")
public class FilterController {
    List<User> users = new ArrayList<>();

    {
        User user1 = new User(1L, "Ehsan","male");
        User user2 = new User(2L, "Mohammad", "male");
        User user3 = new User(3L, "Parisa", "female");
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    private long nextId() {
        return users.size() + 1L;
    }

    @GetMapping
    public ResponseEntity getUsers() {
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        return ResponseEntity.ok(users.stream().filter(u -> u.getId() == id).findAny().orElse(null));
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody User user) {
        try {
            user.setId(nextId());
            users.add(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
