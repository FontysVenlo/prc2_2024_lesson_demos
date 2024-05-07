package io.github.fontysvenlo.reflection.demo;

/**
 *
 * @author bonajo
 */
public class Student {

    private final String name;

    @Hidden("rumpelstiltskin")
    private final String hiddenName = "How?";

    public Student(){
        this("John Doe");
    }

    /**
     *
     * @param name
     */
    public Student(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public static void sayHello(){
        System.out.println("Hello world!");
    }
    
    public static void sayHello(String to){
        System.out.println("Hello " + to);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
