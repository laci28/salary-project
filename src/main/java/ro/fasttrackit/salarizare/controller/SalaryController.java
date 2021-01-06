package ro.fasttrackit.salarizare.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.salarizare.model.Salary;
import ro.fasttrackit.salarizare.service.SalaryService;

@RestController
@RequestMapping("/api/salaries")
public class SalaryController {
    private final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @PostMapping
    Salary addSalary(@RequestBody Salary salary) {
        return salaryService.add(salary);
    }
}
