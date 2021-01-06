package ro.fasttrackit.salarizare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.salarizare.model.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {
}
