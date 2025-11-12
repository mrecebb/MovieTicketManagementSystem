package tickets;

import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.TicketRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonTicketRepository implements TicketRepository {
    private final File file;
    private final ObjectMapper mapper;
    public JsonTicketRepository(File file, ObjectMapper mapper) {
        this.file = file;
        this.mapper = mapper;
    }

    @Override
    public List<Ticket> findAll() throws IOException {
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        } else {
            return new ArrayList<>(Arrays.asList(mapper.readValue(file, Ticket[].class)));
        }
    }

    @Override
    public void saveAll(List<Ticket> tickets) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, tickets);
    }
}
