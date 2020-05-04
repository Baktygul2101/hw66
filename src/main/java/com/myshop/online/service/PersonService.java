package com.myshop.online.service;


import com.myshop.online.model.Person;
import com.myshop.online.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public Person registerUser(Person person){
        return repository.save(person);
    }

      public Person getPersonById(int id){
        return repository.findAllById(id).orElse(null);
    }

    public Person getPersonByName(String name){
        return repository.findByName(name);
    }


    public String deletePerson(int id){
        repository.deleteById(id);
        return "person removed!!"+id;
    }

    public Person updatePerson(Person person){
        Person existingPerson=repository.findById(person.getId()).orElse(null);
        existingPerson.setName(person.getName());
        existingPerson.setAge(person.getAge());
        existingPerson.setEmail(person.getEmail());
        return repository.save(existingPerson);
    }
}
