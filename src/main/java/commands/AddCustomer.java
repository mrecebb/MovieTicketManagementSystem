package commands;

import customers.Customer;
import customers.CustomerInputService;
import interfaces.Command;
import interfaces.CustomerRepository;

import java.io.IOException;
import java.util.List;

public class AddCustomer implements Command {
    CustomerInputService customerInputService;
    CustomerRepository customerRepository;

    public AddCustomer(CustomerRepository cr, CustomerInputService cis) {
        this.customerRepository = cr;
        this.customerInputService = cis;
    }

    @Override
    public String commandName() {
        return "Add Customer";
    }

    @Override
    public void process() throws IOException {
        List<Customer> customers = customerRepository.findAll();
        Customer.idCounter = customers.size();

        Customer customer = customerInputService.getInformation();
        customers.add(customer);

        customerRepository.saveAll(customers);
    }
}
