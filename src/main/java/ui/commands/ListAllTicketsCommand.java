package ui.commands;

import repository.TicketRepository;
import domain.Ticket;

import java.io.IOException;
import java.util.List;

public class ListAllTicketsCommand implements Command {
    private final TicketRepository ticketRepository;

    public ListAllTicketsCommand(TicketRepository ticketRepository) {
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
