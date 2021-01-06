package ro.fasttrackit.salarizare.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.salarizare.exceptions.ResourceNotFoundException;
import ro.fasttrackit.salarizare.model.Salary;
import ro.fasttrackit.salarizare.repository.SalaryRepository;

import java.util.List;

@Service
public class SalaryService {
    private final SalaryRepository repository;

    public SalaryService(SalaryRepository repository) {
        this.repository = repository;
    }

    public List<Salary> getAll() {
        return repository.findAll();
    }

    public Salary getOne(Integer salaryId) {
        return repository.findById(salaryId)
                .orElseThrow(() -> new ResourceNotFoundException("Nu se gaseste salariatul cu id: " + salaryId));
    }

    public Salary add(Salary salary) {
        return repository.save(salary);
    }
}
