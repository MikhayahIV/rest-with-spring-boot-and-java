package khayah.rest_with_spring_boot_and_java.services;

import khayah.rest_with_spring_boot_and_java.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    public List<Person> findAll(){
        logger.info("Finding All Peoples");
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8 ; i++) {
            Person person = mockPerson(i);
            persons.add(person);
            
        }
        return persons;
    }

    public Person findById(String id){
        logger.info("Finding one Person");

        //mock
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("jay");
        person.setLastName("six");
        person.setAddress("São Paulo - SP - Brazil");
        person.setGender("Male");
        return person;
    }

    public Person create(Person person){
        logger.info("Creating one Person");
        return person;
    }

    public Person update(Person person){
        logger.info("Updating one Person");
        return person;
    }

    public void delete(String id){
        logger.info("Deleting one Person");
    }

    private Person mockPerson(int i) {
        //mock
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("FirstName" +i);
        person.setLastName("LastName"+i);
        person.setAddress("Some address in Brazil");
        person.setGender("Male");

        return person;
    }

}
