package com.mycompany.classliststreamlambda;

/**
 *
 * @author ibrahimkouzak
 */
public class Person {
    
    public enum Gender {FEMALE, MALE, NEUTRAL}
    
    private final String name;
    private final int length;
    private final Gender gender;
    private final boolean active;
    private final String[] hobbies;

    public Person(String name, int length, Gender gender, boolean active, String... hobbies) {
        this.name = name;
        this.length = length;
        this.gender = gender;
        this.active = active;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isActive() {
        return active;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    
}
