import commands.AddMovie;
import commands.ListMovies;
import interfaces.Command;
import interfaces.MovieRepository;
import movie.MovieInputService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    List<Command> commands;
    Scanner scanner;

    // object-leri CONSTRUCTOR INJECTION ile al (SOLID - O)
    UserInterface(List<Command> commands, MovieInputService mis, MovieRepository repo, Scanner scanner) throws IOException {
        this.commands = commands;
        this.scanner = scanner;

        commands.add(new AddMovie(mis, repo));
        commands.add(new ListMovies(repo));
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
