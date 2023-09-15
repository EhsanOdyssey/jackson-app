package neo.ehsanodyssey.jackson.serialization.jsonserializeclass;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ticket_serialize")
public class TicketSerializeController {
    static List<User> users = new ArrayList<>();
    static List<Ticket> tickets = new ArrayList<>();
    static List<Message> messages = new ArrayList<>();

    static {
        User user1 = new User(1L, "ehsan", "@123");
        User user2 = new User(2L, "mohammad", "@456");
        User user3 = new User(3L, "arash", "@789");
        users.add(user1);
        users.add(user2);
        users.add(user3);

        LocalDateTime now = LocalDateTime.now();

        Ticket ticket1 = new Ticket(1L, user1, user2, "Ticket no.1");
        Message message1 = new Message(1L, user1, now, "Hi I have an issue.", ticket1);
        Message message11 = new Message(11L, user2, now.plusMinutes(10), "Hi What is the issue.", ticket1);
        Message message12 = new Message(12L, user1, now.plusMinutes(15), "FYI.", ticket1);
        ticket1.setMessages(Arrays.asList(message1, message11, message12));

        Ticket ticket2 = new Ticket(2L, user2, user3, "Ticket no.2");
        Message message2 = new Message(2L, user2, now.plusMinutes(25), "Hi, I cannot find the issue.", ticket2);
        Message message21 = new Message(21L, user3, now.plusMinutes(33), "Hi me too.", ticket2);
        Message message22 = new Message(22L, user2, now.plusMinutes(38), "Please check with technical team.", ticket2);
        Message message23 = new Message(23L, user3, now.plusMinutes(45), "Let me check.", ticket2);
        Message message24 = new Message(24L, user2, now.plusMinutes(55), "Thank you.", ticket2);
        ticket2.setMessages(Arrays.asList(message2, message21, message22, message23, message24));

        tickets.add(ticket1);
        tickets.add(ticket2);
        messages.add(message1);
        messages.add(message11);
        messages.add(message12);
        messages.add(message2);
        messages.add(message21);
        messages.add(message22);
        messages.add(message23);
        messages.add(message24);
    }

    @GetMapping
    public ResponseEntity getTickets() {
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity getTicket(@PathVariable Long id) {
        return ResponseEntity.ok(tickets.stream().filter(u -> u.getId() == id).findAny().orElse(null));
    }
}
