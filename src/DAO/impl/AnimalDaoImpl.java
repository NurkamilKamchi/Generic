package DAO.impl;

import DAO.GenericDao;
import Database.Database;
import models.Animal;

import java.util.List;

public class AnimalDaoImpl implements GenericDao<Animal, Long> {

    private final Database database;

    public AnimalDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public List<Animal> getAll() {
        return database.getAnimals();
    }

    @Override
    public Animal getById(Long aLong) {
        for (Animal animal : database.getAnimals()) {
            if (aLong.equals(animal.getId())){
                return animal;
            }
        }
        throw new RuntimeException("Uncorrect!");
    }

    @Override
    public boolean add(Animal animal) {
        return database.getAnimals().add(animal);
    }

    @Override
    public boolean remove(Long aLong) {
        for (Animal animal : database.getAnimals()) {
            if (aLong.equals(animal.getId())){
                return database.getAnimals().remove(animal);
            }
        }
        throw new RuntimeException("Uncorrecrt");
    }
}
