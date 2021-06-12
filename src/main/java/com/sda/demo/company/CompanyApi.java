package com.sda.demo.company;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyApi {

    private final CompanyRepo companyRepo;

    @Autowired
    public CompanyApi(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @PostMapping("/add")
    public void addCompany(@Valid @RequestBody CompanyDTO companyDTO) {
        companyRepo.save(new Company(companyDTO));
    }

    @GetMapping("/list")
    public List<Company> showAllCompanies() {
        return companyRepo.findAll();
    }

    @PutMapping("/edit/{id}")
    public Company editCompany(@PathVariable Long id, @Valid @RequestBody CompanyDTO companyDTO) {
        Optional<Company> company = companyRepo.findById(id);
        if (company.isPresent()) {
            Company newCompany = company.get();
            newCompany.setFromDto(companyDTO);
            return companyRepo.save(newCompany);
        } else {
            log.warn("Company id:{} was not found in database", id);
            throw new CompanyNotFoundException();
        }
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Company not found!")
    @ExceptionHandler(RuntimeException.class)
    public void handleError() {
        log.error("Company of given id does not exist in database");
    }

}
