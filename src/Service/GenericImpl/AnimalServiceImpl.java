package Service.GenericImpl;

import DAO.impl.AnimalDaoImpl;
import Service.GenercicService;
import models.Animal;
import models.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnimalServiceImpl implements GenercicService<Animal> {

    private final AnimalDaoImpl animalDao;

    public AnimalServiceImpl(AnimalDaoImpl animalDao) {
        this.animalDao = animalDao;
    }


    @Override
    public String add(List<Animal> t) {
        animalDao.getAll().addAll(t);
        return "Success added!";
    }

    @Override
    public Animal getById(long id) {
        for (Animal animal : animalDao.getAll()) {
            if (id == animal.getId()){
                return animal;
            }
        }
        throw new RuntimeException("Uncoorect id!!!");
    }

    @Override
    public List<Animal> getAll() {
        return animalDao.getAll();
    }

    @Override
    public String remove(long id) {
        for (Animal animal : animalDao.getAll()) {
            if (id == animal.getId()){
                animalDao.getAll().remove(animal);
               return ("Success removed!!!");

            }
        }
        throw new RuntimeException("Uncorrect id!!!");
    }

    @Override
    public List<Animal> sortByName(int i) {
        List<Animal> all = animalDao.getAll();
        if (i == 1) {
            Comparator<Animal> comparator = Comparator.comparing(Animal::getName);
            all.sort(comparator);
        } else if (i == 2) {
            Comparator<Animal> comparator = Comparator.comparing(Animal::getName);
            all.sort(comparator.reversed());
        }
        return all;
    }

    @Override
    public List<Animal> filterByGender(int i) {
        List<Animal> animals = new ArrayList<>();
        if (i == 1){
            for (Animal animal : animalDao.getAll()) {
                if ("male".equalsIgnoreCase(String.valueOf(animal.getGender()))){
                    animals.add(animal);
                }
            }
        } else if (i == 2) {
            for (Animal animal : animalDao.getAll()) {
                if ("female".equalsIgnoreCase(String.valueOf(animal.getGender()))){
                    animals.add(animal);
                }
            }
        }
        return animals;
    }

    @Override
    public List<Animal> clear() {
        animalDao.getAll().clear();
        return animalDao.getAll();
    }
}
