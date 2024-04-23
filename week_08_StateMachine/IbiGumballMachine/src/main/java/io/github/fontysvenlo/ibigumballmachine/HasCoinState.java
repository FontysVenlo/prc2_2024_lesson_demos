/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.fontysvenlo.ibigumballmachine;

import java.util.Random;

/**
 *
 * @author ibrahimkouzak
 */
public class HasCoinState implements State {

    int winner = 0;
    GumballMachine gumballMachine;

    public HasCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned!!!");
        if (winner % 10 == 0 && winner != 0) {
            this.gumballMachine.setState(gumballMachine.winnerState);
            winner ++;
        } else {
            this.gumballMachine.setState(gumballMachine.soldState);
            winner ++;
        }
    }

    @Override
    public void ejectCoin() {
        System.out.println("The coin is being ejected.");
        this.gumballMachine.setState(gumballMachine.noCoinState);
    }

    @Override
    public String toString() {
        return "HasCoinState";
    }
}
