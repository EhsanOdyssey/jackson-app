package neo.ehsanodyssey.jackson.serialization.jsonserializeclass;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Message {
    private Long id;
    private User sender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime dateTime;
    private String text;
    private Ticket ticket;

    public Message() {
    }

    public Message(Long id, User sender, LocalDateTime dateTime, String text) {
        this.id = id;
        this.sender = sender;
        this.dateTime = dateTime;
        this.text = text;
    }

    public Message(Long id, User sender, LocalDateTime dateTime, String text, Ticket ticket) {
        this.id = id;
        this.sender = sender;
        this.dateTime = dateTime;
        this.text = text;
        this.ticket = ticket;
    }
}
