package com.myshop.online.controller;




import com.myshop.online.model.Person;
import com.myshop.online.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService service;

    @PostMapping ("/addPerson")
    public Person register(@RequestBody Person person){
        return service.registerUser(person);
    }


    @GetMapping ("/idperson/{id}")
    public Person findPersonById(@PathVariable int id){
        return  service.getPersonById(id);
    }

    @GetMapping ("/person/{name}")
    public Person findPersonByName(@PathVariable String name){
        return  service.getPersonByName(name);
    }

    @PutMapping ("/updateperson")
    public Person updatePerson(@RequestBody Person person){
        return service.updatePerson(person);
    }

    @DeleteMapping("/persondelete/{id}")
    public String deletePerson(@PathVariable int id){
        return  service.deletePerson(id);
    }
}

