package neo.ehsanodyssey.jackson.deserialization.jsondeserializeclass;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class TicketService {
    static Set<User> users = new HashSet<>();
    static {
        User user1 = new User(1L, "ehsan", "@123");
        User user2 = new User(2L, "mohammad", "@456");
        User user3 = new User(3L, "arash", "@789");
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    static Set<Ticket> tickets = new HashSet<>();

    public TicketService() {
    }

    static Long nextId() {
        return tickets.size() > 0 ? tickets.size()+1L : 1L;
    }

    public Set<Ticket> findAll() {
        return tickets;
    }

    public Ticket findById(long id) {
        return tickets.stream().filter(u -> u.getId().compareTo(id) == 0).findAny().orElse(null);
    }

    public Ticket save(Ticket entity) {
        try {
            entity.setId(nextId());
            User raiser = users.stream().filter(u -> u.getId().compareTo(entity.getRaiser().getId()) == 0).findAny().orElse(null);
            entity.setRaiser(raiser);
            User responder = users.stream().filter(u -> u.getId().compareTo(entity.getResponder().getId()) == 0).findAny().orElse(null);
            entity.setResponder(responder);
            List<Message> messageList = entity.getMessages();
            tickets.add(entity);
            messageList.forEach(message -> {
                message.setId(MessageService.nextId());
                message.setTicket(entity);
                message.setDateTime(LocalDateTime.now());
                User sender = users.stream().filter(u -> u.getId().compareTo(message.getSender().getId()) == 0).findAny().orElse(null);
                message.setSender(sender);
                MessageService.messages.add(message);
            });
            return entity;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Ticket update(Ticket entity) {
        Ticket ticket = tickets.stream().filter(u -> u.getId().compareTo(entity.getId()) == 0).findAny().orElse(null);
        if(ticket != null) {
            try {

                List<Message> messageList = entity.getMessages();

                ticket.setRaiser(entity.getRaiser());
                ticket.setResponder(entity.getResponder());
                ticket.setSubject(entity.getSubject());
                List<Message> oldMessages = ticket.getMessages();
                messageList.forEach(message -> {
                    message.setId(MessageService.nextId());
                    message.setTicket(entity);
                    MessageService.messages.add(message);
                    oldMessages.add(message);
                });
                ticket.setMessages(oldMessages);
                return ticket;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public void deleteById(long id) {
        Ticket ticket = tickets.stream().filter(u -> u.getId() == id).findAny().orElse(null);
        if(ticket != null) {
            tickets.remove(ticket);
        } else {
            throw new IllegalArgumentException("Resource not found.");
        }
    }
}
