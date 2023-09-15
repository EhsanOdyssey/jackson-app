package neo.ehsanodyssey.jackson.jsonignoretype;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ignore_type")
public class IgnoreTypeController {
    List<User> users = new ArrayList<>();

    {
        User.Address address1 = new User.Address(1L, "Iran", "Tehran", "Resalat");
        User user1 = new User(1L, "Ehsan", "@123", address1);
        User.Address address2 = new User.Address(2L, "Iran", "Isfahan", "Motahari");
        User user2 = new User(2L, "Mohammad", "@456", address2);
        User.Address address3 = new User.Address(3L, "Iran", "Shiraz", "Falake Gol Sorkhoo");
        User user3 = new User(3L, "Arash", "@789", address3);
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
