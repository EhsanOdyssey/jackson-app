package neo.ehsanodyssey.jackson.serialization.jsonrawvalue;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/raw_value")
public class RawValueController {
    List<User> users = new ArrayList<>();

    {
        String address = "{\"country\":\"Iran\",\"city\":\"Tehran\",\"street\":\"Resalat\"}";
        User user1 = new User(1L, "Ehsan", address);
        address = "{\"country\":\"Iran\",\"city\":\"Isfahan\",\"street\":\"Motahari\"}";
        User user2 = new User(2L, "Mohammad", address);
        address = "{\"country\":\"Iran\",\"city\":\"Shiraz\",\"street\":\"Falake Gol Sorkhoo\"}";
        User user3 = new User(3L, "Arash", address);
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
