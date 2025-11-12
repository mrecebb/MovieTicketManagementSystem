import commands.*;
import customers.CustomerInputService;
import interfaces.*;
import movie.MovieInputService;
import notifications.SendNotification;
import tickets.TicketInputService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    List<Command> commands;
    Scanner scanner;

    // object-leri CONSTRUCTOR INJECTION ile al (SOLID - O)
    UserInterface(
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

        commands.add(new AddMovie(mis, repo));
        commands.add(new ListMovies(repo));
        commands.add(new AddCustomer(cr, cus));
        commands.add(new PurchaseTicket(tr, tis, cr, scanner, sn));
        commands.add(new CancelTicket(tr, cr, scanner, sn));
        commands.add(new ListAllTickets(tr));
        commands.add(new ShowUserTickets(cr, tr, scanner));
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
