package neo.ehsanodyssey.jackson.deserialization.jsondeserializeclass;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {
    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getMessages() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getMessage(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity saveMessage(@RequestBody String messageJson) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Message message = mapper.readValue(messageJson, Message.class);
            Message newMessage = service.save(message);
            if(newMessage != null) {
                return ResponseEntity.ok(newMessage);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMessage(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok("Message has been deleted.");
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
