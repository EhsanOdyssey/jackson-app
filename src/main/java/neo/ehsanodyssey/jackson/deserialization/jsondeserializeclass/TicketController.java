package neo.ehsanodyssey.jackson.deserialization.jsondeserializeclass;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getTickets() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getTicket(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity saveTicket(@RequestBody Ticket ticket) {
        try {
            return ResponseEntity.ok(service.save(ticket));
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity updateTicket(@RequestBody Ticket ticket) {
        try {
            return ResponseEntity.ok(service.update(ticket));
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTicket(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok("Ticket has been deleted.");
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
