package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Customer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonCustomerRepository implements CustomerRepository {
    File file;
    ObjectMapper mapper;

    public JsonCustomerRepository(File file, ObjectMapper mapper) {
        this.file = file;
        this.mapper = mapper;
    }

    @Override
    public List<Customer> findAll() throws IOException {
        if(!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        } else {
            return new ArrayList<>(Arrays.asList(mapper.readValue(file,Customer[].class)));
        }
    }

    @Override
    public void saveAll(List<Customer> customers) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, customers);
    }
}
