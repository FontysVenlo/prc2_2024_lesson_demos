/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nl.fontys;

/**
 *
 * @author hvd
 */
public class Main {
    
    public static void main(String[] args) {
        
        Person p = new Person("Max", "Verstappen");
        System.out.println("p = " + p);
        
        PersonRecord pr = new PersonRecord("Lewis", "Hamilton");
        System.out.println("FirstName = " + pr.firstName() + " and lastName = " + pr.lastName());
        System.out.println("pr = " + pr);
        
        var ferrariLewis = pr.withLastName("Ferrari");
        System.out.println("ferrariLewis = " + ferrariLewis);
        
    }
    
}
