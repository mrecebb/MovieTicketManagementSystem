package commands;

import interfaces.Command;
import interfaces.TicketRepository;
import tickets.Ticket;
import tickets.TicketInputService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PurchaseTicket implements Command {
    TicketRepository ticketRepo;
    TicketInputService ticketInputService;
    Scanner scanner;

    public PurchaseTicket(TicketRepository tr, TicketInputService tis, Scanner sc) {
        this.ticketRepo = tr;
        this.ticketInputService = tis;
        this.scanner = sc;
    }

    @Override
    public String commandName() {
        return "Purchase Ticket";
    }

    @Override
    public void process() throws IOException {
        List<Ticket> tickets = ticketRepo.findAll();
        if(!tickets.isEmpty())
            Ticket.idCounter = tickets.getLast().getId(); // idCounteri son elementin id-sine beraber et

        Ticket ticket = ticketInputService.getInformation();

        tickets.add(ticket);
        ticketRepo.saveAll(tickets);
    }
}
