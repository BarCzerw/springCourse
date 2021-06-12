package com.sda.demo.welcomethymleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@Slf4j
public class PersonRestController {

    private final PersonRepo personRepo;

    private final PersonDefaultConfiguration personDefaultConfiguration;

    public PersonRestController(PersonRepo personRepo, PersonDefaultConfiguration personDefaultConfiguration) {
        this.personRepo = personRepo;
        this.personDefaultConfiguration = personDefaultConfiguration;
    }

    @RequestMapping(method = RequestMethod.GET, path = "person/addForm")
    public String showPersonForm(Model model) {
        model.addAttribute("person", new PersonDTO());
        return "personForm";
    }

    @RequestMapping(method = RequestMethod.GET, path = "person/addForm/{id}")
    public String showPersonForm(Model model, @PathVariable Long id) {
        Optional<Person> personOptional = personRepo.findById(id);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            PersonDTO personDTO = PersonDTO.builder()
                    .personId(person.getPersonId())
                    .firstName(person.getFirstName())
                    .lastName(person.getLastName())
                    .age(person.getAge())
                    .build();
            model.addAttribute("person", personDTO);
        } else {
            model.addAttribute("person", new PersonDTO());
        }
        return "personForm";
    }


    @RequestMapping(method = RequestMethod.POST, path= "person/add")
    @ResponseBody
    public Person addPerson(@Valid @ModelAttribute("person") PersonDTO personDTO) {
        Person person;
        if (personDTO.getPersonId() == null) {
            person = new Person(personDTO);
        } else {
            person = personRepo.findById(personDTO.getPersonId()).get();
            person.setFirstName(personDTO.getFirstName());
            person.setLastName(personDTO.getLastName());
            person.setAge(personDTO.getAge());
        }
        return personRepo.save(person);
    }

    @RequestMapping(method = RequestMethod.GET, path = "person/{id}")
    public String showPerson(ModelMap model, @PathVariable Long id) {
        Optional<Person> personOptional = personRepo.findById(id);
        Person person;
        if (personOptional.isPresent()) {
            person = personOptional.get();
        } else {
            person = Person.builder()
                    .firstName(personDefaultConfiguration.getDefaultFirstName())
                    .lastName(personDefaultConfiguration.getDefaultLastName())
                    .age(personDefaultConfiguration.getDefaultAge())
                    .build();
            log.warn("Person id:{} not found!", id);
        }
        model.addAttribute("person", person);
        return "personView";
    }
}
