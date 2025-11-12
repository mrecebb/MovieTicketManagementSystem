package commands;

import interfaces.Command;
import interfaces.TicketRepository;
import tickets.Ticket;

import java.io.IOException;
import java.util.List;

public class ListAllTickets implements Command {
    private final TicketRepository ticketRepository;

    public ListAllTickets(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public String commandName() {
        return "List All Tickets";
    }

    @Override
    public void process() throws IOException {
        List<Ticket> tickets = ticketRepository.findAll();

        if (tickets.isEmpty()) {
            System.out.println("No tickets found");
            return;
        }

        tickets.forEach(System.out::println);
    }
}
