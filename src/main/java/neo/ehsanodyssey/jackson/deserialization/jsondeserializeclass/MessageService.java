package neo.ehsanodyssey.jackson.deserialization.jsondeserializeclass;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class MessageService {
    static Set<Message> messages = new HashSet<>();

    public MessageService() {
    }

    static Long nextId() {
        return messages.size() > 0 ? messages.size()+1L : 1L;
    }

    public Set<Message> findAll() {
        return messages;
    }

    public Message findById(long id) {
        return messages.stream().filter(u -> u.getTicket().getId() == id).findAny().orElse(null);
    }

    public Message save(Message entity) {
        try {
            if(entity.getTicket() != null && entity.getTicket().getId() != null) {
                User sender = TicketService.users.stream().filter(u -> u.getId().compareTo(entity.getSender().getId()) == 0).findAny().orElse(null);
                Ticket ticket = TicketService.tickets.stream().filter(u -> u.getId().compareTo(entity.getTicket().getId()) == 0).findAny().orElse(null);
                if(ticket != null) {
                    entity.setId(nextId());
                    entity.setDateTime(LocalDateTime.now());
                    entity.setSender(sender);
                    entity.setTicket(ticket);
                }
                return entity;
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteById(long id) {
        Message message = messages.stream().filter(u -> u.getId() == id).findAny().orElse(null);
        if(message != null) {
            messages.remove(message);
        } else {
            throw new IllegalArgumentException("Resource not found.");
        }
    }
}
