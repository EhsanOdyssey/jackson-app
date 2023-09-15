package neo.ehsanodyssey.jackson.generals.jsonview;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/view")
public class ViewController {
    List<User> users = new ArrayList<>();

    {
        User.Address address1 = new User.Address(1L, "Iran", "Tehran", "Resalat");
        User user1 = new User(1L, "Ehsan", address1);
        User.Address address2 = new User.Address(2L, "Iran", "Isfahan", "Motahari");
        User user2 = new User(2L, "Mohammad", address2);
        User.Address address3 = new User.Address(3L, "Iran", "Shiraz", "Falake Gol Sorkhoo");
        User user3 = new User(3L, "Arash", address3);
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    @GetMapping
    @JsonView(Views.Public.class)
    public ResponseEntity getUsers() {
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    @JsonView(Views.Friend.class)
    public ResponseEntity getUser(@PathVariable Long id) {
        return ResponseEntity.ok(users.stream().filter(u -> u.getId() == id).findAny().orElse(null));
    }
}
