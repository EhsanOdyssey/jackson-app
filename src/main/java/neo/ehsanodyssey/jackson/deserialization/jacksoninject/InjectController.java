package neo.ehsanodyssey.jackson.deserialization.jacksoninject;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/inject")
public class InjectController {

    List<User> users = new ArrayList<>();

    {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Ehsan");
        User user2 = new User();
        user2.setId(2L);
        user2.setName("Mohammad");
        User user3 = new User();
        user3.setId(3L);
        user3.setName("Arash");
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
    public ResponseEntity saveUser(@RequestBody String userJson) {
        try {
            InjectableValues injectableValues = new InjectableValues.Std()
                    .addValue(Long.class, nextId());
            User entity = new ObjectMapper().reader(injectableValues)
                    .forType(User.class).readValue(userJson);
            users.add(entity);
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
