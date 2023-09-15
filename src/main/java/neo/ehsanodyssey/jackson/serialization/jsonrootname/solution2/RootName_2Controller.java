package neo.ehsanodyssey.jackson.serialization.jsonrootname.solution2;

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
@RequestMapping("/root_name_2")
public class RootName_2Controller {
    List<User> users = new ArrayList<>();

    {
        User user1 = new User(1L, "Ehsan");
        User user2 = new User(2L, "Mohammad");
        User user3 = new User(3L, "Arash");
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    @GetMapping
    public ResponseEntity getUsers() {
        Map result = new HashMap();
        result.put(User.class.getAnnotation(CustomRootName.class).plural(), users);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        User user = users.stream().filter(u -> u.getId() == id).findAny().orElse(null);
        if(user == null) {
            return ResponseEntity.noContent().build();
        }
        Map result = new HashMap();
        result.put(User.class.getAnnotation(CustomRootName.class).singular(), user);
        return ResponseEntity.ok(result);
    }
}
