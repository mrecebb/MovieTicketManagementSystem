package movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.MovieRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonMovieRepository implements MovieRepository {
    private final File file;
    private final ObjectMapper mapper;

    // constructor injection
    public JsonMovieRepository(File file, ObjectMapper mapper) {
        this.file = file;
        this.mapper = mapper;
    }

    // butun elementleri json-dan list seklinde qaytar
    @Override
    public List<Movie> findAll() throws IOException {
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(mapper.readValue(file, Movie[].class)));
    }

    // verilen list-deki elementleri json-a yaz
    @Override
    public void saveAll(List<Movie> movies) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, movies);
    }
}
