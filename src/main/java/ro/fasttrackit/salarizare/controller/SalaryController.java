package ro.fasttrackit.salarizare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.salarizare.model.Salary;
import ro.fasttrackit.salarizare.service.SalaryService;

@RestController
@RequestMapping(path = "/api/salaries")
public class SalaryController {
    private final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @PostMapping
    Salary addSalary(@RequestBody Salary salary) {
        return salaryService.add(salary);
    }

    @PutMapping("{salaryId}")
    Salary addSalary(@PathVariable Integer salaryId, @RequestBody Salary salary) {
        return salaryService.replace(salaryId, salary);
    }

    @DeleteMapping("{salaryId}")
    Salary deleteSalary(@PathVariable Integer salaryId) {
        return salaryService.delete(salaryId);
    }
}
