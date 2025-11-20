package ui.commands;

import util.Check;
import domain.Customer;
import exceptions.NotFoundException;
import repository.CustomerRepository;
import repository.TicketRepository;
import domain.Ticket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShowUserTicketsCommand implements Command {
    CustomerRepository customerRepository;
    TicketRepository ticketRepository;
    Scanner scanner;

    public ShowUserTicketsCommand(CustomerRepository cr, TicketRepository tr, Scanner sc) {
        this.customerRepository = cr;
        this.ticketRepository = tr;
        this.scanner = sc;
    }

    @Override
    public String commandName() {
        return "Show My Tickets";
    }

    @Override
    public void process() throws IOException {
        List<Customer> customers = customerRepository.findAll();
        List<Ticket> tickets = ticketRepository.findAll();
        List<Ticket> foundedTickets = new ArrayList<>();

        System.out.print("Please enter the username id you want to show this ticket:");
        long id = Integer.parseInt(scanner.nextLine());
        if (Check.CustomerExistsWithId(customers, id)) {
            throw new NotFoundException("Customer with id " + id + " not found");
        }

        boolean found = false;
        for (Ticket ticket : tickets) {
            if (ticket.getCustomerId() == id) {
                foundedTickets.add(ticket);
                found = true;
            }
        }

        if (!found) {
            throw new NotFoundException("Can't found any ticket");
        }

        System.out.println("You have " + foundedTickets.size() + " tickets: ");
        for (Ticket ticket : foundedTickets) {
            System.out.println(ticket);
        }


    }
}
