package ui;

import repository.CustomerRepository;
import repository.MovieRepository;
import repository.TicketRepository;
import service.CustomerInputService;
import service.MovieInputService;
import service.notifications.SendNotification;
import service.TicketInputService;
import ui.commands.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ConsoleUserInterface {
    List<Command> commands;
    Scanner scanner;

    // object-leri CONSTRUCTOR INJECTION ile al (SOLID - O)
    public ConsoleUserInterface(
            List<Command> commands,
            MovieInputService mis,
            TicketInputService tis,
            CustomerInputService cus,
            MovieRepository repo,
            TicketRepository tr,
            CustomerRepository cr,
            Scanner scanner,
            SendNotification sn
    ) {
        this.commands = commands;
        this.scanner = scanner;

        commands.add(new AddMovieCommand(mis, repo));
        commands.add(new ListMoviesCommand(repo));
        commands.add(new AddCustomerCommand(cr, cus));
        commands.add(new PurchaseTicketCommand(tr, tis, cr, scanner, sn));
        commands.add(new CancelTicketCommand(tr, cr, scanner, sn));
        commands.add(new ListAllTicketsCommand(tr));
        commands.add(new ShowUserTicketsCommand(cr, tr, scanner));
    }

    public void start() throws IOException {
        while (true) {
            printCommands();
            System.out.print("Select: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == commands.size() + 1) {
                break;
            }

            while (choice < 1 || choice > commands.size()) {
                System.out.print("Invalid choice: ");
                choice = scanner.nextInt();
            }

            commands.get(choice - 1).process();
        }
    }

    // istifadecinin ede bileceyi command-lari ekrana cap etdirir
    private void printCommands() {
        for (int i = 0; i < commands.size(); i++) {
            System.out.println((i + 1) + ". " + commands.get(i).commandName());
            if (i == commands.size() - 1) {
                System.out.println((i + 2) + ". Exit");
            }
        }
    }
}
