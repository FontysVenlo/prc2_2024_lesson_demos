package com.mycompany.classliststreamlambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author ibrahimkouzak
 */
public class ClassLiist {

    private final List<Person> persons = new ArrayList<>();

    public void addPersons(Person... personToAdd) {

        persons.addAll(Arrays.asList(personToAdd));
    }

    public List<Person> getPersons() {

        return new ArrayList<>(persons);
    }

    public List<Person> getPersonSortedByName() {

        List<Person> result = new ArrayList<>(persons);
        Comparator<Person> namComp = (p1, p2) -> p1.getName().compareTo(p2.getName());
        Collections.sort(result, namComp);
        return result;
    }

    public List<Person> getPersonSortedByLength() {

        List<Person> result = new ArrayList<>(persons);
        Collections.sort(result, (p1, p2) -> p1.getLength() - p2.getLength());
        return result;
    }

    public List<Person> getPersonSorted(Comparator<Person> comparator) {

        List<Person> result = new ArrayList<>(persons);
        Collections.sort(result, comparator);
        return result;
    }

    public List<Person> getPersonSortedUsingStream(Comparator<Person> comparator) {

        return persons.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Person> getMalePerson() {
        
        return persons.stream()
                .filter(p -> p.getGender() == Person.Gender.MALE)
                .collect(Collectors.toList());
    }
    
    public List<Person> getPersons(Predicate<Person> predicate) {
        
        return persons.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
    
    public double getAverageLength(Predicate<Person> predicate) {
        
        return persons.stream()
                .mapToInt(Person::getLength)
                .average()
                .getAsDouble();
    }
    
    public List<String> getNamesUpperCase() {
        
        return persons.stream()
                .map(p -> p.getName())
                .map(String::toUpperCase) //method refrences
                .collect(Collectors.toList());
    }
    
    public List<String> getAllUniqueHobbies() {
        
        return persons.stream()
                .flatMap(p -> Stream.of(p.getHobbies()))
                .distinct()
                .collect(Collectors.toList());
    }
}
