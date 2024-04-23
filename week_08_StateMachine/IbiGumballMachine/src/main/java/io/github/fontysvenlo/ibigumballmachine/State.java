/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.fontysvenlo.ibigumballmachine;

/**
 *
 * @author ibrahimkouzak
 */
public interface  State {

    default void insertCoin() {
        System.out.println("insertCoin transaction is not supported in this state");
    }

    default void turnCrank() {
        System.out.println("turnCrank transaction is not supported in this state");
    }

    default void ejectCoin() {
        System.out.println("ejectCoin transaction is not supported in this state");
    }

    default void dispense() {
        System.out.println("dispense transaction is not supported in this state");
    }

}
