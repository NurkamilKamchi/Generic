package Service.GenericImpl;

import DAO.impl.PersonDaoImpl;
import Gender.Gender;
import Service.GenercicService;
import models.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonServiceImpl implements GenercicService<Person> {

    private final PersonDaoImpl personDao;

    public PersonServiceImpl(PersonDaoImpl personDao) {
        this.personDao = personDao;
    }

    @Override
    public String add(List<Person> t) {
        personDao.getAll().addAll(t);
        return "Success added!!!";
    }
//    this.id = id;
//        this.name = name;
//        this.age = age;
//        this.gender = gender;

    @Override
    public Person getById(long id) {
        for (Person person : personDao.getAll()) {
            if (id == person.getId()){
                return person;
            }
        }
       throw new RuntimeException("Uncoorect id!!!");
    }

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }

    @Override
    public String remove(long id) {
        for (Person person : personDao.getAll()) {
            if (id == person.getId()){
                personDao.getAll().remove(person);
               return ("Success removed!!!");
            }
        }
        throw new RuntimeException("Uncorrect id!!!");
    }

    @Override
    public List<Person> sortByName(int i) {
        List<Person> all = personDao.getAll();
        if (i == 1){
            Comparator<Person> comparator = Comparator.comparing(Person::getName);
            all.sort(comparator);
        } else if (i == 2) {
            Comparator<Person> comparator = Comparator.comparing(Person::getName);
            all.sort(comparator.reversed());
        }
        return all;
    }

    @Override
    public List<Person> filterByGender(int i) {
        List<Person> personList = new ArrayList<>();
        if (i == 1){
            for (Person person : personDao.getAll()) {
                if ("male".equalsIgnoreCase(String.valueOf(person.getGender()))){
                     personList.add(person);
                }
            }
        } else if (i == 2) {
            for (Person person : personDao.getAll()) {
                if ("female".equalsIgnoreCase(String.valueOf(person.getGender()))){
                    personList.add(person);
                }
            }
        }
        return personList;
    }

    @Override
    public List<Person> clear() {
        personDao.getAll().clear();
        return personDao.getAll();
    }
}
