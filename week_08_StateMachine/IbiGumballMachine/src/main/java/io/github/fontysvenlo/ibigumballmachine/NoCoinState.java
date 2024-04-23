/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.fontysvenlo.ibigumballmachine;

/**
 *
 * @author ibrahimkouzak
 */
public class NoCoinState implements State {

    GumballMachine gumballMachine;

    public NoCoinState(GumballMachine gm) {
        this.gumballMachine = gm;
    }

    @Override
    public void insertCoin() {
        System.out.println("You inserted a quarter!");
        this.gumballMachine.setState(gumballMachine.hasCoinState);
    }

    @Override
    public String toString() {
        return "NoCoinState";
    }
}
