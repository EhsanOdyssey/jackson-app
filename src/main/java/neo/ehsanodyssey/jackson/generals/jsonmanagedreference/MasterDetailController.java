package neo.ehsanodyssey.jackson.generals.jsonmanagedreference;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MasterDetailController {
    List<Master> masters = new ArrayList<>();
    List<Detail> details = new ArrayList<>();

    {
        Master master1 = new Master(1L, "Laptop");
        Detail detail1 = new Detail(5L, "CPU", master1);
        master1.setDetails(Arrays.asList(detail1));
        Master master2 = new Master(2L, "PC");
        Detail detail2 = new Detail(6L, "Hard Drive", master2);
        master2.setDetails(Arrays.asList(detail2));
        Master master3 = new Master(3L, "Mother Board");
        Detail detail3 = new Detail(7L, "Ram Slot", master3);
        master3.setDetails(Arrays.asList(detail3));
        masters.add(master1);
        masters.add(master2);
        masters.add(master3);
        details.add(detail1);
        details.add(detail2);
        details.add(detail3);
    }

    private long nextId() {
        return details.size() + 1L;
    }

    @GetMapping(path = "/product")
    public ResponseEntity getProducts() {
        return ResponseEntity.ok(masters);
    }

    @GetMapping(path = "/item")
    public ResponseEntity getItems() {
        return ResponseEntity.ok(details);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(masters.stream().filter(u -> u.getId() == id).findAny().orElse(null));
    }

    @GetMapping("/item/{id}")
    public ResponseEntity getItem(@PathVariable Long id) {
        return ResponseEntity.ok(details.stream().filter(u -> u.getId() == id).findAny().orElse(null));
    }

    @PostMapping("/item")
    public ResponseEntity saveItem(@RequestBody Detail detail) {
        try {
            detail.setId(nextId());
            details.add(detail);
            return ResponseEntity.ok(detail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
