import DAO.impl.AnimalDaoImpl;
import DAO.impl.PersonDaoImpl;
import Database.Database;
import Gender.Gender;
import Service.GenercicService;
import Service.GenericImpl.AnimalServiceImpl;
import Service.GenericImpl.PersonServiceImpl;
import models.Animal;
import models.Person;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerForNum = new Scanner(System.in);
        Database database = new Database();

        GenercicService<Person> personGenericService = new PersonServiceImpl(new PersonDaoImpl(database));
        GenercicService<Animal> animalGenercicService = new AnimalServiceImpl(new AnimalDaoImpl(database));
        while (true) {
            System.out.println("""
                    1.Add person.
                    2.Add animal.
                    3.Get person by id .
                    4.Get animal by id .
                    5.Get all people.
                    6.Get all animals.
                    7.Remove person.
                    8.Remove animal.
                    9.Sort by people name.
                    10.Sort by animals name.
                    11.Filter by person gender.
                    12.Filter by animal gender.
                    13.Clear people.
                    14.Clear animals.
                    15.Exit.
                    """);
            switch (scanner.nextLine()) {
                case "1" -> {
                    List<Person> personList = new ArrayList<>(Arrays.asList(
                            new Person(1L, "Nurkamil", 22, Gender.MALE),
                            new Person(2L, "Nurislam", 25, Gender.MALE),
                            new Person(3L, "Anna", 18, Gender.FEMALE)
                    ));
                    System.out.println(personGenericService.add(personList));
                }
                case "2" -> {
                    List<Animal> animalList = new ArrayList<>(Arrays.asList(
                            new Animal(1L, "Cat", 5, Gender.MALE),
                            new Animal(2L, "Dog", 8, Gender.FEMALE),
                            new Animal(3L, "Cow", 15, Gender.MALE)
                    ));
                    System.out.println(animalGenercicService.add(animalList));
                }
                case "3" -> {
                    try {
                        System.out.print("Enter peraon's id: ");
                        long id = scannerForNum.nextLong();
                        System.out.println(personGenericService.getById(id));
                    }catch (RuntimeException e){
                        System.out.println("Incorrect type");
                    }

                }case "4"->{
                    try {
                        System.out.println(animalGenercicService.getById(1L));
                    }catch (RuntimeException e ){
                        System.out.println("Incorrect type!!!");
                    }
                }case"5"->{
                    System.out.println(personGenericService.getAll());
                }case"6"->{
                    System.out.println(animalGenercicService.getAll());
                }case "7"->{
                    try {
                        System.out.print("Enter person's id: ");
                        long id = scannerForNum.nextLong();
                        System.out.println(personGenericService.remove(id));
                    }catch (RuntimeException e ){
                        System.out.println("Uncorrect type!!!");
                    }

                }case "8"->{
                    try {
                        System.out.print("Enter animal's id: ");
                        long id = scannerForNum.nextLong();
                        System.out.println(animalGenercicService.remove(id));
                    }catch (RuntimeException e ){
                        System.out.println("Invalid type!!!");
                    }

                }case"9"->{
                    try {
                        System.out.println("Enter 1 (ask)/ 2 (desc)");
                        int i = scannerForNum.nextInt();
                        System.out.println(personGenericService.sortByName(i));
                    }catch (RuntimeException e){
                        System.out.println("Incorrect type!!!");
                    }
                }case "10"->{
                    try {
                        System.out.println("Enter 1 (ask)/ 2 (desc): ");
                        int i = scannerForNum.nextInt();
                        System.out.println(animalGenercicService.sortByName(i));
                    }catch (RuntimeException e){
                        System.out.println("Incorrect animal type!!!");
                    }
                }case"11"->{
                    try {
                        System.out.print("Enter gender 1  (male)/ 2 (feamle): ");
                        int i = scannerForNum.nextInt();
                        System.out.println(personGenericService.filterByGender(i));
                    }catch (RuntimeException e){
                        System.out.print("Uncorrect person type!!!");
                    }
                }case"12"->{
                    try {
                        System.out.println("Enter gender 1  (male)/ 2 (feamle):  ");
                        int i = scannerForNum.nextInt();
                        System.out.println(animalGenercicService.filterByGender(i));
                    }catch (RuntimeException e){
                        System.out.println("Uncorrect animal type!!!");
                    }
                }case "13"->{
                    System.out.println(personGenericService.clear());
                }case "14"->{
                    System.out.println(animalGenercicService.clear());
                }case "15"->{
                    System.exit(0);
                }
            }
        }
    }
}
//1) Жаны проект тузунуз.
// 2) 3 жаны пакет тузунуз - model, dao, service
// 3) model пакеттин ичине Person, Animal деген класс тузунуз, свойствалары - id, name, age, Gender .
//- Genderди enum кылып башка пакетке тузуп койсонуз болот.
// 5) service пакеттин ичине GenericService деген generic interface тузунуз жана impl деген пакет тузуп коюнуз.
// 6) GenericServiceтин ичинде 7 метод болот:
// String add(List<T>t);
// T getById(Long id);
// List<T> getAll();
// List<T> sortByName(); 1 ди басканда ascending, 2 ни басканда descending кылып сорттосун
// List<T> filterByGender(); 1 ди басканда female, 2 ни басканда male кылып фильтрлесин
//List<T> clear();
//7) impl пакеттин ичине PersonServiceImpl, AnimalServiceImpl деген класстарды тузунуз, бул класстар GenericService интерфейсин ишке ашырат .
//9) Main класста бардык методдорду чакырып иштетиниз.