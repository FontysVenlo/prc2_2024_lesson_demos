/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.fontysvenlo.ibigumballmachine;

/**
 *
 * @author ibrahimkouzak
 */
public class GumballMachine {

    State soldOutState;
    State noCoinState;
    State hasCoinState;
    State soldState;
    State winnerState;

    State state;

    private int numberGumballs = 0;

    private GumballMachine(int numberGumballs) {
        this.numberGumballs = numberGumballs;
    }

    private GumballMachine init() {
        this.soldOutState = new SoldOutState(this);
        this.noCoinState = new NoCoinState(this);
        this.hasCoinState = new HasCoinState(this);
        this.soldState = new SoldState(this);
        this.winnerState = new WinnerState(this);
        if (numberGumballs > 0) {
            state = noCoinState;
        } else {
            state = soldOutState;
        }
        return this;
    }

    public static GumballMachine create(int numberOfBalls) {
        return new GumballMachine(numberOfBalls).init();
    }

    public int getNumberGumballs() {
        return numberGumballs;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void insertCoin() {
        this.state.insertCoin();
    }

    public void ejectCoin() {
        this.state.ejectCoin();
    }

    public void turnCrank() {
        this.state.turnCrank();
        this.state.dispense();
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot!!!");
        if (this.numberGumballs != 0) {
            this.numberGumballs = numberGumballs - 1;
        }
    }

    @Override
    public String toString() {
        return "GumballMachine{" + "state=" + state + ", count=" + numberGumballs + '}';
    }

}
