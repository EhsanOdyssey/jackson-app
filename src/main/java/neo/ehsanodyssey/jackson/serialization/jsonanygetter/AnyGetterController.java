package neo.ehsanodyssey.jackson.serialization.jsonanygetter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/any_getter")
public class AnyGetterController {
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

    @GetMapping
    public ResponseEntity getUsers() {
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        return ResponseEntity.ok(users.stream().filter(u -> u.getId() == id).findAny().orElse(null));
    }
}
