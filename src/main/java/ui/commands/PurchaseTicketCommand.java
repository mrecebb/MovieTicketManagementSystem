package ui.commands;

import domain.Customer;
import repository.CustomerRepository;
import service.notifications.Notification;
import repository.TicketRepository;
import service.notifications.SendNotification;
import domain.Ticket;
import service.TicketInputService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PurchaseTicketCommand implements Command {
    TicketRepository ticketRepo;
    TicketInputService ticketInputService;
    Scanner scanner;
    CustomerRepository customerRepo;
    SendNotification sendNotification;

    public PurchaseTicketCommand(TicketRepository tr, TicketInputService tis, CustomerRepository cr, Scanner sc, SendNotification not) {
        this.ticketRepo = tr;
        this.ticketInputService = tis;
        this.scanner = sc;
        this.customerRepo = cr;
        this.sendNotification = not;
    }

    @Override
    public String commandName() {
        return "Purchase Ticket";
    }

    @Override
    public void process() throws IOException {
        List<Ticket> tickets = ticketRepo.findAll();
        List<Customer> customers = customerRepo.findAll();
        if(!tickets.isEmpty())
            Ticket.idCounter = tickets.getLast().getId(); // idCounteri son elementin id-sine beraber et

        Ticket ticket = ticketInputService.getInformation();

        tickets.add(ticket);
        ticketRepo.saveAll(tickets);

        // send notification
        for (Customer customer : customers) {
            if (customer.getId() == ticket.getCustomerId()) {
                Notification notification = sendNotification.execute(customer);
                notification.purchasedTicket(customer);
                break;
            }
        }
    }
}
