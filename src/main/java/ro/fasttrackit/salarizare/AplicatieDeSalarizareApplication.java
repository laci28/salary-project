package ro.fasttrackit.salarizare;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.salarizare.model.Month;
import ro.fasttrackit.salarizare.model.Position;
import ro.fasttrackit.salarizare.model.Salary;
import ro.fasttrackit.salarizare.model.StateBudget;
import ro.fasttrackit.salarizare.repository.SalaryRepository;

import java.util.List;

@SpringBootApplication
public class AplicatieDeSalarizareApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicatieDeSalarizareApplication.class, args);
	}


	@Bean
	CommandLineRunner atStartup(SalaryRepository repo) {
		return args -> {
			repo.saveAll(List.of(
					new Salary("Buda Teofil", Position.PROGRAMATOR, Month.DECEMBRIE, 3760, 168, 0),
					new Salary("Petrila Ionel", Position.SOFER, Month.DECEMBRIE, 3588, 168, 0),
					new Salary("Coman Viorel", Position.MANIPULANT_MARFA, Month.DECEMBRIE, 4114, 168, 0),
					new Salary("Todoran Corina", Position.ADMINISTRATOR, Month.DECEMBRIE, 10000, 168, 0)
			));
		};
	}
}
