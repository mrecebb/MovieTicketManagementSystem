package commands;

import customers.Customer;
import enums.TicketStatus;
import exceptions.AlreadyCancelledException;
import exceptions.TicketNotFoundException;
import interfaces.Command;
import interfaces.CustomerRepository;
import interfaces.Notification;
import interfaces.TicketRepository;
import notifications.SendNotification;
import tickets.Ticket;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CancelTicket implements Command {
    TicketRepository ticketRepository;
    CustomerRepository customerRepository;
    Scanner scanner;
    SendNotification sendNotification;

    public CancelTicket(TicketRepository tr, CustomerRepository cr, Scanner sc, SendNotification not) {
        this.ticketRepository = tr;
        this.customerRepository = cr;
        this.scanner = sc;
        this.sendNotification = not;
    }

    @Override
    public String commandName() {
        return "Cancel Ticket";
    }

    @Override
    public void process() throws IOException {
        List<Ticket> tickets = ticketRepository.findAll();
        List<Customer> customers = customerRepository.findAll();
        Ticket foundedTicket = null;

        System.out.print("Please enter the id of the ticket you would like to cancel: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean found = false;
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                if (ticket.getStatus() != TicketStatus.CANCELLED) {
                    ticket.setStatus(TicketStatus.CANCELLED);
                    foundedTicket = ticket;
                    found = true;
                } else {
                    throw new AlreadyCancelledException("Ticket already cancelled");
                }
            }
        }

        if (!found) {
            throw new TicketNotFoundException("Ticket id " + id + " not found");
        }

        ticketRepository.saveAll(tickets);

        // send notification
        for (Customer customer : customers) {
            if (customer.getId() == foundedTicket.getCustomerId()) {
                Notification notification = sendNotification.execute(customer);
                notification.cancelTicket(customer);
                break;
            }
        }
    }
}
