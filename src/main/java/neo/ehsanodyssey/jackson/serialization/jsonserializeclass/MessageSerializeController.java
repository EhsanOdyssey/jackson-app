package neo.ehsanodyssey.jackson.serialization.jsonserializeclass;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message_serialize")
public class MessageSerializeController {

    @GetMapping
    public ResponseEntity getMessages() {
        return ResponseEntity.ok(TicketSerializeController.messages);
    }

    @GetMapping("/{id}")
    public ResponseEntity getMessage(@PathVariable Long id) {
        return ResponseEntity.ok(TicketSerializeController.messages.stream().filter(u -> u.getTicket().getId() == id).findAny().orElse(null));
    }
}
