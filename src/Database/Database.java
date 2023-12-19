package Database;

import models.Animal;
import models.Person;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Animal> animals = new ArrayList<>();

    private List<Person> people = new ArrayList<>();

    public List<Person> getPeople() {
        return people;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public <T> boolean add(T t){
        if (t instanceof Animal){
            return animals.add((Animal) t);
        } else if (t instanceof Person) {
            return people.add((Person) t);
        }
        throw new RuntimeException("Incorrect type!");
    }


    public <T> boolean remove(T t){
        if (t instanceof Animal){
            return animals.remove(t);
        } else if (t instanceof Person) {
            return people.remove(t);
        }
        throw new RuntimeException("Uncorrect type!!!");
    }
}
