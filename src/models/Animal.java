package models;

import Gender.Gender;

public class Animal {
    private long id;
    private String name;
    private int age;
    private Gender gender;

    public Animal() {
    }

    public Animal(long id, String name, int age, Gender gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
//3) model пакеттин ичине Person, Animal деген класс тузунуз, свойствалары - id, name, age, Gender .
//- Genderди enum кылып башка пакетке тузуп койсонуз болот.
