package neo.ehsanodyssey.jackson.serialization.jsonserializeclass;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonSerialize(using = TicketSerializer.class)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Ticket {
    @JacksonInject
    private Long id;
    private User raiser;
    private User responder;
    private String subject;
    private List<Message> messages;

    public Ticket() {
    }

    public Ticket(Long id, User raiser, User responder, String subject) {
        this.id = id;
        this.raiser = raiser;
        this.responder = responder;
        this.subject = subject;
    }

    public Ticket(Long id, User raiser, User responder, String subject, List<Message> messages) {
        this.id = id;
        this.raiser = raiser;
        this.responder = responder;
        this.subject = subject;
        this.messages = messages;
    }
}
