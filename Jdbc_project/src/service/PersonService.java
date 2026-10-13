package service;

import dao.PersonRepository;
import dto.Person;

import java.util.List;


public class PersonService {
    PersonRepository personRepository=new PersonRepository();

    public void insertPerson(Person person){
        personRepository.insertPerson(person);
    }

    public void updatePerson(int id,String name,int age){
        Person person =new Person();
        person.setName(name);
        person.setAge(age);
        personRepository.updatePerson(id,name,age);
    }

    public void deletePerson(int id){
        personRepository.deletePerson(id);
    }

    public List<Person> getPersons(){
        return personRepository.getPersons();

    }


}
