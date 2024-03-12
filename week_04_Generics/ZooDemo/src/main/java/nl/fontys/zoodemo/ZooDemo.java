/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package nl.fontys.zoodemo;

/**
 *
 * @author hvd
 */
public class ZooDemo {

    public static void main(String[] args) {

        Elephant e = new Elephant();
        e.drink();
        e.eat();
        
        e.drink().eat().drink().move().drink();
         
    }
}
