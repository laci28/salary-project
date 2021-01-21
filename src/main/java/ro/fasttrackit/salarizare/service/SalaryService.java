package ro.fasttrackit.salarizare.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ro.fasttrackit.salarizare.exceptions.ResourceNotFoundException;
import ro.fasttrackit.salarizare.model.Salary;
import ro.fasttrackit.salarizare.repository.SalaryRepository;

import java.util.Optional;

@Service
public class SalaryService {
    private final SalaryRepository repository;

    public SalaryService(SalaryRepository repository) {
        this.repository = repository;
    }

    public Iterable<Salary> getAll() {
        return repository.findAll(Sort.by("name"));
    }

    public Salary getOne(Integer salaryId) {
        return repository.findById(salaryId)
                .orElseThrow(() -> new ResourceNotFoundException("Nu se gaseste salariatul cu id: " + salaryId));
    }

    public Salary add(Salary salary) {
        Salary s = new Salary(salary.getName(), salary.getPosition(), salary.getMonth(),
                salary.getGrossSalary(), salary.getHoursWorked(), salary.getOvertime(),
                salary.getPersoaneInIntretinere());
        return repository.save(s);
    }

    public Salary replace(Integer salaryId, Salary salary) {
        salary.setId(salaryId);
        Optional<Salary> dbSalary = repository.findById(salaryId);
        dbSalary.ifPresent(repository::delete);
        return repository.save(new Salary(salary.getName(), salary.getPosition(), salary.getMonth(),
                salary.getGrossSalary(), salary.getHoursWorked(), salary.getOvertime(),
                salary.getPersoaneInIntretinere()));
    }

    public Salary delete(Integer salaryId) {
        Optional<Salary> dbSalary = repository.findById(salaryId);
        dbSalary.ifPresent(repository::delete);
        return dbSalary.orElse(null);
    }
}
