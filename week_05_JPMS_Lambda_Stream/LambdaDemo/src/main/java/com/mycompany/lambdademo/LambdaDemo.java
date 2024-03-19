/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lambdademo;

/**
 *
 * @author ibrahimkouzak
 */
public class LambdaDemo {

    public static void main(String[] args) {
        
        MyConsumer mc = s -> System.out.println(s);
        
        mc.doWork("Hello World!");
        
//        
//        MyConsumer mc1 = new MyConsumer() {
//            @Override
//            public void doWork(String s) {
//                System.out.println(s);
//            }
//        };
//        
//        mc1.doWork("Hello from the anonymous class");

    }
}
