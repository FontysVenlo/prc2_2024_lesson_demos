/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mockingdemo;

import java.util.List;

/**
 *
 * @author hvd
 */
@FunctionalInterface
public interface DatabaseService {

    List<Person> getPersons();
    
}
