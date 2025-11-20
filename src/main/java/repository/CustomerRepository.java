package repository;

import domain.Customer;

import java.io.IOException;
import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll() throws IOException;

    void saveAll(List<Customer> customers) throws IOException;
}
