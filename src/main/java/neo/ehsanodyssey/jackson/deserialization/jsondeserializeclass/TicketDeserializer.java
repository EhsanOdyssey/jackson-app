package neo.ehsanodyssey.jackson.deserialization.jsondeserializeclass;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TicketDeserializer extends StdDeserializer<Ticket> {

    public TicketDeserializer() {
        this(null);
    }

    public TicketDeserializer(final Class<?> vc) {
        super(vc);
    }

    @Override
    public Ticket deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Ticket ticket = new Ticket();
        final ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        final JsonNode node = mapper.readTree(jsonParser);
        try {
            if (node.has("id")) {
                ticket.setId(node.get("id").asLong());
            }
            if (node.has("raiser")) {
                ticket.setRaiser(new User(node.get("raiser").asLong()));
            }
            if (node.has("responder")) {
                ticket.setResponder(new User(node.get("responder").asLong()));
            }
            if (node.has("subject")) {
                ticket.setSubject(node.get("subject").asText());
            }
            if (node.has("message")) {
                JsonNode messageNode = node.get("message");
                Iterator<JsonNode> messageIter = messageNode.iterator();
                List<Message> messageList = new ArrayList<>();
                while (messageIter.hasNext()) {
                    Message message = new Message();
                    message.setText(messageIter.next().textValue());
                    message.setSender(new User(node.get("raiser").asLong()));
                    messageList.add(message);
                }
                ticket.setMessages(messageList);
            }
            return ticket;
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Not supported class type for Ticket implementation");
    }
}
