package neo.ehsanodyssey.jackson.deserialization.jsonanysetter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/anysetter")
public class AnySetterController {
    List<User> users = new ArrayList<>();

    {
        Map<String, String> properties = new HashMap<>();
        properties.put("emailId","ehsan@gmail.com");
        properties.put("gender","male");
        properties.put("password","@123");
        User user1 = new User(1L, "Ehsan", properties);
        properties.clear();
        properties.put("emailId","mohammad@gmail.com");
        properties.put("gender","male");
        properties.put("password","@456");
        User user2 = new User(2L, "Mohammad", properties);
        properties.clear();
        properties.put("emailId","arash@gmail.com");
        properties.put("gender","male");
        properties.put("password","@789");
        User user3 = new User(3L, "Arash", properties);
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

//    @PostMapping
//    public ResponseEntity saveUser(@RequestBody String userJson) {
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            User newUser = mapper.readValue(userJson, User.class);
//            users.add(newUser);
//            return ResponseEntity.ok(newUser);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ResponseEntity.badRequest().build();
//    }

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
