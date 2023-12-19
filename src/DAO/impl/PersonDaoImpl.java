package DAO.impl;

import DAO.GenericDao;
import Database.Database;
import models.Person;

import java.util.List;

public class PersonDaoImpl implements GenericDao<Person, Long> {

    private final Database database;

    public PersonDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public List<Person> getAll() {
        return database.getPeople();
    }

    @Override
    public Person getById(Long aLong) {
        for (Person person : database.getPeople()) {
            if (aLong.equals(person.getId())) {
                return person;
            }
        }
        throw new RuntimeException();
    }

    @Override
    public boolean add(Person person) {
        return database.add(person);
    }

    @Override
    public boolean remove(Long aLong) {
        for (Person person : database.getPeople()) {
            if (aLong.equals(person.getId())){
                return database.getPeople().remove(person);
            }
        }
        throw new RuntimeException();
    }
}
