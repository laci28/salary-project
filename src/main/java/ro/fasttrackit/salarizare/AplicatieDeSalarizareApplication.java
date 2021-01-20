package ro.fasttrackit.salarizare;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.salarizare.model.Month;
import ro.fasttrackit.salarizare.model.Position;
import ro.fasttrackit.salarizare.model.Salary;
import ro.fasttrackit.salarizare.repository.SalaryRepository;

import java.util.List;

@SpringBootApplication
public class AplicatieDeSalarizareApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicatieDeSalarizareApplication.class, args);
	}

}
