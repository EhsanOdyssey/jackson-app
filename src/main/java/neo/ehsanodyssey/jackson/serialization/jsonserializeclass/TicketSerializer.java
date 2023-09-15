package neo.ehsanodyssey.jackson.serialization.jsonserializeclass;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class TicketSerializer extends StdSerializer<Ticket> {

    public TicketSerializer() {
        this(null);
    }

    public TicketSerializer(final Class<Ticket> t) {
        super(t);
    }

    @Override
    public void serialize(Ticket ticket, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonGenerationException {
//        serializeWithShortMessage(ticket, gen, provider);
        serializeWithFullMessage(ticket, gen, provider);
    }

    public void serializeWithShortMessage(Ticket ticket, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonGenerationException {
        gen.writeStartObject();
        gen.writeNumberField("id", ticket.getId());
        gen.writeNumberField("raiser", ticket.getRaiser().getId());
        if (ticket.getResponder() != null) {
            gen.writeNumberField("responder", ticket.getResponder().getId());
        }
        gen.writeStringField("subject", ticket.getSubject());
        gen.writeArrayFieldStart("messages");
        List<String> messages = ticket.getMessages().stream().map(Message::getText).collect(Collectors.toList());
        for (String message : messages) {
            gen.writeString(message);
        }
        gen.writeEndArray();
        gen.writeEndObject();
    }

    public void serializeWithFullMessage(Ticket ticket, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonGenerationException {
        gen.writeStartObject();
        gen.writeNumberField("id", ticket.getId());
        gen.writeNumberField("raiser", ticket.getRaiser().getId());
        if (ticket.getResponder() != null) {
            gen.writeNumberField("responder", ticket.getResponder().getId());
        }
        gen.writeStringField("subject", ticket.getSubject());
        gen.writeArrayFieldStart("messages");
        for (Message message : ticket.getMessages()) {
            gen.writeStartObject();
            gen.writeNumberField("sender", message.getSender().getId());
            gen.writeStringField("date", message.getDateTime().toString());
            gen.writeStringField("text", message.getText());
            gen.writeEndObject();
        }
        gen.writeEndArray();
        gen.writeEndObject();
    }
}
