package ro.fasttrackit.salarizare.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.fasttrackit.salarizare.service.SalaryService;

@Controller
@RequestMapping("salaries")
public class SalaryUIController {
    private final SalaryService salaryService;

    public SalaryUIController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping
    String getSalariesPage(Model pageModel) {
        pageModel.addAttribute("salaries", salaryService.getAll());
        return "salaries";
    }

    @GetMapping("{salaryId}")
    String getSalariesPage(Model pageModel, @PathVariable Integer salaryId) {
        pageModel.addAttribute("showDetails", true);
        pageModel.addAttribute("showMonth", true);
        pageModel.addAttribute("selectedSalary", salaryService.getOne(salaryId));
        pageModel.addAttribute("salaries", salaryService.getAll());
        return "salaries";
    }
}
