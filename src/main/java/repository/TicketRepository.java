package repository;

import domain.Ticket;

import java.io.IOException;
import java.util.List;

public interface TicketRepository {
    List<Ticket> findAll() throws IOException;

    void saveAll(List<Ticket> tickets) throws IOException;
}
