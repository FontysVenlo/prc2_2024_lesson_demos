/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package nl.fontys.zoodemo;

/**
 *
 * @author hvd
 * @param <A>
 */
public interface Animal<A extends Animal<A>> {
    
    A move();
    
}
